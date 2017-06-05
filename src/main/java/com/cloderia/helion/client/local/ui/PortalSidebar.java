/**
 * 
 */
package com.cloderia.helion.client.local.ui;

import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.errai.common.client.api.IsElement;
import org.jboss.errai.common.client.dom.HTMLElement;
import org.jboss.errai.ui.nav.client.local.TransitionAnchor;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cloderia.helion.client.local.ui.page.CreateAssignmentPage;
import com.cloderia.helion.client.local.ui.page.ListAccountPage;
import com.cloderia.helion.client.local.ui.page.ListAssignmentPage;
import com.cloderia.helion.client.local.ui.page.ListMessagePage;

/**
 * @author adrian
 *
 */
@Templated("page/app-page.html#sidebar")
public class PortalSidebar implements IsElement {

	@Inject @Named("aside")
	@DataField
	private HTMLElement sidebar;

	@Inject 
	@DataField 
	TransitionAnchor<ListAssignmentPage> linkToListAssignmentsPage;

	@Inject 
	@DataField 
	TransitionAnchor<ListAccountPage> linkToProfilePage;
	
	@Inject 
	@DataField 
	TransitionAnchor<ListMessagePage> linkToInboxPage;
	
	@Inject 
	@DataField 
	TransitionAnchor<CreateAssignmentPage> linkToPostAssignmentPage;
	
	/* (non-Javadoc)
	 * @see org.jboss.errai.common.client.api.IsElement#getElement()
	 */
	@Override
	public HTMLElement getElement() {
		return sidebar;
	}

}
