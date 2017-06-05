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

import com.cloderia.helion.client.shared.model.SubjectType;
import com.cloderia.helion.client.shared.model.SubjectCategory;
import com.cloderia.helion.client.shared.operation.SubjectTypeOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link SubjectType SubjectTypes}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class SubjectTypeEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<SubjectType> findAll() {
		return em.createNamedQuery(SubjectType.ALL_SUBJECTTYPE_QUERY, SubjectType.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public SubjectType findByCode(String code){
		try {
			return em.createNamedQuery(SubjectType.FIND_SUBJECTTYPE_BY_CODE_QUERY, SubjectType.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param subjectType
	 */
  	public void create(final SubjectTypeOperation subjectTypeOps) {
		SubjectType subjectType = subjectTypeOps.getData();
  		subjectType.setSubjectCategory(em.find(SubjectCategory.class, subjectTypeOps.getSubjectCategoryId()));
  		this.doBeforeCreateEntity(subjectType);
    	em.persist(subjectType);
  	}
	
	/**
	 * @param subjectType
	 */
  	public void update(final SubjectType subjectType) {
    	em.merge(subjectType);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final SubjectType subjectType = em.find(SubjectType.class, id);
    	if (subjectType != null) {
      		em.remove(subjectType);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + SubjectType.class.getSimpleName());
    	}
  	}

}
