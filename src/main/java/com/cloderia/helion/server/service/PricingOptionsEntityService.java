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

import com.cloderia.helion.client.shared.model.PricingOptions;
import com.cloderia.helion.client.shared.operation.PricingOptionsOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link PricingOptions PricingOptionss}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PricingOptionsEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<PricingOptions> findAll() {
		return em.createNamedQuery(PricingOptions.ALL_PRICINGOPTIONS_QUERY, PricingOptions.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public PricingOptions findByCode(String code){
		try {
			return em.createNamedQuery(PricingOptions.FIND_PRICINGOPTIONS_BY_CODE_QUERY, PricingOptions.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param pricingOptions
	 */
  	public void create(final PricingOptionsOperation pricingOptionsOps) {
		PricingOptions pricingOptions = pricingOptionsOps.getData();
  		this.doBeforeCreateEntity(pricingOptions);
    	em.persist(pricingOptions);
  	}
	
	/**
	 * @param pricingOptions
	 */
  	public void update(final PricingOptions pricingOptions) {
    	em.merge(pricingOptions);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final PricingOptions pricingOptions = em.find(PricingOptions.class, id);
    	if (pricingOptions != null) {
      		em.remove(pricingOptions);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + PricingOptions.class.getSimpleName());
    	}
  	}

}
