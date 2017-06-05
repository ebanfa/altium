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
import com.cloderia.helion.client.shared.model.Assignment;
import com.cloderia.helion.client.shared.service.AssignmentStorageService;

/**
 * 
 */
@Page(path = "/singleAssignment/{code}")
@Templated(value = "single-assignment-page.html#app-container")
public class SingleAssignmentPage extends AbstractSinglePage {
	
	@PageState
	private String code;
	
  	@Inject
  	@DataField
  	private AssignmentDisplay assignmentDisplay;
  	
  	@Inject
  	@DataField
  	@Named("div")
  	private HTMLElement entityDisplayContainer;
  	
  	@Inject 
	TransitionTo<ListAssignmentPage> transitionToListPage;
	
	/**
     * This is a simple interface for calling a remote HTTP service. Behind this interface, Errai has generated an HTTP
   	 * request to the service defined by {@link AssignmentStorageService} (a JaxRS service).
   	 */
  	@Inject
  	private Caller<AssignmentStorageService> entityDataService;
  
  	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.AbstractPage#doPostConstruct()
	 */
	@Override
	protected void doPostConstruct() {
		artifactHeader.setTextContent("Assignment");
		notificationsContainer.appendChild(entityLoadingNotification);
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.AbstractPage#doPageShown()
	 */
	@Override
	protected void doPageShown() {
		entityDataService.call(new RemoteCallback<Assignment>() {
			@Override
			public void callback(Assignment entity) {
				notificationsContainer.removeChild(entityLoadingNotification);
				if (entity == null) {
					notificationsContainer.appendChild(entityEmptyNotification);
				}
				else {
					DOMUtil.removeCSSClass(entityDisplayContainer, "invisible");
					assignmentDisplay.setValue(entity);
				}
			}
		}).findByCode(code);
	}
}
