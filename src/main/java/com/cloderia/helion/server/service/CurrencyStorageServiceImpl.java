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

import com.cloderia.helion.client.shared.model.Currency;
import com.cloderia.helion.client.shared.operation.CurrencyOperation;
import com.cloderia.helion.client.shared.operation.Operation;
import com.cloderia.helion.client.shared.service.CurrencyStorageService;

/**
 * @author Adrian Haldermann
 */
@Stateless
public class CurrencyStorageServiceImpl implements CurrencyStorageService {

	@Inject
	private CurrencyEntityService entityService;

	@Inject
	@Operation(CREATE)
	private Event<CurrencyOperation> createSuccessfulEvent;

	@Inject
	@Operation(CREATE_FAILED)
	private Event<CurrencyOperation> createFailedEvent;

	@Inject
	@Operation(UPDATE)
	private Event<CurrencyOperation> updated;

	@Inject
	@Operation(DELETE)
	private Event<Long> deleted;

	@Override
	public List<Currency> findAll() {
		return entityService.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.CurrencyStorageService#findByCode(java.lang.String)
	 */
	public Currency findByCode(String code){
		try {
			return entityService.findByCode(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.CurrencyStorageService#create(com.cloderia.helion.client.shared.operation.CurrencyOperation)
	 */
	@Override
	public Response create(final CurrencyOperation currencyOperation) {
		try {
			entityService.create(currencyOperation);
			createSuccessfulEvent.fire(currencyOperation);
			return Response.created(UriBuilder.fromResource(CurrencyStorageService.class)
					.path(String.valueOf(currencyOperation.getData().getId())).build()).build();
		} catch (Exception e) {
			e.printStackTrace();
			createFailedEvent.fire(currencyOperation);
		}
		return Response.noContent().build();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.CurrencyStorageService#update(com.cloderia.helion.client.shared.operation.CurrencyOperation)
	 */
	@Override
	public Response update(final CurrencyOperation currencyOperation) {
		entityService.update(currencyOperation.getData());
		// This event is delivered to call connected clients.
		updated.fire(currencyOperation);
		return Response.noContent().build();
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.CurrencyStorageService#delete(java.lang.Long)
	 */
	@Override
	public Response delete(Long id) {
		entityService.delete(id);
		// This event is delivered to call connected clients.
		deleted.fire(id);
		return Response.noContent().build();
	}
	

}
