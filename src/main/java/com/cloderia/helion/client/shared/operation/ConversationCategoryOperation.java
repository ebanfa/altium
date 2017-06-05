/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.ConversationCategory;

/**
 * @author adrian
 *
 */
@Portable
public class ConversationCategoryOperation extends AbstractOperation {

	private final ConversationCategory conversationCategory;

  	public ConversationCategoryOperation(final @MapsTo("conversationCategory") ConversationCategory conversationCategory, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.conversationCategory = conversationCategory;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link ConversationCategory} that has been created or updated.
   	 */
  	public ConversationCategory getData() {
    	return conversationCategory;
  	}
  	
  	
}

