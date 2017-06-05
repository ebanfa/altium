/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.BillingAccount;

/**
 * @author adrian
 *
 */
@Portable
public class BillingAccountOperation extends AbstractOperation {

	private final BillingAccount billingAccount;

	protected Integer bAccountPartyId;

  	public BillingAccountOperation(final @MapsTo("billingAccount") BillingAccount billingAccount, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.billingAccount = billingAccount;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link BillingAccount} that has been created or updated.
   	 */
  	public BillingAccount getData() {
    	return billingAccount;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getBAccountPartyId() {
    	return bAccountPartyId;
  	}

  	/**
   	 * .
   	 */
  	public void setBAccountPartyId(Integer bAccountPartyId) {
    	this.bAccountPartyId = bAccountPartyId;
  	}
}

