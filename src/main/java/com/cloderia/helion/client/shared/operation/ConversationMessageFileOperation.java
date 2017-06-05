/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.ConversationMessageFile;

/**
 * @author adrian
 *
 */
@Portable
public class ConversationMessageFileOperation extends AbstractOperation {

	private final ConversationMessageFile conversationMessageFile;

	protected Integer convMsgId;

	protected Integer msgFileId;

  	public ConversationMessageFileOperation(final @MapsTo("conversationMessageFile") ConversationMessageFile conversationMessageFile, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.conversationMessageFile = conversationMessageFile;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link ConversationMessageFile} that has been created or updated.
   	 */
  	public ConversationMessageFile getData() {
    	return conversationMessageFile;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getConvMsgId() {
    	return convMsgId;
  	}

  	/**
   	 * .
   	 */
  	public void setConvMsgId(Integer convMsgId) {
    	this.convMsgId = convMsgId;
  	}

  	/**
   	 * 
   	 */
  	public Integer getMsgFileId() {
    	return msgFileId;
  	}

  	/**
   	 * .
   	 */
  	public void setMsgFileId(Integer msgFileId) {
    	this.msgFileId = msgFileId;
  	}
}

