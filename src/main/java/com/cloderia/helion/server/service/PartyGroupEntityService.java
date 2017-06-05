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

import com.cloderia.helion.client.shared.model.PartyGroup;
import com.cloderia.helion.client.shared.model.Party;
import com.cloderia.helion.client.shared.operation.PartyGroupOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link PartyGroup PartyGroups}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PartyGroupEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<PartyGroup> findAll() {
		return em.createNamedQuery(PartyGroup.ALL_PARTYGROUP_QUERY, PartyGroup.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public PartyGroup findByCode(String code){
		try {
			return em.createNamedQuery(PartyGroup.FIND_PARTYGROUP_BY_CODE_QUERY, PartyGroup.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param partyGroup
	 */
  	public void create(final PartyGroupOperation partyGroupOps) {
		PartyGroup partyGroup = partyGroupOps.getData();
  		partyGroup.setGroupParty(em.find(Party.class, partyGroupOps.getGroupPartyId()));
  		this.doBeforeCreateEntity(partyGroup);
    	em.persist(partyGroup);
  	}
	
	/**
	 * @param partyGroup
	 */
  	public void update(final PartyGroup partyGroup) {
    	em.merge(partyGroup);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final PartyGroup partyGroup = em.find(PartyGroup.class, id);
    	if (partyGroup != null) {
      		em.remove(partyGroup);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + PartyGroup.class.getSimpleName());
    	}
  	}

}
