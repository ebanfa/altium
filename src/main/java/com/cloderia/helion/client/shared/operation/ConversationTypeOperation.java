/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.ConversationType;

/**
 * @author adrian
 *
 */
@Portable
public class ConversationTypeOperation extends AbstractOperation {

	private final ConversationType conversationType;

	protected Integer convCategoryId;

  	public ConversationTypeOperation(final @MapsTo("conversationType") ConversationType conversationType, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.conversationType = conversationType;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link ConversationType} that has been created or updated.
   	 */
  	public ConversationType getData() {
    	return conversationType;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getConvCategoryId() {
    	return convCategoryId;
  	}

  	/**
   	 * .
   	 */
  	public void setConvCategoryId(Integer convCategoryId) {
    	this.convCategoryId = convCategoryId;
  	}
}

