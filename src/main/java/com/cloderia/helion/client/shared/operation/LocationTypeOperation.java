/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.LocationType;

/**
 * @author adrian
 *
 */
@Portable
public class LocationTypeOperation extends AbstractOperation {

	private final LocationType locationType;

  	public LocationTypeOperation(final @MapsTo("locationType") LocationType locationType, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.locationType = locationType;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link LocationType} that has been created or updated.
   	 */
  	public LocationType getData() {
    	return locationType;
  	}
  	
  	
}

