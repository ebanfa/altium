package com.cloderia.helion.client.shared.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.errai.bus.client.api.ClientMessageBus;

import com.cloderia.helion.client.shared.model.Login;
import com.cloderia.helion.client.shared.operation.LoginOperation;
import com.cloderia.helion.server.service.LoginStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on {@link Login Logins}.
 *
 * @see LoginStorageServiceImpl
 */
@Path("/login")
public interface LoginStorageService {

  /**
   * @return A list of all Logins in this service.
   */
  @GET
  @Produces("application/json")
  List<Login> findAll();

  /**
   * An HTTP endpoint for creating a new {@link Login}.
   *
   * @param loginOperation
   *          Contains the {@link Login} to be created and the {@link ClientMessageBus#getSessionId() queue session
   *          id} of the client creating this contact.
   * @return A {@link Response} with status 201 and a {@code Location} header with the URL for the created Login, if
   *         successful. Otherwise a {@link Response} with an appropriate error status.
   */
  @POST
  @Consumes("application/json")
  Response login(LoginOperation loginOperation);

  /**
   * An HTTP endpoint for updating an existing {@link Login}.
   *
   * @param loginOperation
   *          Contains the {@link Login} to be updated and the {@link ClientMessageBus#getSessionId() queue session
   *          id} of the client creating this Login. The id of the contained contact must match an existing Login
   *          from this service.
   * @return A {@link Response} with status 204 if successful. Otherwise a {@link Response} with an appropriate error
   *         status.
   */
  @PUT
  @Consumes("application/json")
  Response update(LoginOperation loginOperation);

  /**
   * @param id
   *          The id number of an existing {@link Login} to be deleted.
   * @return A {@link Response} with status 204 if successful. Otherwise a {@link Response} with an appropriate error
   *         status.
   */
  @DELETE
  @Path("/{id:[0-9]+}")
  Response delete(@PathParam("id") Long id);

}
