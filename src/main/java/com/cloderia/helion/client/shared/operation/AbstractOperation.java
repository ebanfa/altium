/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.bus.client.api.ClientMessageBus;

/**
 * @author adrian
 *
 */
public abstract class AbstractOperation {
	
	
  	protected String sourceQueueSessionId;
  	
  	/**
   	 * The value of {@link ClientMessageBus#getSessionId()} from the browser session from which the event is caused.
   	 */
  	public String getSourceQueueSessionId() {
    	return sourceQueueSessionId;
  	}
}
