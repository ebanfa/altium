/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.PartyCategory;

/**
 * @author adrian
 *
 */
@Portable
public class PartyCategoryOperation extends AbstractOperation {

	private final PartyCategory partyCategory;

  	public PartyCategoryOperation(final @MapsTo("partyCategory") PartyCategory partyCategory, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.partyCategory = partyCategory;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link PartyCategory} that has been created or updated.
   	 */
  	public PartyCategory getData() {
    	return partyCategory;
  	}
  	
  	
}

