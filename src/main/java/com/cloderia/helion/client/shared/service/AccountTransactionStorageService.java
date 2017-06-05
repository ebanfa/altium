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

import com.cloderia.helion.client.shared.model.AccountTransaction;
import com.cloderia.helion.client.shared.operation.AccountTransactionOperation;
import com.cloderia.helion.server.service.AccountTransactionStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on
 * {@link AccountTransaction AccountTransactions}.
 *
 * @see AccountTransactionStorageServiceImpl
 */
@Path("/accountTransaction")
public interface AccountTransactionStorageService {

	/**
	 * @return A list of all AccountTransactions in this service.
	 */
	@GET
	@Produces("application/json")
	List<AccountTransaction> findAll();

	/**
	 * @param code
	 * @return Finds an AccountTransaction by the value of its code field
	 */
	@GET
	@Path("/single/{code}")
	@Produces("application/json")
	public AccountTransaction findByCode(@PathParam("code") String code);

	/**
	 * An HTTP endpoint for creating a new {@link AccountTransaction}.
	 *
	 * @param accountTransactionOperation
	 *            Contains the {@link AccountTransaction} to be created and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this contact.
	 * @return A {@link Response} with status 201 and a {@code Location} header
	 *         with the URL for the created AccountTransaction, if successful.
	 *         Otherwise a {@link Response} with an appropriate error status.
	 */
	@POST
	@Consumes("application/json")
	Response create(AccountTransactionOperation accountTransactionOperation);

	/**
	 * An HTTP endpoint for updating an existing {@link AccountTransaction}.
	 *
	 * @param accountTransactionOperation
	 *            Contains the {@link AccountTransaction} to be updated and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this AccountTransaction. The id of the contained
	 *            contact must match an existing AccountTransaction from this service.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@PUT
	@Consumes("application/json")
	Response update(AccountTransactionOperation accountTransactionOperation);

	/**
	 * @param id
	 *            The id number of an existing {@link AccountTransaction} to be
	 *            deleted.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	Response delete(@PathParam("id") Long id);
	
	/**
	 * @param code  The code of the AccountTransactionType 
	 *
	 * @return A List of AccountTransaction.
	 */
	@GET
	@Path("/tcode/{code}")
	@Produces("application/json")
	List<AccountTransaction> findByType(@PathParam("code") String accountTransactionTypeCode);

}
