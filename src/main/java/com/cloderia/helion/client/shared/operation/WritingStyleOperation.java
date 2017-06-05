/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.WritingStyle;

/**
 * @author adrian
 *
 */
@Portable
public class WritingStyleOperation extends AbstractOperation {

	private final WritingStyle writingStyle;

  	public WritingStyleOperation(final @MapsTo("writingStyle") WritingStyle writingStyle, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.writingStyle = writingStyle;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link WritingStyle} that has been created or updated.
   	 */
  	public WritingStyle getData() {
    	return writingStyle;
  	}
  	
  	
}

