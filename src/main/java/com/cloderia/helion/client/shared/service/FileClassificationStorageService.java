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

import com.cloderia.helion.client.shared.model.FileClassification;
import com.cloderia.helion.client.shared.operation.FileClassificationOperation;
import com.cloderia.helion.server.service.FileClassificationStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on
 * {@link FileClassification FileClassifications}.
 *
 * @see FileClassificationStorageServiceImpl
 */
@Path("/fileClassification")
public interface FileClassificationStorageService {

	/**
	 * @return A list of all FileClassifications in this service.
	 */
	@GET
	@Produces("application/json")
	List<FileClassification> findAll();

	/**
	 * @param code
	 * @return Finds an FileClassification by the value of its code field
	 */
	@GET
	@Path("/single/{code}")
	@Produces("application/json")
	public FileClassification findByCode(@PathParam("code") String code);

	/**
	 * An HTTP endpoint for creating a new {@link FileClassification}.
	 *
	 * @param fileClassificationOperation
	 *            Contains the {@link FileClassification} to be created and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this contact.
	 * @return A {@link Response} with status 201 and a {@code Location} header
	 *         with the URL for the created FileClassification, if successful.
	 *         Otherwise a {@link Response} with an appropriate error status.
	 */
	@POST
	@Consumes("application/json")
	Response create(FileClassificationOperation fileClassificationOperation);

	/**
	 * An HTTP endpoint for updating an existing {@link FileClassification}.
	 *
	 * @param fileClassificationOperation
	 *            Contains the {@link FileClassification} to be updated and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this FileClassification. The id of the contained
	 *            contact must match an existing FileClassification from this service.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@PUT
	@Consumes("application/json")
	Response update(FileClassificationOperation fileClassificationOperation);

	/**
	 * @param id
	 *            The id number of an existing {@link FileClassification} to be
	 *            deleted.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	Response delete(@PathParam("id") Long id);
	
	/**
	 * @param code  The code of the FileClassificationType 
	 *
	 * @return A List of FileClassification.
	 */
	@GET
	@Path("/tcode/{code}")
	@Produces("application/json")
	List<FileClassification> findByType(@PathParam("code") String fileClassificationTypeCode);

}
