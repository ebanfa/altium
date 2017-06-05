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
import com.cloderia.helion.client.shared.model.PricingOptions;
import com.cloderia.helion.client.shared.service.PricingOptionsStorageService;

/**
 * 
 */
@Page(path = "/listPricingOptions")
@Templated(value = "list-pricingoptions-page.html#app-container")
public class ListPricingOptionsPage extends AbstractListPage {

  	@Inject
  	@AutoBound
  	private DataBinder<List<PricingOptions>> binder;
  
  	@Inject
  	@Bound
  	@DataField
  	@ListContainer(value = "tbody")
  	private ListComponent<PricingOptions, ListPricingOptionsItemDisplay> entityDataList;

  	/**
     * This is a simple interface for calling a remote HTTP service. Behind this interface, Errai has generated an HTTP
   	 * request to the service defined by {@link PricingOptionsStorageService} (a JaxRS service).
   	 */
  	@Inject
  	private Caller<PricingOptionsStorageService> entityDataService;
  	
  	@Inject
  	@Named("div")
  	@DataField 
  	private HTMLElement tableContainer;
  	
  	
  	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.AbstractPage#doPostConstruct()
	 */
	@Override
	protected void doPostConstruct() {
		artifactHeader.setTextContent("Message");
		DOMUtil.removeAllChildren(notificationsContainer);
		notificationsContainer.appendChild(listLoadingNotification);
		entityDataService.call(new RemoteCallback<List<PricingOptions>>() {
			@Override
			public void callback(List<PricingOptions> entities) {
				notificationsContainer.removeChild(listLoadingNotification);
				if (entities.isEmpty()) 
					notificationsContainer.appendChild(listEmptyNotification);
				else {
					DOMUtil.removeCSSClass(tableContainer, "invisible");
					binder.getModel().addAll(entities);
				}
			}
		}).findAll();
	}
}

