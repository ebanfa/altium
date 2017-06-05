/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.DocumentType;

/**
 * @author adrian
 *
 */
@Portable
public class DocumentTypeOperation extends AbstractOperation {

	private final DocumentType documentType;

  	public DocumentTypeOperation(final @MapsTo("documentType") DocumentType documentType, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.documentType = documentType;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link DocumentType} that has been created or updated.
   	 */
  	public DocumentType getData() {
    	return documentType;
  	}
  	
  	
}

