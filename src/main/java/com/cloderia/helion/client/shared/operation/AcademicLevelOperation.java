/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.AcademicLevel;

/**
 * @author adrian
 *
 */
@Portable
public class AcademicLevelOperation extends AbstractOperation {

	private final AcademicLevel academicLevel;

  	public AcademicLevelOperation(final @MapsTo("academicLevel") AcademicLevel academicLevel, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.academicLevel = academicLevel;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link AcademicLevel} that has been created or updated.
   	 */
  	public AcademicLevel getData() {
    	return academicLevel;
  	}
  	
  	
}

