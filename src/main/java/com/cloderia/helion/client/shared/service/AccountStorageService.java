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

import com.cloderia.helion.client.shared.model.Account;
import com.cloderia.helion.client.shared.operation.AccountOperation;
import com.cloderia.helion.server.service.AccountStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on
 * {@link Account Accounts}.
 *
 * @see AccountStorageServiceImpl
 */
@Path("/account")
public interface AccountStorageService {

	/**
	 * @return A list of all Accounts in this service.
	 */
	@GET
	@Produces("application/json")
	List<Account> findAll();

	/**
	 * @param code
	 * @return Finds an Account by the value of its code field
	 */
	@GET
	@Path("/single/{code}")
	@Produces("application/json")
	public Account findByCode(@PathParam("code") String code);

	/**
	 * An HTTP endpoint for creating a new {@link Account}.
	 *
	 * @param accountOperation
	 *            Contains the {@link Account} to be created and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this contact.
	 * @return A {@link Response} with status 201 and a {@code Location} header
	 *         with the URL for the created Account, if successful.
	 *         Otherwise a {@link Response} with an appropriate error status.
	 */
	@POST
	@Consumes("application/json")
	Response create(AccountOperation accountOperation);

	/**
	 * An HTTP endpoint for updating an existing {@link Account}.
	 *
	 * @param accountOperation
	 *            Contains the {@link Account} to be updated and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this Account. The id of the contained
	 *            contact must match an existing Account from this service.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@PUT
	@Consumes("application/json")
	Response update(AccountOperation accountOperation);

	/**
	 * @param id
	 *            The id number of an existing {@link Account} to be
	 *            deleted.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	Response delete(@PathParam("id") Long id);
	

}
