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

import com.cloderia.helion.client.shared.model.Party;
import com.cloderia.helion.client.shared.model.PartyType;
import com.cloderia.helion.client.shared.operation.PartyOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Party Partys}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PartyEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<Party> findAll() {
		return em.createNamedQuery(Party.ALL_PARTY_QUERY, Party.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public Party findByCode(String code){
		try {
			return em.createNamedQuery(Party.FIND_PARTY_BY_CODE_QUERY, Party.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param party
	 */
  	public void create(final PartyOperation partyOps) {
		Party party = partyOps.getData();
  		party.setPartyType(em.find(PartyType.class, partyOps.getPartyTypeId()));
  		this.doBeforeCreateEntity(party);
    	em.persist(party);
  	}
	
	/**
	 * @param party
	 */
  	public void update(final Party party) {
    	em.merge(party);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final Party party = em.find(Party.class, id);
    	if (party != null) {
      		em.remove(party);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + Party.class.getSimpleName());
    	}
  	}
	/**
	 * @return
	 */
	public List<Party> findByType(String partyTypeCode){
		return em.createNamedQuery(Party.FIND_PARTY_BY_TYPE_CODE_QUERY, Party.class)
		.setParameter("entityCode", partyTypeCode.toUpperCase()).getResultList();
	}
	

}
