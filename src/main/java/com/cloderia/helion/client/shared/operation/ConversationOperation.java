/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.Conversation;

/**
 * @author adrian
 *
 */
@Portable
public class ConversationOperation extends AbstractOperation {

	private final Conversation conversation;

	protected Integer convTypeId;

  	public ConversationOperation(final @MapsTo("conversation") Conversation conversation, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.conversation = conversation;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link Conversation} that has been created or updated.
   	 */
  	public Conversation getData() {
    	return conversation;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getConvTypeId() {
    	return convTypeId;
  	}

  	/**
   	 * .
   	 */
  	public void setConvTypeId(Integer convTypeId) {
    	this.convTypeId = convTypeId;
  	}
}

