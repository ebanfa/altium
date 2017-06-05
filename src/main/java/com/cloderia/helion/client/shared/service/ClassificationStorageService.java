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

import com.cloderia.helion.client.shared.model.Classification;
import com.cloderia.helion.client.shared.operation.ClassificationOperation;
import com.cloderia.helion.server.service.ClassificationStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on
 * {@link Classification Classifications}.
 *
 * @see ClassificationStorageServiceImpl
 */
@Path("/classification")
public interface ClassificationStorageService {

	/**
	 * @return A list of all Classifications in this service.
	 */
	@GET
	@Produces("application/json")
	List<Classification> findAll();

	/**
	 * @param code
	 * @return Finds an Classification by the value of its code field
	 */
	@GET
	@Path("/single/{code}")
	@Produces("application/json")
	public Classification findByCode(@PathParam("code") String code);

	/**
	 * An HTTP endpoint for creating a new {@link Classification}.
	 *
	 * @param classificationOperation
	 *            Contains the {@link Classification} to be created and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this contact.
	 * @return A {@link Response} with status 201 and a {@code Location} header
	 *         with the URL for the created Classification, if successful.
	 *         Otherwise a {@link Response} with an appropriate error status.
	 */
	@POST
	@Consumes("application/json")
	Response create(ClassificationOperation classificationOperation);

	/**
	 * An HTTP endpoint for updating an existing {@link Classification}.
	 *
	 * @param classificationOperation
	 *            Contains the {@link Classification} to be updated and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this Classification. The id of the contained
	 *            contact must match an existing Classification from this service.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@PUT
	@Consumes("application/json")
	Response update(ClassificationOperation classificationOperation);

	/**
	 * @param id
	 *            The id number of an existing {@link Classification} to be
	 *            deleted.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	Response delete(@PathParam("id") Long id);
	
	/**
	 * @param code  The code of the ClassificationType 
	 *
	 * @return A List of Classification.
	 */
	@GET
	@Path("/tcode/{code}")
	@Produces("application/json")
	List<Classification> findByType(@PathParam("code") String classificationTypeCode);

}
