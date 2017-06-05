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

import com.cloderia.helion.client.shared.model.AcademicLevel;
import com.cloderia.helion.client.shared.operation.AcademicLevelOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link AcademicLevel AcademicLevels}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AcademicLevelEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<AcademicLevel> findAll() {
		return em.createNamedQuery(AcademicLevel.ALL_ACADEMICLEVEL_QUERY, AcademicLevel.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public AcademicLevel findByCode(String code){
		try {
			return em.createNamedQuery(AcademicLevel.FIND_ACADEMICLEVEL_BY_CODE_QUERY, AcademicLevel.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param academicLevel
	 */
  	public void create(final AcademicLevelOperation academicLevelOps) {
		AcademicLevel academicLevel = academicLevelOps.getData();
  		this.doBeforeCreateEntity(academicLevel);
    	em.persist(academicLevel);
  	}
	
	/**
	 * @param academicLevel
	 */
  	public void update(final AcademicLevel academicLevel) {
    	em.merge(academicLevel);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final AcademicLevel academicLevel = em.find(AcademicLevel.class, id);
    	if (academicLevel != null) {
      		em.remove(academicLevel);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + AcademicLevel.class.getSimpleName());
    	}
  	}

}
