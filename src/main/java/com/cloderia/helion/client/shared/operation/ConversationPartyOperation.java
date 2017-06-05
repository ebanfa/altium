/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.ConversationParty;

/**
 * @author adrian
 *
 */
@Portable
public class ConversationPartyOperation extends AbstractOperation {

	private final ConversationParty conversationParty;

	protected Integer partyConvId;

	protected Integer convPartyId;

  	public ConversationPartyOperation(final @MapsTo("conversationParty") ConversationParty conversationParty, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.conversationParty = conversationParty;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link ConversationParty} that has been created or updated.
   	 */
  	public ConversationParty getData() {
    	return conversationParty;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getPartyConvId() {
    	return partyConvId;
  	}

  	/**
   	 * .
   	 */
  	public void setPartyConvId(Integer partyConvId) {
    	this.partyConvId = partyConvId;
  	}

  	/**
   	 * 
   	 */
  	public Integer getConvPartyId() {
    	return convPartyId;
  	}

  	/**
   	 * .
   	 */
  	public void setConvPartyId(Integer convPartyId) {
    	this.convPartyId = convPartyId;
  	}
}

