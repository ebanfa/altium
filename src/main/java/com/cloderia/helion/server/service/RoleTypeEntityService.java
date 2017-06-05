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

import com.cloderia.helion.client.shared.model.RoleType;
import com.cloderia.helion.client.shared.operation.RoleTypeOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link RoleType RoleTypes}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RoleTypeEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<RoleType> findAll() {
		return em.createNamedQuery(RoleType.ALL_ROLETYPE_QUERY, RoleType.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public RoleType findByCode(String code){
		try {
			return em.createNamedQuery(RoleType.FIND_ROLETYPE_BY_CODE_QUERY, RoleType.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param roleType
	 */
  	public void create(final RoleTypeOperation roleTypeOps) {
		RoleType roleType = roleTypeOps.getData();
  		this.doBeforeCreateEntity(roleType);
    	em.persist(roleType);
  	}
	
	/**
	 * @param roleType
	 */
  	public void update(final RoleType roleType) {
    	em.merge(roleType);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final RoleType roleType = em.find(RoleType.class, id);
    	if (roleType != null) {
      		em.remove(roleType);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + RoleType.class.getSimpleName());
    	}
  	}

}
