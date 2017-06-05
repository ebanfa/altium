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

import com.cloderia.helion.client.shared.model.Urgency;
import com.cloderia.helion.client.shared.operation.UrgencyOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Urgency Urgencys}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class UrgencyEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<Urgency> findAll() {
		return em.createNamedQuery(Urgency.ALL_URGENCY_QUERY, Urgency.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public Urgency findByCode(String code){
		try {
			return em.createNamedQuery(Urgency.FIND_URGENCY_BY_CODE_QUERY, Urgency.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param urgency
	 */
  	public void create(final UrgencyOperation urgencyOps) {
		Urgency urgency = urgencyOps.getData();
  		this.doBeforeCreateEntity(urgency);
    	em.persist(urgency);
  	}
	
	/**
	 * @param urgency
	 */
  	public void update(final Urgency urgency) {
    	em.merge(urgency);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final Urgency urgency = em.find(Urgency.class, id);
    	if (urgency != null) {
      		em.remove(urgency);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + Urgency.class.getSimpleName());
    	}
  	}

}
