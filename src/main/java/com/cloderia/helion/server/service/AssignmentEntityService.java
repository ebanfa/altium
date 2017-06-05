/**
 * 
 */

package com.cloderia.helion.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cloderia.helion.client.shared.model.Assignment;
import com.cloderia.helion.client.shared.model.Classification;
import com.cloderia.helion.client.shared.model.Subject;
import com.cloderia.helion.client.shared.model.AcademicLevel;
import com.cloderia.helion.client.shared.model.WritingStyle;
import com.cloderia.helion.client.shared.model.Urgency;
import com.cloderia.helion.client.shared.operation.AssignmentOperation;

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Assignment Assignments}.
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AssignmentEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<Assignment> findAll() {
		return em.createNamedQuery(Assignment.ALL_ASSIGNMENT_QUERY, Assignment.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public Assignment findByCode(String code){
		try {
			return em.createNamedQuery(Assignment.FIND_ASSIGNMENT_BY_CODE_QUERY, Assignment.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param assignment
	 */
  	public void create(final AssignmentOperation assignmentOps) {
		Assignment assignment = assignmentOps.getData();
  		assignment.setDocType(em.find(Classification.class, assignmentOps.getDocTypeId()));
  		assignment.setSubject(em.find(Subject.class, assignmentOps.getSubjectId()));
  		assignment.setAlevel(em.find(AcademicLevel.class, assignmentOps.getAlevelId()));
  		assignment.setStyle(em.find(WritingStyle.class, assignmentOps.getStyleId()));
  		assignment.setUrgency(em.find(Urgency.class, assignmentOps.getUrgencyId()));
  		assignment.setDateCreated(new Date());
  		assignment.setDueDate(new Date());
  		System.out.println(assignment);
  		this.doBeforeCreateEntity(assignment);
    	em.persist(assignment);
  	}
	
	/**
	 * @param assignment
	 */
  	public void update(final Assignment assignment) {
    	em.merge(assignment);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final Assignment assignment = em.find(Assignment.class, id);
    	if (assignment != null) {
      		em.remove(assignment);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + Assignment.class.getSimpleName());
    	}
  	}

}
