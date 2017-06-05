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

import com.cloderia.helion.client.shared.model.Conversation;
import com.cloderia.helion.client.shared.operation.ConversationOperation;
import com.cloderia.helion.server.service.ConversationStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on
 * {@link Conversation Conversations}.
 *
 * @see ConversationStorageServiceImpl
 */
@Path("/conversation")
public interface ConversationStorageService {

	/**
	 * @return A list of all Conversations in this service.
	 */
	@GET
	@Produces("application/json")
	List<Conversation> findAll();

	/**
	 * @param code
	 * @return Finds an Conversation by the value of its code field
	 */
	@GET
	@Path("/single/{code}")
	@Produces("application/json")
	public Conversation findByCode(@PathParam("code") String code);

	/**
	 * An HTTP endpoint for creating a new {@link Conversation}.
	 *
	 * @param conversationOperation
	 *            Contains the {@link Conversation} to be created and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this contact.
	 * @return A {@link Response} with status 201 and a {@code Location} header
	 *         with the URL for the created Conversation, if successful.
	 *         Otherwise a {@link Response} with an appropriate error status.
	 */
	@POST
	@Consumes("application/json")
	Response create(ConversationOperation conversationOperation);

	/**
	 * An HTTP endpoint for updating an existing {@link Conversation}.
	 *
	 * @param conversationOperation
	 *            Contains the {@link Conversation} to be updated and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this Conversation. The id of the contained
	 *            contact must match an existing Conversation from this service.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@PUT
	@Consumes("application/json")
	Response update(ConversationOperation conversationOperation);

	/**
	 * @param id
	 *            The id number of an existing {@link Conversation} to be
	 *            deleted.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	Response delete(@PathParam("id") Long id);
	
	/**
	 * @param code  The code of the ConversationType 
	 *
	 * @return A List of Conversation.
	 */
	@GET
	@Path("/tcode/{code}")
	@Produces("application/json")
	List<Conversation> findByType(@PathParam("code") String conversationTypeCode);

}
