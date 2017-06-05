/**
 * 
 */

package com.cloderia.helion.server.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cloderia.helion.client.shared.model.PartyProfile;
import com.cloderia.helion.client.shared.model.Party;
import com.cloderia.helion.client.shared.model.File;
import com.cloderia.helion.client.shared.operation.PartyProfileOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link PartyProfile PartyProfiles}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PartyProfileEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<PartyProfile> findAll() {
		return em.createNamedQuery(PartyProfile.ALL_PARTYPROFILE_QUERY, PartyProfile.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public PartyProfile findByCode(String code){
		try {
			return em.createNamedQuery(PartyProfile.FIND_PARTYPROFILE_BY_CODE_QUERY, PartyProfile.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param partyProfile
	 */
  	public void create(final PartyProfileOperation partyProfileOps) {
		PartyProfile partyProfile = partyProfileOps.getData();
  		partyProfile.setProfileParty(em.find(Party.class, partyProfileOps.getProfilePartyId()));
  		partyProfile.setProfileImage(em.find(File.class, partyProfileOps.getProfileImageId()));
  		this.doBeforeCreateEntity(partyProfile);
    	em.persist(partyProfile);
  	}
	
	/**
	 * @param partyProfile
	 */
  	public void update(final PartyProfile partyProfile) {
    	em.merge(partyProfile);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final PartyProfile partyProfile = em.find(PartyProfile.class, id);
    	if (partyProfile != null) {
      		em.remove(partyProfile);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + PartyProfile.class.getSimpleName());
    	}
  	}

}
