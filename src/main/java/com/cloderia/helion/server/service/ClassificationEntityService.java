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

import com.cloderia.helion.client.shared.model.Classification;
import com.cloderia.helion.client.shared.model.ClassificationType;
import com.cloderia.helion.client.shared.operation.ClassificationOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Classification Classifications}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ClassificationEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<Classification> findAll() {
		return em.createNamedQuery(Classification.ALL_CLASSIFICATION_QUERY, Classification.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public Classification findByCode(String code){
		try {
			return em.createNamedQuery(Classification.FIND_CLASSIFICATION_BY_CODE_QUERY, Classification.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param classification
	 */
  	public void create(final ClassificationOperation classificationOps) {
		Classification classification = classificationOps.getData();
  		classification.setClassType(em.find(ClassificationType.class, classificationOps.getClassTypeId()));
  		this.doBeforeCreateEntity(classification);
    	em.persist(classification);
  	}
	
	/**
	 * @param classification
	 */
  	public void update(final Classification classification) {
    	em.merge(classification);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final Classification classification = em.find(Classification.class, id);
    	if (classification != null) {
      		em.remove(classification);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + Classification.class.getSimpleName());
    	}
  	}
	/**
	 * @return
	 */
	public List<Classification> findByType(String classificationTypeCode){
		return em.createNamedQuery(Classification.FIND_CLASSIFICATION_BY_TYPE_CODE_QUERY, Classification.class)
		.setParameter("entityCode", classificationTypeCode.toUpperCase()).getResultList();
	}
	

}
