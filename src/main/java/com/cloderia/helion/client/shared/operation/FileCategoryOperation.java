/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.FileCategory;

/**
 * @author adrian
 *
 */
@Portable
public class FileCategoryOperation extends AbstractOperation {

	private final FileCategory fileCategory;

  	public FileCategoryOperation(final @MapsTo("fileCategory") FileCategory fileCategory, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.fileCategory = fileCategory;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link FileCategory} that has been created or updated.
   	 */
  	public FileCategory getData() {
    	return fileCategory;
  	}
  	
  	
}

