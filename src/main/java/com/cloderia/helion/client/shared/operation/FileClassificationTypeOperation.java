/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.FileClassificationType;

/**
 * @author adrian
 *
 */
@Portable
public class FileClassificationTypeOperation extends AbstractOperation {

	private final FileClassificationType fileClassificationType;

  	public FileClassificationTypeOperation(final @MapsTo("fileClassificationType") FileClassificationType fileClassificationType, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.fileClassificationType = fileClassificationType;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link FileClassificationType} that has been created or updated.
   	 */
  	public FileClassificationType getData() {
    	return fileClassificationType;
  	}
  	
  	
}

