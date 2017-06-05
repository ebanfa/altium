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

import com.cloderia.helion.client.shared.model.Message;
import com.cloderia.helion.client.shared.operation.MessageOperation;
import com.cloderia.helion.client.shared.operation.Operation;
import com.cloderia.helion.client.shared.service.MessageStorageService;

/**
 * @author Adrian Haldermann
 */
@Stateless
public class MessageStorageServiceImpl implements MessageStorageService {

	@Inject
	private MessageEntityService entityService;

	@Inject
	@Operation(CREATE)
	private Event<MessageOperation> createSuccessfulEvent;

	@Inject
	@Operation(CREATE_FAILED)
	private Event<MessageOperation> createFailedEvent;

	@Inject
	@Operation(UPDATE)
	private Event<MessageOperation> updated;

	@Inject
	@Operation(DELETE)
	private Event<Long> deleted;

	@Override
	public List<Message> findAll() {
		return entityService.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.MessageStorageService#findByCode(java.lang.String)
	 */
	public Message findByCode(String code){
		try {
			return entityService.findByCode(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.MessageStorageService#create(com.cloderia.helion.client.shared.operation.MessageOperation)
	 */
	@Override
	public Response create(final MessageOperation messageOperation) {
		try {
			entityService.create(messageOperation);
			createSuccessfulEvent.fire(messageOperation);
			return Response.created(UriBuilder.fromResource(MessageStorageService.class)
					.path(String.valueOf(messageOperation.getData().getId())).build()).build();
		} catch (Exception e) {
			e.printStackTrace();
			createFailedEvent.fire(messageOperation);
		}
		return Response.noContent().build();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.MessageStorageService#update(com.cloderia.helion.client.shared.operation.MessageOperation)
	 */
	@Override
	public Response update(final MessageOperation messageOperation) {
		entityService.update(messageOperation.getData());
		// This event is delivered to call connected clients.
		updated.fire(messageOperation);
		return Response.noContent().build();
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.MessageStorageService#delete(java.lang.Long)
	 */
	@Override
	public Response delete(Long id) {
		entityService.delete(id);
		// This event is delivered to call connected clients.
		deleted.fire(id);
		return Response.noContent().build();
	}
	

}
