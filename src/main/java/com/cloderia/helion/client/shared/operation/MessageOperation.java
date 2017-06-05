/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.Message;

/**
 * @author adrian
 *
 */
@Portable
public class MessageOperation extends AbstractOperation {

	private final Message message;

  	public MessageOperation(final @MapsTo("message") Message message, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.message = message;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link Message} that has been created or updated.
   	 */
  	public Message getData() {
    	return message;
  	}
  	
  	
}

