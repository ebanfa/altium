/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.Party;

/**
 * @author adrian
 *
 */
@Portable
public class PartyOperation extends AbstractOperation {

	private final Party party;

	protected Integer partyTypeId;

  	public PartyOperation(final @MapsTo("party") Party party, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.party = party;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link Party} that has been created or updated.
   	 */
  	public Party getData() {
    	return party;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getPartyTypeId() {
    	return partyTypeId;
  	}

  	/**
   	 * .
   	 */
  	public void setPartyTypeId(Integer partyTypeId) {
    	this.partyTypeId = partyTypeId;
  	}
}

