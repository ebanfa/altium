/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.Classification;

/**
 * @author adrian
 *
 */
@Portable
public class ClassificationOperation extends AbstractOperation {

	private final Classification classification;

	protected Integer classTypeId;

  	public ClassificationOperation(final @MapsTo("classification") Classification classification, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.classification = classification;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link Classification} that has been created or updated.
   	 */
  	public Classification getData() {
    	return classification;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getClassTypeId() {
    	return classTypeId;
  	}

  	/**
   	 * .
   	 */
  	public void setClassTypeId(Integer classTypeId) {
    	this.classTypeId = classTypeId;
  	}
}

