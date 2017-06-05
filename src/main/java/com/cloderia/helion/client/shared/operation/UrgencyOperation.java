/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.Urgency;

/**
 * @author adrian
 *
 */
@Portable
public class UrgencyOperation extends AbstractOperation {

	private final Urgency urgency;

  	public UrgencyOperation(final @MapsTo("urgency") Urgency urgency, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.urgency = urgency;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link Urgency} that has been created or updated.
   	 */
  	public Urgency getData() {
    	return urgency;
  	}
  	
  	
}

