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

import com.cloderia.helion.client.shared.model.PartyRole;
import com.cloderia.helion.client.shared.operation.PartyRoleOperation;
import com.cloderia.helion.server.service.PartyRoleStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on
 * {@link PartyRole PartyRoles}.
 *
 * @see PartyRoleStorageServiceImpl
 */
@Path("/partyRole")
public interface PartyRoleStorageService {

	/**
	 * @return A list of all PartyRoles in this service.
	 */
	@GET
	@Produces("application/json")
	List<PartyRole> findAll();

	/**
	 * @param code
	 * @return Finds an PartyRole by the value of its code field
	 */
	@GET
	@Path("/single/{code}")
	@Produces("application/json")
	public PartyRole findByCode(@PathParam("code") String code);

	/**
	 * An HTTP endpoint for creating a new {@link PartyRole}.
	 *
	 * @param partyRoleOperation
	 *            Contains the {@link PartyRole} to be created and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this contact.
	 * @return A {@link Response} with status 201 and a {@code Location} header
	 *         with the URL for the created PartyRole, if successful.
	 *         Otherwise a {@link Response} with an appropriate error status.
	 */
	@POST
	@Consumes("application/json")
	Response create(PartyRoleOperation partyRoleOperation);

	/**
	 * An HTTP endpoint for updating an existing {@link PartyRole}.
	 *
	 * @param partyRoleOperation
	 *            Contains the {@link PartyRole} to be updated and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this PartyRole. The id of the contained
	 *            contact must match an existing PartyRole from this service.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@PUT
	@Consumes("application/json")
	Response update(PartyRoleOperation partyRoleOperation);

	/**
	 * @param id
	 *            The id number of an existing {@link PartyRole} to be
	 *            deleted.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	Response delete(@PathParam("id") Long id);
	

}
