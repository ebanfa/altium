package com.cloderia.helion.client.local.ui.page;

import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cloderia.helion.client.local.ui.PortalPage;
import com.cloderia.helion.client.shared.model.Account;
import com.cloderia.helion.client.shared.service.AccountStorageService;

/**
 * 
 */
@Page(path = "/listAccount")
@Templated(value = "list-account-page.html#app-container")
public class ListAccountPage extends PortalPage {

  	@Inject
  	@AutoBound
  	private DataBinder<Account> binder;

  	/**
     * This is a simple interface for calling a remote HTTP service. Behind this interface, Errai has generated an HTTP
   	 * request to the service defined by {@link AccountStorageService} (a JaxRS service).
   	 */
  	@Inject
  	private Caller<AccountStorageService> entityDataService;
  	
  	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.PortalPage#doPostConstruct()
	 */
	@Override
	protected void doPostConstruct() {
	
	}
}

