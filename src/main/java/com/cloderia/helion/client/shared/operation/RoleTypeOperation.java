/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.RoleType;

/**
 * @author adrian
 *
 */
@Portable
public class RoleTypeOperation extends AbstractOperation {

	private final RoleType roleType;

  	public RoleTypeOperation(final @MapsTo("roleType") RoleType roleType, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.roleType = roleType;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link RoleType} that has been created or updated.
   	 */
  	public RoleType getData() {
    	return roleType;
  	}
  	
  	
}

