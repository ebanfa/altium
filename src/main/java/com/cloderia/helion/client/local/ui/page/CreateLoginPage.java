/**
 * 
 */

package com.cloderia.helion.client.local.ui.page;

import static com.cloderia.helion.client.shared.operation.Operation.OperationType.LOGIN_SUCCESSFUL;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.jboss.errai.ui.nav.client.local.TransitionAnchor;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.slf4j.Logger;

import com.cloderia.helion.client.local.ui.AbstractPage;
import com.cloderia.helion.client.shared.operation.LoginOperation;
import com.cloderia.helion.client.shared.operation.Operation;

/**
 * 
 */
@Page(role = DefaultPage.class, path = "/createLogin")
@Templated(value = "create-login-page.html#app-container")
public class CreateLoginPage extends AbstractPage {

    @Inject
    private Logger logger;
	
  	@Inject
  	@DataField
  	private LoginEditor loginEditor;
  	
	@Inject 
	@DataField 
	TransitionAnchor<CreatePasswordPage> linkToPasswordPage;
	
	@Inject 
	@DataField 
	TransitionAnchor<CreateSignupPage> linkToSignupPage;
	
	@Inject 
	TransitionTo<ListAssignmentPage> transitionToFeedPage;
  
  	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.AbstractPage#doPostConstruct()
	 */
	@Override
	protected void doPostConstruct() {
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.AbstractPage#doPageShown()
	 */
	@Override
	protected void doPageShown() {
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.AbstractPage#doPageHiding()
	 */
	@Override
	protected void doPageHiding() {
	}
	
    /**
   	 * This is called in response to Errai CDI {@link javax.enterprise.event.Event Events} fired from the server when a
   	 * new {@link Contact} is created. In this way we can display newly created contacts from other browser sessions.
   	 */
  	public void onRemoteCreated(final @Observes @Operation(LOGIN_SUCCESSFUL) LoginOperation loginOperation) {
    	transitionToFeedPage.go();
  	}
}
