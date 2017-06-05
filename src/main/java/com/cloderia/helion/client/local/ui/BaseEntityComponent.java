/**
 * 
 */
package com.cloderia.helion.client.local.ui;

import javax.inject.Inject;

import org.jboss.errai.bus.client.api.ClientMessageBus;
import org.slf4j.Logger;

/**
 * @author adrian
 * 
 */
public class BaseEntityComponent   {
	
    /**
     * The logger
     */
    @Inject
    protected Logger logger;
  	
  	/**
  	 * The client wide messaging bus
  	 */
  	@Inject
  	protected ClientMessageBus bus;
}
