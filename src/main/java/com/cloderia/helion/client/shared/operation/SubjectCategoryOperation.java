/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.SubjectCategory;

/**
 * @author adrian
 *
 */
@Portable
public class SubjectCategoryOperation extends AbstractOperation {

	private final SubjectCategory subjectCategory;

  	public SubjectCategoryOperation(final @MapsTo("subjectCategory") SubjectCategory subjectCategory, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.subjectCategory = subjectCategory;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link SubjectCategory} that has been created or updated.
   	 */
  	public SubjectCategory getData() {
    	return subjectCategory;
  	}
  	
  	
}

