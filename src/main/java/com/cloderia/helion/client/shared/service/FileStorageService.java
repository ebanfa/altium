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

import com.cloderia.helion.client.shared.model.File;
import com.cloderia.helion.client.shared.operation.FileOperation;
import com.cloderia.helion.server.service.FileStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on
 * {@link File Files}.
 *
 * @see FileStorageServiceImpl
 */
@Path("/file")
public interface FileStorageService {

	/**
	 * @return A list of all Files in this service.
	 */
	@GET
	@Produces("application/json")
	List<File> findAll();

	/**
	 * @param code
	 * @return Finds an File by the value of its code field
	 */
	@GET
	@Path("/single/{code}")
	@Produces("application/json")
	public File findByCode(@PathParam("code") String code);

	/**
	 * An HTTP endpoint for creating a new {@link File}.
	 *
	 * @param fileOperation
	 *            Contains the {@link File} to be created and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this contact.
	 * @return A {@link Response} with status 201 and a {@code Location} header
	 *         with the URL for the created File, if successful.
	 *         Otherwise a {@link Response} with an appropriate error status.
	 */
	@POST
	@Consumes("application/json")
	Response create(FileOperation fileOperation);

	/**
	 * An HTTP endpoint for updating an existing {@link File}.
	 *
	 * @param fileOperation
	 *            Contains the {@link File} to be updated and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this File. The id of the contained
	 *            contact must match an existing File from this service.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@PUT
	@Consumes("application/json")
	Response update(FileOperation fileOperation);

	/**
	 * @param id
	 *            The id number of an existing {@link File} to be
	 *            deleted.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	Response delete(@PathParam("id") Long id);
	
	/**
	 * @param code  The code of the FileType 
	 *
	 * @return A List of File.
	 */
	@GET
	@Path("/tcode/{code}")
	@Produces("application/json")
	List<File> findByType(@PathParam("code") String fileTypeCode);

}
