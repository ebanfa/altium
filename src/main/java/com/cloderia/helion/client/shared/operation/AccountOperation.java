/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.Account;

/**
 * @author adrian
 *
 */
@Portable
public class AccountOperation extends AbstractOperation {

	private final Account account;

  	public AccountOperation(final @MapsTo("account") Account account, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.account = account;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link Account} that has been created or updated.
   	 */
  	public Account getData() {
    	return account;
  	}
  	
  	
}

