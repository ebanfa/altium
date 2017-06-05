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

import static com.cloderia.helion.client.shared.operation.Operation.OperationType.LOGIN_SUCCESSFUL;
import static com.cloderia.helion.client.shared.operation.Operation.OperationType.LOGIN_FAILED;
import static com.cloderia.helion.client.shared.operation.Operation.OperationType.DELETE;
import static com.cloderia.helion.client.shared.operation.Operation.OperationType.UPDATE;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.cloderia.helion.client.shared.model.Login;
import com.cloderia.helion.client.shared.operation.LoginOperation;
import com.cloderia.helion.client.shared.operation.Operation;
import com.cloderia.helion.client.shared.service.LoginStorageService;

/**
 * Server-side implementation for the RPC service, {@link LoginStorageService}. Performs database CRUD operations
 * using the {@link LoginEntityService} and fires Errai CDI {@link Event Events} that are observed by clients over the
 * wire to publish creation, update, and deletion of {@link Login Login}.
 */
@Stateless
public class LoginStorageServiceImpl implements LoginStorageService {

  @Inject
  private LoginEntityService entityService;

  @Inject
  @Operation(LOGIN_FAILED)
  private Event<LoginOperation> loginFailedEvent;
  
  @Inject
  @Operation(LOGIN_SUCCESSFUL)
  private Event<LoginOperation> loginSuccessfulEvent;

  @Inject
  @Operation(UPDATE)
  private Event<LoginOperation> updated;

  @Inject
  @Operation(DELETE)
  private Event<Long> deleted;

  @Override
  public List<Login> findAll() {
    return entityService.findAll();
  }

  @Override
  public Response login(final LoginOperation loginOperation) {
    Boolean isValid = entityService.login(loginOperation.getData());
    if(isValid) {
    	// This event is delivered to call connected clients.
		loginSuccessfulEvent.fire(loginOperation);
    	return Response.status(200).build();
    }
    loginFailedEvent.fire(loginOperation);
	return Response.noContent().build();

  }
  
  @Override
  public Response update(final LoginOperation loginOperation) {
    entityService.update(loginOperation.getData());
    // This event is delivered to call connected clients.
    updated.fire(loginOperation);

    return Response.noContent().build();
  }

  @Override
  public Response delete(Long id) {
    entityService.delete(id);
    // This event is delivered to call connected clients.
    deleted.fire(id);

    return Response.noContent().build();
  }

}
