/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.Assignment;

/**
 * @author adrian
 *
 */
@Portable
public class AssignmentOperation extends AbstractOperation {

	private final Assignment assignment;

	protected Integer docTypeId;

	protected Integer subjectId;

	protected Integer alevelId;

	protected Integer styleId;

	protected Integer urgencyId;

  	public AssignmentOperation(final @MapsTo("assignment") Assignment assignment, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.assignment = assignment;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link Assignment} that has been created or updated.
   	 */
  	public Assignment getData() {
    	return assignment;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getDocTypeId() {
    	return docTypeId;
  	}

  	/**
   	 * .
   	 */
  	public void setDocTypeId(Integer docTypeId) {
    	this.docTypeId = docTypeId;
  	}

  	/**
   	 * 
   	 */
  	public Integer getSubjectId() {
    	return subjectId;
  	}

  	/**
   	 * .
   	 */
  	public void setSubjectId(Integer subjectId) {
    	this.subjectId = subjectId;
  	}

  	/**
   	 * 
   	 */
  	public Integer getAlevelId() {
    	return alevelId;
  	}

  	/**
   	 * .
   	 */
  	public void setAlevelId(Integer alevelId) {
    	this.alevelId = alevelId;
  	}

  	/**
   	 * 
   	 */
  	public Integer getStyleId() {
    	return styleId;
  	}

  	/**
   	 * .
   	 */
  	public void setStyleId(Integer styleId) {
    	this.styleId = styleId;
  	}

  	/**
   	 * 
   	 */
  	public Integer getUrgencyId() {
    	return urgencyId;
  	}

  	/**
   	 * .
   	 */
  	public void setUrgencyId(Integer urgencyId) {
    	this.urgencyId = urgencyId;
  	}
}

