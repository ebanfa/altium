/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.Location;

/**
 * @author adrian
 *
 */
@Portable
public class LocationOperation extends AbstractOperation {

	private final Location location;

	protected Integer locationTypeId;

	protected Integer parentLocationId;

	protected Integer locationCurrencyId;

  	public LocationOperation(final @MapsTo("location") Location location, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.location = location;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link Location} that has been created or updated.
   	 */
  	public Location getData() {
    	return location;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getLocationTypeId() {
    	return locationTypeId;
  	}

  	/**
   	 * .
   	 */
  	public void setLocationTypeId(Integer locationTypeId) {
    	this.locationTypeId = locationTypeId;
  	}

  	/**
   	 * 
   	 */
  	public Integer getParentLocationId() {
    	return parentLocationId;
  	}

  	/**
   	 * .
   	 */
  	public void setParentLocationId(Integer parentLocationId) {
    	this.parentLocationId = parentLocationId;
  	}

  	/**
   	 * 
   	 */
  	public Integer getLocationCurrencyId() {
    	return locationCurrencyId;
  	}

  	/**
   	 * .
   	 */
  	public void setLocationCurrencyId(Integer locationCurrencyId) {
    	this.locationCurrencyId = locationCurrencyId;
  	}
}

