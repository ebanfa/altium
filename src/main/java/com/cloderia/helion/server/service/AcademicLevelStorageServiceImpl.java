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

import com.cloderia.helion.client.shared.model.AcademicLevel;
import com.cloderia.helion.client.shared.operation.AcademicLevelOperation;
import com.cloderia.helion.client.shared.operation.Operation;
import com.cloderia.helion.client.shared.service.AcademicLevelStorageService;

/**
 * @author Adrian Haldermann
 */
@Stateless
public class AcademicLevelStorageServiceImpl implements AcademicLevelStorageService {

	@Inject
	private AcademicLevelEntityService entityService;

	@Inject
	@Operation(CREATE)
	private Event<AcademicLevelOperation> createSuccessfulEvent;

	@Inject
	@Operation(CREATE_FAILED)
	private Event<AcademicLevelOperation> createFailedEvent;

	@Inject
	@Operation(UPDATE)
	private Event<AcademicLevelOperation> updated;

	@Inject
	@Operation(DELETE)
	private Event<Long> deleted;

	@Override
	public List<AcademicLevel> findAll() {
		return entityService.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.AcademicLevelStorageService#findByCode(java.lang.String)
	 */
	public AcademicLevel findByCode(String code){
		try {
			return entityService.findByCode(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.AcademicLevelStorageService#create(com.cloderia.helion.client.shared.operation.AcademicLevelOperation)
	 */
	@Override
	public Response create(final AcademicLevelOperation academicLevelOperation) {
		try {
			entityService.create(academicLevelOperation);
			createSuccessfulEvent.fire(academicLevelOperation);
			return Response.created(UriBuilder.fromResource(AcademicLevelStorageService.class)
					.path(String.valueOf(academicLevelOperation.getData().getId())).build()).build();
		} catch (Exception e) {
			e.printStackTrace();
			createFailedEvent.fire(academicLevelOperation);
		}
		return Response.noContent().build();
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.AcademicLevelStorageService#update(com.cloderia.helion.client.shared.operation.AcademicLevelOperation)
	 */
	@Override
	public Response update(final AcademicLevelOperation academicLevelOperation) {
		entityService.update(academicLevelOperation.getData());
		// This event is delivered to call connected clients.
		updated.fire(academicLevelOperation);
		return Response.noContent().build();
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.shared.service.AcademicLevelStorageService#delete(java.lang.Long)
	 */
	@Override
	public Response delete(Long id) {
		entityService.delete(id);
		// This event is delivered to call connected clients.
		deleted.fire(id);
		return Response.noContent().build();
	}
	

}
