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

import com.cloderia.helion.client.shared.model.PricingOptions;
import com.cloderia.helion.client.shared.operation.PricingOptionsOperation;
import com.cloderia.helion.server.service.PricingOptionsStorageServiceImpl;

/**
 * Defines a JaxRS HTTP service for performing CRUD operations on
 * {@link PricingOptions PricingOptionss}.
 *
 * @see PricingOptionsStorageServiceImpl
 */
@Path("/pricingOptions")
public interface PricingOptionsStorageService {

	/**
	 * @return A list of all PricingOptionss in this service.
	 */
	@GET
	@Produces("application/json")
	List<PricingOptions> findAll();

	/**
	 * @param code
	 * @return Finds an PricingOptions by the value of its code field
	 */
	@GET
	@Path("/single/{code}")
	@Produces("application/json")
	public PricingOptions findByCode(@PathParam("code") String code);

	/**
	 * An HTTP endpoint for creating a new {@link PricingOptions}.
	 *
	 * @param pricingOptionsOperation
	 *            Contains the {@link PricingOptions} to be created and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this contact.
	 * @return A {@link Response} with status 201 and a {@code Location} header
	 *         with the URL for the created PricingOptions, if successful.
	 *         Otherwise a {@link Response} with an appropriate error status.
	 */
	@POST
	@Consumes("application/json")
	Response create(PricingOptionsOperation pricingOptionsOperation);

	/**
	 * An HTTP endpoint for updating an existing {@link PricingOptions}.
	 *
	 * @param pricingOptionsOperation
	 *            Contains the {@link PricingOptions} to be updated and the
	 *            {@link ClientMessageBus#getSessionId() queue session id} of
	 *            the client creating this PricingOptions. The id of the contained
	 *            contact must match an existing PricingOptions from this service.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@PUT
	@Consumes("application/json")
	Response update(PricingOptionsOperation pricingOptionsOperation);

	/**
	 * @param id
	 *            The id number of an existing {@link PricingOptions} to be
	 *            deleted.
	 * @return A {@link Response} with status 204 if successful. Otherwise a
	 *         {@link Response} with an appropriate error status.
	 */
	@DELETE
	@Path("/{id:[0-9]+}")
	Response delete(@PathParam("id") Long id);
	

}
