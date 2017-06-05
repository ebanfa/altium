/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.PartyRole;

/**
 * @author adrian
 *
 */
@Portable
public class PartyRoleOperation extends AbstractOperation {

	private final PartyRole partyRole;

	protected Integer partyRolePartyId;

	protected Integer RoleTypeId;

  	public PartyRoleOperation(final @MapsTo("partyRole") PartyRole partyRole, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.partyRole = partyRole;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link PartyRole} that has been created or updated.
   	 */
  	public PartyRole getData() {
    	return partyRole;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getPartyRolePartyId() {
    	return partyRolePartyId;
  	}

  	/**
   	 * .
   	 */
  	public void setPartyRolePartyId(Integer partyRolePartyId) {
    	this.partyRolePartyId = partyRolePartyId;
  	}

  	/**
   	 * 
   	 */
  	public Integer getRoleTypeId() {
    	return RoleTypeId;
  	}

  	/**
   	 * .
   	 */
  	public void setRoleTypeId(Integer RoleTypeId) {
    	this.RoleTypeId = RoleTypeId;
  	}
}

