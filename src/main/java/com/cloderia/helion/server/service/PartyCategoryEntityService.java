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

import com.cloderia.helion.client.shared.model.PartyCategory;
import com.cloderia.helion.client.shared.operation.PartyCategoryOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link PartyCategory PartyCategorys}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PartyCategoryEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<PartyCategory> findAll() {
		return em.createNamedQuery(PartyCategory.ALL_PARTYCATEGORY_QUERY, PartyCategory.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public PartyCategory findByCode(String code){
		try {
			return em.createNamedQuery(PartyCategory.FIND_PARTYCATEGORY_BY_CODE_QUERY, PartyCategory.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param partyCategory
	 */
  	public void create(final PartyCategoryOperation partyCategoryOps) {
		PartyCategory partyCategory = partyCategoryOps.getData();
  		this.doBeforeCreateEntity(partyCategory);
    	em.persist(partyCategory);
  	}
	
	/**
	 * @param partyCategory
	 */
  	public void update(final PartyCategory partyCategory) {
    	em.merge(partyCategory);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final PartyCategory partyCategory = em.find(PartyCategory.class, id);
    	if (partyCategory != null) {
      		em.remove(partyCategory);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + PartyCategory.class.getSimpleName());
    	}
  	}

}
