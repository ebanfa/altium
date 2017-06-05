package com.cloderia.helion.client.local.ui.page;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.common.client.dom.DOMUtil;
import org.jboss.errai.common.client.dom.HTMLElement;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.databinding.client.components.ListComponent;
import org.jboss.errai.databinding.client.components.ListContainer;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cloderia.helion.client.local.ui.AbstractListPage;
import com.cloderia.helion.client.shared.model.Assignment;
import com.cloderia.helion.client.shared.service.AssignmentStorageService;

/**
 * 
 */
@Page(path = "/listAssignment")
@Templated(value = "list-assignment-page.html#app-container")
public class ListAssignmentPage extends AbstractListPage {

  	@Inject
  	@AutoBound
  	private DataBinder<List<Assignment>> binder;
  
  	@Inject
  	@Bound
  	@DataField
  	private ListComponent<Assignment, ListAssignmentItemDisplay> entityDataList;

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
		DOMUtil.removeAllChildren(notificationsContainer);
		notificationsContainer.appendChild(listLoadingNotification);
		entityDataService.call(new RemoteCallback<List<Assignment>>() {
			@Override
			public void callback(List<Assignment> entities) {
				notificationsContainer.removeChild(listLoadingNotification);
				if (entities.isEmpty()) 
					notificationsContainer.appendChild(listEmptyNotification);
				else {
					binder.getModel().addAll(entities);
				}
			}
		}).findAll();
	}
}

