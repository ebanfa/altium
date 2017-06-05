/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.PartyGroup;

/**
 * @author adrian
 *
 */
@Portable
public class PartyGroupOperation extends AbstractOperation {

	private final PartyGroup partyGroup;

	protected Integer groupPartyId;

  	public PartyGroupOperation(final @MapsTo("partyGroup") PartyGroup partyGroup, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.partyGroup = partyGroup;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link PartyGroup} that has been created or updated.
   	 */
  	public PartyGroup getData() {
    	return partyGroup;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getGroupPartyId() {
    	return groupPartyId;
  	}

  	/**
   	 * .
   	 */
  	public void setGroupPartyId(Integer groupPartyId) {
    	this.groupPartyId = groupPartyId;
  	}
}

