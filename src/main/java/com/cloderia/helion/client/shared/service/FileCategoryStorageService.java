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

import com.cloderia.helion.client.shared.model.FileCategory;
import com.cloderia.helion.client.shared.operation.FileCategoryOperation;
import com.cloderia.helion.server.service.FileCategoryStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on
 * {@link FileCategory FileCategorys}.
 *
 * @see FileCategoryStorageServiceImpl
 */
@Path("/fileCategory")
public interface FileCategoryStorageService {

	/**
	 * @return A list of all FileCategorys in this service.
	 */
	@GET
	@Produces("application/json")
	List<FileCategory> findAll();

	/**
	 * @param code
	 * @return Finds an FileCategory by the value of its code field
	 */
	@GET
	@Path("/single/{code}")
	@Produces("application/json")
	public FileCategory findByCode(@PathParam("code") String code);

	/**
	 * An HTTP endpoint for creating a new {@link FileCategory}.
	 *
	 * @param fileCategoryOperation
	 *            Contains the {@link FileCategory} to be created and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this contact.
	 * @return A {@link Response} with status 201 and a {@code Location} header
	 *         with the URL for the created FileCategory, if successful.
	 *         Otherwise a {@link Response} with an appropriate error status.
	 */
	@POST
	@Consumes("application/json")
	Response create(FileCategoryOperation fileCategoryOperation);

	/**
	 * An HTTP endpoint for updating an existing {@link FileCategory}.
	 *
	 * @param fileCategoryOperation
	 *            Contains the {@link FileCategory} to be updated and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this FileCategory. The id of the contained
	 *            contact must match an existing FileCategory from this service.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@PUT
	@Consumes("application/json")
	Response update(FileCategoryOperation fileCategoryOperation);

	/**
	 * @param id
	 *            The id number of an existing {@link FileCategory} to be
	 *            deleted.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	Response delete(@PathParam("id") Long id);
	

}
