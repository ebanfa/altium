/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.Password;

/**
 * @author adrian
 *
 */
@Portable
public class PasswordOperation extends AbstractOperation {

	private final Password password;

  	public PasswordOperation(final @MapsTo("password") Password password, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.password = password;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link Password} that has been created or updated.
   	 */
  	public Password getData() {
    	return password;
  	}
  	
  	
}

