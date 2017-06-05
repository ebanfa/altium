/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.Signup;

/**
 * @author adrian
 *
 */
@Portable
public class SignupOperation extends AbstractOperation {

	private final Signup signup;

  	public SignupOperation(final @MapsTo("signup") Signup signup, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.signup = signup;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link Signup} that has been created or updated.
   	 */
  	public Signup getData() {
    	return signup;
  	}
  	
  	
}

