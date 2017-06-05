package com.cloderia.helion.client.local.ui.page;

import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cloderia.helion.client.local.ui.PortalPage;
import com.cloderia.helion.client.shared.model.Message;
import com.cloderia.helion.client.shared.service.MessageStorageService;

/**
 * 
 */
@Page(path = "/listMessage")
@Templated(value = "list-message-page.html#app-container")
public class ListMessagePage extends PortalPage {

  	@Inject
  	@AutoBound
  	private DataBinder<Message> binder;

  	/**
     * This is a simple interface for calling a remote HTTP service. Behind this interface, Errai has generated an HTTP
   	 * request to the service defined by {@link MessageStorageService} (a JaxRS service).
   	 */
  	@Inject
  	private Caller<MessageStorageService> entityDataService;
  	
  	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.PortalPage#doPostConstruct()
	 */
	@Override
	protected void doPostConstruct() {
	
	}
}

