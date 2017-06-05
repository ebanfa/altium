/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.Login;

/**
 * @author adrian
 *
 */
@Portable
public class LoginOperation extends AbstractOperation {

	private final Login login;

  	public LoginOperation(final @MapsTo("login") Login login, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.login = login;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link Login} that has been created or updated.
   	 */
  	public Login getData() {
    	return login;
  	}
  	
  	
}

