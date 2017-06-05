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

import com.cloderia.helion.client.shared.model.LocationType;
import com.cloderia.helion.client.shared.operation.LocationTypeOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link LocationType LocationTypes}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class LocationTypeEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<LocationType> findAll() {
		return em.createNamedQuery(LocationType.ALL_LOCATIONTYPE_QUERY, LocationType.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public LocationType findByCode(String code){
		try {
			return em.createNamedQuery(LocationType.FIND_LOCATIONTYPE_BY_CODE_QUERY, LocationType.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param locationType
	 */
  	public void create(final LocationTypeOperation locationTypeOps) {
		LocationType locationType = locationTypeOps.getData();
  		this.doBeforeCreateEntity(locationType);
    	em.persist(locationType);
  	}
	
	/**
	 * @param locationType
	 */
  	public void update(final LocationType locationType) {
    	em.merge(locationType);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final LocationType locationType = em.find(LocationType.class, id);
    	if (locationType != null) {
      		em.remove(locationType);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + LocationType.class.getSimpleName());
    	}
  	}

}
