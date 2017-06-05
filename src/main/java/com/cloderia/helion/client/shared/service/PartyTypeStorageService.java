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

import com.cloderia.helion.client.shared.model.PartyType;
import com.cloderia.helion.client.shared.operation.PartyTypeOperation;
import com.cloderia.helion.server.service.PartyTypeStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on
 * {@link PartyType PartyTypes}.
 *
 * @see PartyTypeStorageServiceImpl
 */
@Path("/partyType")
public interface PartyTypeStorageService {

	/**
	 * @return A list of all PartyTypes in this service.
	 */
	@GET
	@Produces("application/json")
	List<PartyType> findAll();

	/**
	 * @param code
	 * @return Finds an PartyType by the value of its code field
	 */
	@GET
	@Path("/single/{code}")
	@Produces("application/json")
	public PartyType findByCode(@PathParam("code") String code);

	/**
	 * An HTTP endpoint for creating a new {@link PartyType}.
	 *
	 * @param partyTypeOperation
	 *            Contains the {@link PartyType} to be created and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this contact.
	 * @return A {@link Response} with status 201 and a {@code Location} header
	 *         with the URL for the created PartyType, if successful.
	 *         Otherwise a {@link Response} with an appropriate error status.
	 */
	@POST
	@Consumes("application/json")
	Response create(PartyTypeOperation partyTypeOperation);

	/**
	 * An HTTP endpoint for updating an existing {@link PartyType}.
	 *
	 * @param partyTypeOperation
	 *            Contains the {@link PartyType} to be updated and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this PartyType. The id of the contained
	 *            contact must match an existing PartyType from this service.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@PUT
	@Consumes("application/json")
	Response update(PartyTypeOperation partyTypeOperation);

	/**
	 * @param id
	 *            The id number of an existing {@link PartyType} to be
	 *            deleted.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	Response delete(@PathParam("id") Long id);
	

}
