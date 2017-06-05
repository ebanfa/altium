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

import com.cloderia.helion.client.shared.model.Signup;
import com.cloderia.helion.client.shared.operation.SignupOperation;
import com.cloderia.helion.server.service.SignupStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on
 * {@link Signup Signups}.
 *
 * @see SignupStorageServiceImpl
 */
@Path("/signup")
public interface SignupStorageService {

	/**
	 * @return A list of all Signups in this service.
	 */
	@GET
	@Produces("application/json")
	List<Signup> findAll();

	/**
	 * @param code
	 * @return Finds an Signup by the value of its code field
	 */
	@GET
	@Path("/single/{code}")
	@Produces("application/json")
	public Signup findByCode(@PathParam("code") String code);

	/**
	 * An HTTP endpoint for creating a new {@link Signup}.
	 *
	 * @param signupOperation
	 *            Contains the {@link Signup} to be created and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this contact.
	 * @return A {@link Response} with status 201 and a {@code Location} header
	 *         with the URL for the created Signup, if successful.
	 *         Otherwise a {@link Response} with an appropriate error status.
	 */
	@POST
	@Consumes("application/json")
	Response create(SignupOperation signupOperation);

	/**
	 * An HTTP endpoint for updating an existing {@link Signup}.
	 *
	 * @param signupOperation
	 *            Contains the {@link Signup} to be updated and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this Signup. The id of the contained
	 *            contact must match an existing Signup from this service.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@PUT
	@Consumes("application/json")
	Response update(SignupOperation signupOperation);

	/**
	 * @param id
	 *            The id number of an existing {@link Signup} to be
	 *            deleted.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	Response delete(@PathParam("id") Long id);
	

}
