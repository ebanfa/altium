/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.ClassifiedFile;

/**
 * @author adrian
 *
 */
@Portable
public class ClassifiedFileOperation extends AbstractOperation {

	private final ClassifiedFile classifiedFile;

	protected Integer classFileId;

	protected Integer fileClassId;

  	public ClassifiedFileOperation(final @MapsTo("classifiedFile") ClassifiedFile classifiedFile, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.classifiedFile = classifiedFile;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link ClassifiedFile} that has been created or updated.
   	 */
  	public ClassifiedFile getData() {
    	return classifiedFile;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getClassFileId() {
    	return classFileId;
  	}

  	/**
   	 * .
   	 */
  	public void setClassFileId(Integer classFileId) {
    	this.classFileId = classFileId;
  	}

  	/**
   	 * 
   	 */
  	public Integer getFileClassId() {
    	return fileClassId;
  	}

  	/**
   	 * .
   	 */
  	public void setFileClassId(Integer fileClassId) {
    	this.fileClassId = fileClassId;
  	}
}

