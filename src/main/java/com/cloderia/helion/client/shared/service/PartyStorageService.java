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

import com.cloderia.helion.client.shared.model.Party;
import com.cloderia.helion.client.shared.operation.PartyOperation;
import com.cloderia.helion.server.service.PartyStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on
 * {@link Party Partys}.
 *
 * @see PartyStorageServiceImpl
 */
@Path("/party")
public interface PartyStorageService {

	/**
	 * @return A list of all Partys in this service.
	 */
	@GET
	@Produces("application/json")
	List<Party> findAll();

	/**
	 * @param code
	 * @return Finds an Party by the value of its code field
	 */
	@GET
	@Path("/single/{code}")
	@Produces("application/json")
	public Party findByCode(@PathParam("code") String code);

	/**
	 * An HTTP endpoint for creating a new {@link Party}.
	 *
	 * @param partyOperation
	 *            Contains the {@link Party} to be created and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this contact.
	 * @return A {@link Response} with status 201 and a {@code Location} header
	 *         with the URL for the created Party, if successful.
	 *         Otherwise a {@link Response} with an appropriate error status.
	 */
	@POST
	@Consumes("application/json")
	Response create(PartyOperation partyOperation);

	/**
	 * An HTTP endpoint for updating an existing {@link Party}.
	 *
	 * @param partyOperation
	 *            Contains the {@link Party} to be updated and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this Party. The id of the contained
	 *            contact must match an existing Party from this service.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@PUT
	@Consumes("application/json")
	Response update(PartyOperation partyOperation);

	/**
	 * @param id
	 *            The id number of an existing {@link Party} to be
	 *            deleted.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	Response delete(@PathParam("id") Long id);
	
	/**
	 * @param code  The code of the PartyType 
	 *
	 * @return A List of Party.
	 */
	@GET
	@Path("/tcode/{code}")
	@Produces("application/json")
	List<Party> findByType(@PathParam("code") String partyTypeCode);

}
