/**
 * 
 */

package com.cloderia.helion.client.local.ui.page;

import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.common.client.dom.DOMUtil;
import org.jboss.errai.common.client.dom.HTMLElement;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageState;

import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cloderia.helion.client.local.ui.AbstractSinglePage;
import com.cloderia.helion.client.shared.model.Message;
import com.cloderia.helion.client.shared.service.MessageStorageService;

/**
 * 
 */
@Page(path = "/singleMessage/{code}")
@Templated(value = "single-message-page.html#app-container")
public class SingleMessagePage extends AbstractSinglePage {
	
	@PageState
	private String code;
	
  	@Inject
  	@DataField
  	private MessageDisplay messageDisplay;
  	
  	@Inject
  	@DataField
  	@Named("div")
  	private HTMLElement entityDisplayContainer;
  	
  	@Inject 
	TransitionTo<ListMessagePage> transitionToListPage;
	
	/**
     * This is a simple interface for calling a remote HTTP service. Behind this interface, Errai has generated an HTTP
   	 * request to the service defined by {@link MessageStorageService} (a JaxRS service).
   	 */
  	@Inject
  	private Caller<MessageStorageService> entityDataService;
  
  	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.AbstractPage#doPostConstruct()
	 */
	@Override
	protected void doPostConstruct() {
		artifactHeader.setTextContent("Message");
		notificationsContainer.appendChild(entityLoadingNotification);
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.AbstractPage#doPageShown()
	 */
	@Override
	protected void doPageShown() {
		entityDataService.call(new RemoteCallback<Message>() {
			@Override
			public void callback(Message entity) {
				notificationsContainer.removeChild(entityLoadingNotification);
				if (entity == null) {
					notificationsContainer.appendChild(entityEmptyNotification);
				}
				else {
					DOMUtil.removeCSSClass(entityDisplayContainer, "invisible");
					messageDisplay.setValue(entity);
				}
			}
		}).findByCode(code);
	}
}
