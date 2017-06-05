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

import com.cloderia.helion.client.shared.model.Urgency;
import com.cloderia.helion.client.shared.operation.UrgencyOperation;
import com.cloderia.helion.server.service.UrgencyStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on
 * {@link Urgency Urgencys}.
 *
 * @see UrgencyStorageServiceImpl
 */
@Path("/urgency")
public interface UrgencyStorageService {

	/**
	 * @return A list of all Urgencys in this service.
	 */
	@GET
	@Produces("application/json")
	List<Urgency> findAll();

	/**
	 * @param code
	 * @return Finds an Urgency by the value of its code field
	 */
	@GET
	@Path("/single/{code}")
	@Produces("application/json")
	public Urgency findByCode(@PathParam("code") String code);

	/**
	 * An HTTP endpoint for creating a new {@link Urgency}.
	 *
	 * @param urgencyOperation
	 *            Contains the {@link Urgency} to be created and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this contact.
	 * @return A {@link Response} with status 201 and a {@code Location} header
	 *         with the URL for the created Urgency, if successful.
	 *         Otherwise a {@link Response} with an appropriate error status.
	 */
	@POST
	@Consumes("application/json")
	Response create(UrgencyOperation urgencyOperation);

	/**
	 * An HTTP endpoint for updating an existing {@link Urgency}.
	 *
	 * @param urgencyOperation
	 *            Contains the {@link Urgency} to be updated and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this Urgency. The id of the contained
	 *            contact must match an existing Urgency from this service.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@PUT
	@Consumes("application/json")
	Response update(UrgencyOperation urgencyOperation);

	/**
	 * @param id
	 *            The id number of an existing {@link Urgency} to be
	 *            deleted.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	Response delete(@PathParam("id") Long id);
	

}
