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

import com.cloderia.helion.client.shared.model.Business;
import com.cloderia.helion.client.shared.model.Currency;
import com.cloderia.helion.client.shared.model.Location;
import com.cloderia.helion.client.shared.operation.BusinessOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Business Businesss}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class BusinessEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<Business> findAll() {
		return em.createNamedQuery(Business.ALL_BUSINESS_QUERY, Business.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public Business findByCode(String code){
		try {
			return em.createNamedQuery(Business.FIND_BUSINESS_BY_CODE_QUERY, Business.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param business
	 */
  	public void create(final BusinessOperation businessOps) {
		Business business = businessOps.getData();
  		business.setCurrency(em.find(Currency.class, businessOps.getCurrencyId()));
  		business.setBusinessLocation(em.find(Location.class, businessOps.getBusinessLocationId()));
  		this.doBeforeCreateEntity(business);
    	em.persist(business);
  	}
	
	/**
	 * @param business
	 */
  	public void update(final Business business) {
    	em.merge(business);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final Business business = em.find(Business.class, id);
    	if (business != null) {
      		em.remove(business);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + Business.class.getSimpleName());
    	}
  	}

}
