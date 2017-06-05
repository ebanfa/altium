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

import com.cloderia.helion.client.shared.model.Subject;
import com.cloderia.helion.client.shared.model.SubjectType;
import com.cloderia.helion.client.shared.operation.SubjectOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Subject Subjects}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class SubjectEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<Subject> findAll() {
		return em.createNamedQuery(Subject.ALL_SUBJECT_QUERY, Subject.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public Subject findByCode(String code){
		try {
			return em.createNamedQuery(Subject.FIND_SUBJECT_BY_CODE_QUERY, Subject.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param subject
	 */
  	public void create(final SubjectOperation subjectOps) {
		Subject subject = subjectOps.getData();
  		subject.setSubjectType(em.find(SubjectType.class, subjectOps.getSubjectTypeId()));
  		this.doBeforeCreateEntity(subject);
    	em.persist(subject);
  	}
	
	/**
	 * @param subject
	 */
  	public void update(final Subject subject) {
    	em.merge(subject);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final Subject subject = em.find(Subject.class, id);
    	if (subject != null) {
      		em.remove(subject);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + Subject.class.getSimpleName());
    	}
  	}
	/**
	 * @return
	 */
	public List<Subject> findByType(String subjectTypeCode){
		return em.createNamedQuery(Subject.FIND_SUBJECT_BY_TYPE_CODE_QUERY, Subject.class)
		.setParameter("entityCode", subjectTypeCode.toUpperCase()).getResultList();
	}
	

}
