/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.Currency;

/**
 * @author adrian
 *
 */
@Portable
public class CurrencyOperation extends AbstractOperation {

	private final Currency currency;

  	public CurrencyOperation(final @MapsTo("currency") Currency currency, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.currency = currency;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link Currency} that has been created or updated.
   	 */
  	public Currency getData() {
    	return currency;
  	}
  	
  	
}

