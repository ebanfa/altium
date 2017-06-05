/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.AccountTransactionType;

/**
 * @author adrian
 *
 */
@Portable
public class AccountTransactionTypeOperation extends AbstractOperation {

	private final AccountTransactionType accountTransactionType;

  	public AccountTransactionTypeOperation(final @MapsTo("accountTransactionType") AccountTransactionType accountTransactionType, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.accountTransactionType = accountTransactionType;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link AccountTransactionType} that has been created or updated.
   	 */
  	public AccountTransactionType getData() {
    	return accountTransactionType;
  	}
  	
  	
}

