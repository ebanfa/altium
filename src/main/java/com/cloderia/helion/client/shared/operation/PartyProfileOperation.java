/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.PartyProfile;

/**
 * @author adrian
 *
 */
@Portable
public class PartyProfileOperation extends AbstractOperation {

	private final PartyProfile partyProfile;

	protected Integer profilePartyId;

	protected Integer profileImageId;

  	public PartyProfileOperation(final @MapsTo("partyProfile") PartyProfile partyProfile, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.partyProfile = partyProfile;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link PartyProfile} that has been created or updated.
   	 */
  	public PartyProfile getData() {
    	return partyProfile;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getProfilePartyId() {
    	return profilePartyId;
  	}

  	/**
   	 * .
   	 */
  	public void setProfilePartyId(Integer profilePartyId) {
    	this.profilePartyId = profilePartyId;
  	}

  	/**
   	 * 
   	 */
  	public Integer getProfileImageId() {
    	return profileImageId;
  	}

  	/**
   	 * .
   	 */
  	public void setProfileImageId(Integer profileImageId) {
    	this.profileImageId = profileImageId;
  	}
}

