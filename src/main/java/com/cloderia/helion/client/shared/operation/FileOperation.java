/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.File;

/**
 * @author adrian
 *
 */
@Portable
public class FileOperation extends AbstractOperation {

	private final File file;

	protected Integer fileTypeId;

  	public FileOperation(final @MapsTo("file") File file, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.file = file;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link File} that has been created or updated.
   	 */
  	public File getData() {
    	return file;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getFileTypeId() {
    	return fileTypeId;
  	}

  	/**
   	 * .
   	 */
  	public void setFileTypeId(Integer fileTypeId) {
    	this.fileTypeId = fileTypeId;
  	}
}

