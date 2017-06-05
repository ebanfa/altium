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

import com.cloderia.helion.client.shared.model.Location;
import com.cloderia.helion.client.shared.operation.LocationOperation;
import com.cloderia.helion.server.service.LocationStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on
 * {@link Location Locations}.
 *
 * @see LocationStorageServiceImpl
 */
@Path("/location")
public interface LocationStorageService {

	/**
	 * @return A list of all Locations in this service.
	 */
	@GET
	@Produces("application/json")
	List<Location> findAll();

	/**
	 * @param code
	 * @return Finds an Location by the value of its code field
	 */
	@GET
	@Path("/single/{code}")
	@Produces("application/json")
	public Location findByCode(@PathParam("code") String code);

	/**
	 * An HTTP endpoint for creating a new {@link Location}.
	 *
	 * @param locationOperation
	 *            Contains the {@link Location} to be created and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this contact.
	 * @return A {@link Response} with status 201 and a {@code Location} header
	 *         with the URL for the created Location, if successful.
	 *         Otherwise a {@link Response} with an appropriate error status.
	 */
	@POST
	@Consumes("application/json")
	Response create(LocationOperation locationOperation);

	/**
	 * An HTTP endpoint for updating an existing {@link Location}.
	 *
	 * @param locationOperation
	 *            Contains the {@link Location} to be updated and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this Location. The id of the contained
	 *            contact must match an existing Location from this service.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@PUT
	@Consumes("application/json")
	Response update(LocationOperation locationOperation);

	/**
	 * @param id
	 *            The id number of an existing {@link Location} to be
	 *            deleted.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	Response delete(@PathParam("id") Long id);
	
	/**
	 * @param code  The code of the LocationType 
	 *
	 * @return A List of Location.
	 */
	@GET
	@Path("/tcode/{code}")
	@Produces("application/json")
	List<Location> findByType(@PathParam("code") String locationTypeCode);

}
