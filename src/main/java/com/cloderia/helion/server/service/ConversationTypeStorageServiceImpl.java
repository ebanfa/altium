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

import com.cloderia.helion.client.shared.model.ConversationType;
import com.cloderia.helion.client.shared.operation.ConversationTypeOperation;
import com.cloderia.helion.client.shared.operation.Operation;
import com.cloderia.helion.client.shared.service.ConversationTypeStorageService;

/**
 * @author Adrian Haldermann
 */
@Stateless
public class ConversationTypeStorageServiceImpl implements ConversationTypeStorageService {

	@Inject
	private ConversationTypeEntityService entityService;

	@Inject
	@Operation(CREATE)
	private Event<ConversationTypeOperation> createSuccessfulEvent;

	@Inject
	@Operation(CREATE_FAILED)
	private Event<ConversationTypeOperation> createFailedEvent;

	@Inject
	@Operation(UPDATE)
	private Event<ConversationTypeOperation> updated;

	@Inject
	@Operation(DELETE)
	private Event<Long> deleted;

	@Override
	public List<ConversationType> findAll() {
		return entityService.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.ConversationTypeStorageService#findByCode(java.lang.String)
	 */
	public ConversationType findByCode(String code){
		try {
			return entityService.findByCode(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.ConversationTypeStorageService#create(com.cloderia.helion.client.shared.operation.ConversationTypeOperation)
	 */
	@Override
	public Response create(final ConversationTypeOperation conversationTypeOperation) {
		try {
			entityService.create(conversationTypeOperation);
			createSuccessfulEvent.fire(conversationTypeOperation);
			return Response.created(UriBuilder.fromResource(ConversationTypeStorageService.class)
					.path(String.valueOf(conversationTypeOperation.getData().getId())).build()).build();
		} catch (Exception e) {
			e.printStackTrace();
			createFailedEvent.fire(conversationTypeOperation);
		}
		return Response.noContent().build();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.ConversationTypeStorageService#update(com.cloderia.helion.client.shared.operation.ConversationTypeOperation)
	 */
	@Override
	public Response update(final ConversationTypeOperation conversationTypeOperation) {
		entityService.update(conversationTypeOperation.getData());
		// This event is delivered to call connected clients.
		updated.fire(conversationTypeOperation);
		return Response.noContent().build();
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.ConversationTypeStorageService#delete(java.lang.Long)
	 */
	@Override
	public Response delete(Long id) {
		entityService.delete(id);
		// This event is delivered to call connected clients.
		deleted.fire(id);
		return Response.noContent().build();
	}
	

}
