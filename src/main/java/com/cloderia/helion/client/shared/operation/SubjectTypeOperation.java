/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.SubjectType;

/**
 * @author adrian
 *
 */
@Portable
public class SubjectTypeOperation extends AbstractOperation {

	private final SubjectType subjectType;

	protected Integer subjectCategoryId;

  	public SubjectTypeOperation(final @MapsTo("subjectType") SubjectType subjectType, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.subjectType = subjectType;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link SubjectType} that has been created or updated.
   	 */
  	public SubjectType getData() {
    	return subjectType;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getSubjectCategoryId() {
    	return subjectCategoryId;
  	}

  	/**
   	 * .
   	 */
  	public void setSubjectCategoryId(Integer subjectCategoryId) {
    	this.subjectCategoryId = subjectCategoryId;
  	}
}

