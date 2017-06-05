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

import com.cloderia.helion.client.shared.model.Location;
import com.cloderia.helion.client.shared.model.LocationType;
import com.cloderia.helion.client.shared.model.Location;
import com.cloderia.helion.client.shared.model.Currency;
import com.cloderia.helion.client.shared.operation.LocationOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Location Locations}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class LocationEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<Location> findAll() {
		return em.createNamedQuery(Location.ALL_LOCATION_QUERY, Location.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public Location findByCode(String code){
		try {
			return em.createNamedQuery(Location.FIND_LOCATION_BY_CODE_QUERY, Location.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param location
	 */
  	public void create(final LocationOperation locationOps) {
		Location location = locationOps.getData();
  		location.setLocationType(em.find(LocationType.class, locationOps.getLocationTypeId()));
  		location.setParentLocation(em.find(Location.class, locationOps.getParentLocationId()));
  		location.setLocationCurrency(em.find(Currency.class, locationOps.getLocationCurrencyId()));
  		this.doBeforeCreateEntity(location);
    	em.persist(location);
  	}
	
	/**
	 * @param location
	 */
  	public void update(final Location location) {
    	em.merge(location);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final Location location = em.find(Location.class, id);
    	if (location != null) {
      		em.remove(location);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + Location.class.getSimpleName());
    	}
  	}
	/**
	 * @return
	 */
	public List<Location> findByType(String locationTypeCode){
		return em.createNamedQuery(Location.FIND_LOCATION_BY_TYPE_CODE_QUERY, Location.class)
		.setParameter("entityCode", locationTypeCode.toUpperCase()).getResultList();
	}
	

}
