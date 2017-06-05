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

import com.cloderia.helion.client.shared.model.LocationType;
import com.cloderia.helion.client.shared.operation.LocationTypeOperation;
import com.cloderia.helion.server.service.LocationTypeStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on
 * {@link LocationType LocationTypes}.
 *
 * @see LocationTypeStorageServiceImpl
 */
@Path("/locationType")
public interface LocationTypeStorageService {

	/**
	 * @return A list of all LocationTypes in this service.
	 */
	@GET
	@Produces("application/json")
	List<LocationType> findAll();

	/**
	 * @param code
	 * @return Finds an LocationType by the value of its code field
	 */
	@GET
	@Path("/single/{code}")
	@Produces("application/json")
	public LocationType findByCode(@PathParam("code") String code);

	/**
	 * An HTTP endpoint for creating a new {@link LocationType}.
	 *
	 * @param locationTypeOperation
	 *            Contains the {@link LocationType} to be created and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this contact.
	 * @return A {@link Response} with status 201 and a {@code Location} header
	 *         with the URL for the created LocationType, if successful.
	 *         Otherwise a {@link Response} with an appropriate error status.
	 */
	@POST
	@Consumes("application/json")
	Response create(LocationTypeOperation locationTypeOperation);

	/**
	 * An HTTP endpoint for updating an existing {@link LocationType}.
	 *
	 * @param locationTypeOperation
	 *            Contains the {@link LocationType} to be updated and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this LocationType. The id of the contained
	 *            contact must match an existing LocationType from this service.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@PUT
	@Consumes("application/json")
	Response update(LocationTypeOperation locationTypeOperation);

	/**
	 * @param id
	 *            The id number of an existing {@link LocationType} to be
	 *            deleted.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	Response delete(@PathParam("id") Long id);
	

}
