/**
 * 
 */
package com.cloderia.helion.client.local.ui;

import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.errai.common.client.dom.HTMLElement;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.slf4j.Logger;

/**
 * @author Adrian Haldermann
 *
 */
public class AbstractSinglePage extends PortalPage {


  	@Inject
  	protected Logger logger;

	@Inject 
	@Named("div")
  	@DataField
  	protected HTMLElement entityEmptyNotification;
  	
  	@Inject 
  	@Named("div")
  	@DataField
  	protected HTMLElement entityLoadingNotification;
  	
  	@Inject 
  	@Named("div")
  	@DataField
  	protected HTMLElement notificationsContainer;
}
