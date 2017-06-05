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

import com.cloderia.helion.client.shared.model.ClassificationType;
import com.cloderia.helion.client.shared.operation.ClassificationTypeOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link ClassificationType ClassificationTypes}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ClassificationTypeEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<ClassificationType> findAll() {
		return em.createNamedQuery(ClassificationType.ALL_CLASSIFICATIONTYPE_QUERY, ClassificationType.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public ClassificationType findByCode(String code){
		try {
			return em.createNamedQuery(ClassificationType.FIND_CLASSIFICATIONTYPE_BY_CODE_QUERY, ClassificationType.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param classificationType
	 */
  	public void create(final ClassificationTypeOperation classificationTypeOps) {
		ClassificationType classificationType = classificationTypeOps.getData();
  		this.doBeforeCreateEntity(classificationType);
    	em.persist(classificationType);
  	}
	
	/**
	 * @param classificationType
	 */
  	public void update(final ClassificationType classificationType) {
    	em.merge(classificationType);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final ClassificationType classificationType = em.find(ClassificationType.class, id);
    	if (classificationType != null) {
      		em.remove(classificationType);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + ClassificationType.class.getSimpleName());
    	}
  	}

}
