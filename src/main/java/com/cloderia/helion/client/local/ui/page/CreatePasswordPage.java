/**
 * 
 */

package com.cloderia.helion.client.local.ui.page;

import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.jboss.errai.ui.nav.client.local.TransitionAnchor;

import com.cloderia.helion.client.local.ui.AbstractPage;

/**
 * 
 */
@Page(path = "/createPassword")
@Templated(value = "create-password-page.html#app-container")
public class CreatePasswordPage extends AbstractPage {
	
  	@Inject
  	@DataField
  	private PasswordEditor passwordEditor;
  	
	@Inject 
	@DataField 
	TransitionAnchor<CreateLoginPage> linkToLoginPage;
	
	@Inject 
	@DataField 
	TransitionAnchor<CreateSignupPage> linkToSignupPage;
  
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

}
