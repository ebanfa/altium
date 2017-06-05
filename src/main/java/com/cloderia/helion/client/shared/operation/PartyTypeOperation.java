/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.PartyType;

/**
 * @author adrian
 *
 */
@Portable
public class PartyTypeOperation extends AbstractOperation {

	private final PartyType partyType;

	protected Integer partyCategoryId;

  	public PartyTypeOperation(final @MapsTo("partyType") PartyType partyType, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.partyType = partyType;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link PartyType} that has been created or updated.
   	 */
  	public PartyType getData() {
    	return partyType;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getPartyCategoryId() {
    	return partyCategoryId;
  	}

  	/**
   	 * .
   	 */
  	public void setPartyCategoryId(Integer partyCategoryId) {
    	this.partyCategoryId = partyCategoryId;
  	}
}

