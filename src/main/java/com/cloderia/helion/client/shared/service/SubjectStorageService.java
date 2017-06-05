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

import com.cloderia.helion.client.shared.model.Subject;
import com.cloderia.helion.client.shared.operation.SubjectOperation;
import com.cloderia.helion.server.service.SubjectStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on
 * {@link Subject Subjects}.
 *
 * @see SubjectStorageServiceImpl
 */
@Path("/subject")
public interface SubjectStorageService {

	/**
	 * @return A list of all Subjects in this service.
	 */
	@GET
	@Produces("application/json")
	List<Subject> findAll();

	/**
	 * @param code
	 * @return Finds an Subject by the value of its code field
	 */
	@GET
	@Path("/single/{code}")
	@Produces("application/json")
	public Subject findByCode(@PathParam("code") String code);

	/**
	 * An HTTP endpoint for creating a new {@link Subject}.
	 *
	 * @param subjectOperation
	 *            Contains the {@link Subject} to be created and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this contact.
	 * @return A {@link Response} with status 201 and a {@code Location} header
	 *         with the URL for the created Subject, if successful.
	 *         Otherwise a {@link Response} with an appropriate error status.
	 */
	@POST
	@Consumes("application/json")
	Response create(SubjectOperation subjectOperation);

	/**
	 * An HTTP endpoint for updating an existing {@link Subject}.
	 *
	 * @param subjectOperation
	 *            Contains the {@link Subject} to be updated and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this Subject. The id of the contained
	 *            contact must match an existing Subject from this service.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@PUT
	@Consumes("application/json")
	Response update(SubjectOperation subjectOperation);

	/**
	 * @param id
	 *            The id number of an existing {@link Subject} to be
	 *            deleted.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	Response delete(@PathParam("id") Long id);
	
	/**
	 * @param code  The code of the SubjectType 
	 *
	 * @return A List of Subject.
	 */
	@GET
	@Path("/tcode/{code}")
	@Produces("application/json")
	List<Subject> findByType(@PathParam("code") String subjectTypeCode);

}
