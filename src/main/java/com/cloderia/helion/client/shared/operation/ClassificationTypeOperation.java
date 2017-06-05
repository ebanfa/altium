/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.ClassificationType;

/**
 * @author adrian
 *
 */
@Portable
public class ClassificationTypeOperation extends AbstractOperation {

	private final ClassificationType classificationType;

  	public ClassificationTypeOperation(final @MapsTo("classificationType") ClassificationType classificationType, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.classificationType = classificationType;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link ClassificationType} that has been created or updated.
   	 */
  	public ClassificationType getData() {
    	return classificationType;
  	}
  	
  	
}

