/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.AccountTransactionStatus;

/**
 * @author adrian
 *
 */
@Portable
public class AccountTransactionStatusOperation extends AbstractOperation {

	private final AccountTransactionStatus accountTransactionStatus;

  	public AccountTransactionStatusOperation(final @MapsTo("accountTransactionStatus") AccountTransactionStatus accountTransactionStatus, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.accountTransactionStatus = accountTransactionStatus;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link AccountTransactionStatus} that has been created or updated.
   	 */
  	public AccountTransactionStatus getData() {
    	return accountTransactionStatus;
  	}
  	
  	
}

