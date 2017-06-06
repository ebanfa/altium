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

import com.cloderia.helion.client.shared.model.Classification;
import com.cloderia.helion.client.shared.operation.ClassificationOperation;
import com.cloderia.helion.client.shared.operation.Operation;
import com.cloderia.helion.client.shared.service.ClassificationStorageService;

/**
 * @author Adrian Haldermann
 */
@Stateless
public class ClassificationStorageServiceImpl implements ClassificationStorageService {

	@Inject
	private ClassificationEntityService entityService;

	@Inject
	@Operation(CREATE)
	private Event<ClassificationOperation> createSuccessfulEvent;

	@Inject
	@Operation(CREATE_FAILED)
	private Event<ClassificationOperation> createFailedEvent;

	@Inject
	@Operation(UPDATE)
	private Event<ClassificationOperation> updated;

	@Inject
	@Operation(DELETE)
	private Event<Long> deleted;

	@Override
	public List<Classification> findAll() {
		return entityService.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.ClassificationStorageService#findByCode(java.lang.String)
	 */
	public Classification findByCode(String code){
		try {
			return entityService.findByCode(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* (non-Javadoc) wow
	 * @see com.cloderia.helion.client.shared.service.ClassificationStorageService#create(com.cloderia.helion.client.shared.operation.ClassificationOperation)
	 */
	@Override
	public Response create(final ClassificationOperation classificationOperation) {
		try {
			entityService.create(classificationOperation);
			createSuccessfulEvent.fire(classificationOperation);
			return Response.created(UriBuilder.fromResource(ClassificationStorageService.class)
					.path(String.valueOf(classificationOperation.getData().getId())).build()).build();
		} catch (Exception e) {
			e.printStackTrace();
			createFailedEvent.fire(classificationOperation);
		}
		return Response.noContent().build();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.ClassificationStorageService#update(com.cloderia.helion.client.shared.operation.ClassificationOperation)
	 */
	@Override
	public Response update(final ClassificationOperation classificationOperation) {
		entityService.update(classificationOperation.getData());
		// This event is delivered to call connected clients.
		updated.fire(classificationOperation);
		return Response.noContent().build();
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.ClassificationStorageService#delete(java.lang.Long)
	 */
	@Override
	public Response delete(Long id) {
		entityService.delete(id);
		// This event is delivered to call connected clients.
		deleted.fire(id);
		return Response.noContent().build();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.ClassificationStorageService#findByType(java.lang.String)
	 */
	@Override
	public List<Classification> findByType(String classificationTypeCode){
		return entityService.findByType(classificationTypeCode);
	}
	

}
