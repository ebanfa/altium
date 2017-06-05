/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.PricingOptions;

/**
 * @author adrian
 *
 */
@Portable
public class PricingOptionsOperation extends AbstractOperation {

	private final PricingOptions pricingOptions;

  	public PricingOptionsOperation(final @MapsTo("pricingOptions") PricingOptions pricingOptions, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.pricingOptions = pricingOptions;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link PricingOptions} that has been created or updated.
   	 */
  	public PricingOptions getData() {
    	return pricingOptions;
  	}
  	
  	
}

