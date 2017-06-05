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

import com.cloderia.helion.client.shared.model.Conversation;
import com.cloderia.helion.client.shared.operation.ConversationOperation;
import com.cloderia.helion.client.shared.operation.Operation;
import com.cloderia.helion.client.shared.service.ConversationStorageService;

/**
 * @author Adrian Haldermann
 */
@Stateless
public class ConversationStorageServiceImpl implements ConversationStorageService {

	@Inject
	private ConversationEntityService entityService;

	@Inject
	@Operation(CREATE)
	private Event<ConversationOperation> createSuccessfulEvent;

	@Inject
	@Operation(CREATE_FAILED)
	private Event<ConversationOperation> createFailedEvent;

	@Inject
	@Operation(UPDATE)
	private Event<ConversationOperation> updated;

	@Inject
	@Operation(DELETE)
	private Event<Long> deleted;

	@Override
	public List<Conversation> findAll() {
		return entityService.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.ConversationStorageService#findByCode(java.lang.String)
	 */
	public Conversation findByCode(String code){
		try {
			return entityService.findByCode(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.ConversationStorageService#create(com.cloderia.helion.client.shared.operation.ConversationOperation)
	 */
	@Override
	public Response create(final ConversationOperation conversationOperation) {
		try {
			entityService.create(conversationOperation);
			createSuccessfulEvent.fire(conversationOperation);
			return Response.created(UriBuilder.fromResource(ConversationStorageService.class)
					.path(String.valueOf(conversationOperation.getData().getId())).build()).build();
		} catch (Exception e) {
			e.printStackTrace();
			createFailedEvent.fire(conversationOperation);
		}
		return Response.noContent().build();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.ConversationStorageService#update(com.cloderia.helion.client.shared.operation.ConversationOperation)
	 */
	@Override
	public Response update(final ConversationOperation conversationOperation) {
		entityService.update(conversationOperation.getData());
		// This event is delivered to call connected clients.
		updated.fire(conversationOperation);
		return Response.noContent().build();
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.ConversationStorageService#delete(java.lang.Long)
	 */
	@Override
	public Response delete(Long id) {
		entityService.delete(id);
		// This event is delivered to call connected clients.
		deleted.fire(id);
		return Response.noContent().build();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.ConversationStorageService#findByType(java.lang.String)
	 */
	@Override
	public List<Conversation> findByType(String conversationTypeCode){
		return entityService.findByType(conversationTypeCode);
	}
	

}
