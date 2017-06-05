/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.Subject;

/**
 * @author adrian
 *
 */
@Portable
public class SubjectOperation extends AbstractOperation {

	private final Subject subject;

	protected Integer subjectTypeId;

  	public SubjectOperation(final @MapsTo("subject") Subject subject, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.subject = subject;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link Subject} that has been created or updated.
   	 */
  	public Subject getData() {
    	return subject;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getSubjectTypeId() {
    	return subjectTypeId;
  	}

  	/**
   	 * .
   	 */
  	public void setSubjectTypeId(Integer subjectTypeId) {
    	this.subjectTypeId = subjectTypeId;
  	}
}

