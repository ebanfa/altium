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

import com.cloderia.helion.client.shared.model.PartyType;
import com.cloderia.helion.client.shared.model.PartyCategory;
import com.cloderia.helion.client.shared.operation.PartyTypeOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link PartyType PartyTypes}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PartyTypeEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<PartyType> findAll() {
		return em.createNamedQuery(PartyType.ALL_PARTYTYPE_QUERY, PartyType.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public PartyType findByCode(String code){
		try {
			return em.createNamedQuery(PartyType.FIND_PARTYTYPE_BY_CODE_QUERY, PartyType.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param partyType
	 */
  	public void create(final PartyTypeOperation partyTypeOps) {
		PartyType partyType = partyTypeOps.getData();
  		partyType.setPartyCategory(em.find(PartyCategory.class, partyTypeOps.getPartyCategoryId()));
  		this.doBeforeCreateEntity(partyType);
    	em.persist(partyType);
  	}
	
	/**
	 * @param partyType
	 */
  	public void update(final PartyType partyType) {
    	em.merge(partyType);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final PartyType partyType = em.find(PartyType.class, id);
    	if (partyType != null) {
      		em.remove(partyType);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + PartyType.class.getSimpleName());
    	}
  	}

}
