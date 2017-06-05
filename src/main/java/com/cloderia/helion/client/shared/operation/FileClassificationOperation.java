/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.FileClassification;

/**
 * @author adrian
 *
 */
@Portable
public class FileClassificationOperation extends AbstractOperation {

	private final FileClassification fileClassification;

	protected Integer fclassTypeId;

  	public FileClassificationOperation(final @MapsTo("fileClassification") FileClassification fileClassification, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.fileClassification = fileClassification;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link FileClassification} that has been created or updated.
   	 */
  	public FileClassification getData() {
    	return fileClassification;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getFclassTypeId() {
    	return fclassTypeId;
  	}

  	/**
   	 * .
   	 */
  	public void setFclassTypeId(Integer fclassTypeId) {
    	this.fclassTypeId = fclassTypeId;
  	}
}

