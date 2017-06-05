/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.Business;

/**
 * @author adrian
 *
 */
@Portable
public class BusinessOperation extends AbstractOperation {

	private final Business business;

	protected Integer currencyId;

	protected Integer businessLocationId;

  	public BusinessOperation(final @MapsTo("business") Business business, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.business = business;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link Business} that has been created or updated.
   	 */
  	public Business getData() {
    	return business;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getCurrencyId() {
    	return currencyId;
  	}

  	/**
   	 * .
   	 */
  	public void setCurrencyId(Integer currencyId) {
    	this.currencyId = currencyId;
  	}

  	/**
   	 * 
   	 */
  	public Integer getBusinessLocationId() {
    	return businessLocationId;
  	}

  	/**
   	 * .
   	 */
  	public void setBusinessLocationId(Integer businessLocationId) {
    	this.businessLocationId = businessLocationId;
  	}
}

