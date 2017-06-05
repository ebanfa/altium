/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.FileType;

/**
 * @author adrian
 *
 */
@Portable
public class FileTypeOperation extends AbstractOperation {

	private final FileType fileType;

	protected Integer fileCategoryId;

  	public FileTypeOperation(final @MapsTo("fileType") FileType fileType, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.fileType = fileType;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link FileType} that has been created or updated.
   	 */
  	public FileType getData() {
    	return fileType;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getFileCategoryId() {
    	return fileCategoryId;
  	}

  	/**
   	 * .
   	 */
  	public void setFileCategoryId(Integer fileCategoryId) {
    	this.fileCategoryId = fileCategoryId;
  	}
}

