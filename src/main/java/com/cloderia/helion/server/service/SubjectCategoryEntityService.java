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

import com.cloderia.helion.client.shared.model.SubjectCategory;
import com.cloderia.helion.client.shared.operation.SubjectCategoryOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link SubjectCategory SubjectCategorys}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class SubjectCategoryEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<SubjectCategory> findAll() {
		return em.createNamedQuery(SubjectCategory.ALL_SUBJECTCATEGORY_QUERY, SubjectCategory.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public SubjectCategory findByCode(String code){
		try {
			return em.createNamedQuery(SubjectCategory.FIND_SUBJECTCATEGORY_BY_CODE_QUERY, SubjectCategory.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param subjectCategory
	 */
  	public void create(final SubjectCategoryOperation subjectCategoryOps) {
		SubjectCategory subjectCategory = subjectCategoryOps.getData();
  		this.doBeforeCreateEntity(subjectCategory);
    	em.persist(subjectCategory);
  	}
	
	/**
	 * @param subjectCategory
	 */
  	public void update(final SubjectCategory subjectCategory) {
    	em.merge(subjectCategory);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final SubjectCategory subjectCategory = em.find(SubjectCategory.class, id);
    	if (subjectCategory != null) {
      		em.remove(subjectCategory);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + SubjectCategory.class.getSimpleName());
    	}
  	}

}
