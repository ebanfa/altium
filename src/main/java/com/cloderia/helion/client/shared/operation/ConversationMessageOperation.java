/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.ConversationMessage;

/**
 * @author adrian
 *
 */
@Portable
public class ConversationMessageOperation extends AbstractOperation {

	private final ConversationMessage conversationMessage;

	protected Integer msgConvId;

	protected Integer toPartyId;

	protected Integer fromPartyId;

  	public ConversationMessageOperation(final @MapsTo("conversationMessage") ConversationMessage conversationMessage, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.conversationMessage = conversationMessage;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link ConversationMessage} that has been created or updated.
   	 */
  	public ConversationMessage getData() {
    	return conversationMessage;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getMsgConvId() {
    	return msgConvId;
  	}

  	/**
   	 * .
   	 */
  	public void setMsgConvId(Integer msgConvId) {
    	this.msgConvId = msgConvId;
  	}

  	/**
   	 * 
   	 */
  	public Integer getToPartyId() {
    	return toPartyId;
  	}

  	/**
   	 * .
   	 */
  	public void setToPartyId(Integer toPartyId) {
    	this.toPartyId = toPartyId;
  	}

  	/**
   	 * 
   	 */
  	public Integer getFromPartyId() {
    	return fromPartyId;
  	}

  	/**
   	 * .
   	 */
  	public void setFromPartyId(Integer fromPartyId) {
    	this.fromPartyId = fromPartyId;
  	}
}

