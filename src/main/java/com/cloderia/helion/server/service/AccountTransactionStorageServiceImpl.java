/**
 * Copyright (C) 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cloderia.helion.server.service;

import static com.cloderia.helion.client.shared.operation.Operation.OperationType.CREATE;
import static com.cloderia.helion.client.shared.operation.Operation.OperationType.CREATE_FAILED;
import static com.cloderia.helion.client.shared.operation.Operation.OperationType.DELETE;
import static com.cloderia.helion.client.shared.operation.Operation.OperationType.UPDATE;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.cloderia.helion.client.shared.model.AccountTransaction;
import com.cloderia.helion.client.shared.operation.AccountTransactionOperation;
import com.cloderia.helion.client.shared.operation.Operation;
import com.cloderia.helion.client.shared.service.AccountTransactionStorageService;

/**
 * @author Adrian Haldermann
 */
@Stateless
public class AccountTransactionStorageServiceImpl implements AccountTransactionStorageService {

	@Inject
	private AccountTransactionEntityService entityService;

	@Inject
	@Operation(CREATE)
	private Event<AccountTransactionOperation> createSuccessfulEvent;

	@Inject
	@Operation(CREATE_FAILED)
	private Event<AccountTransactionOperation> createFailedEvent;

	@Inject
	@Operation(UPDATE)
	private Event<AccountTransactionOperation> updated;

	@Inject
	@Operation(DELETE)
	private Event<Long> deleted;

	@Override
	public List<AccountTransaction> findAll() {
		return entityService.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.AccountTransactionStorageService#findByCode(java.lang.String)
	 */
	public AccountTransaction findByCode(String code){
		try {
			return entityService.findByCode(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.AccountTransactionStorageService#create(com.cloderia.helion.client.shared.operation.AccountTransactionOperation)
	 */
	@Override
	public Response create(final AccountTransactionOperation accountTransactionOperation) {
		try {
			entityService.create(accountTransactionOperation);
			createSuccessfulEvent.fire(accountTransactionOperation);
			return Response.created(UriBuilder.fromResource(AccountTransactionStorageService.class)
					.path(String.valueOf(accountTransactionOperation.getData().getId())).build()).build();
		} catch (Exception e) {
			e.printStackTrace();
			createFailedEvent.fire(accountTransactionOperation);
		}
		return Response.noContent().build();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.AccountTransactionStorageService#update(com.cloderia.helion.client.shared.operation.AccountTransactionOperation)
	 */
	@Override
	public Response update(final AccountTransactionOperation accountTransactionOperation) {
		entityService.update(accountTransactionOperation.getData());
		// This event is delivered to call connected clients.
		updated.fire(accountTransactionOperation);
		return Response.noContent().build();
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.AccountTransactionStorageService#delete(java.lang.Long)
	 */
	@Override
	public Response delete(Long id) {
		entityService.delete(id);
		// This event is delivered to call connected clients.
		deleted.fire(id);
		return Response.noContent().build();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.AccountTransactionStorageService#findByType(java.lang.String)
	 */
	@Override
	public List<AccountTransaction> findByType(String accountTransactionTypeCode){
		return entityService.findByType(accountTransactionTypeCode);
	}
	

}
