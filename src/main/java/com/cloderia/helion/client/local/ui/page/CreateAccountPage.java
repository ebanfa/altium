/**
 * 
 */

package com.cloderia.helion.client.local.ui.page;

import static com.cloderia.helion.client.shared.operation.Operation.OperationType.CREATE;
import static com.cloderia.helion.client.shared.operation.Operation.OperationType.CREATE_FAILED;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cloderia.helion.client.local.ui.AbstractCreatePage;
import com.cloderia.helion.client.shared.operation.AccountOperation;
import com.cloderia.helion.client.shared.operation.Operation;
import com.cloderia.helion.client.shared.util.NotificationUtil;

/**
 * 
 */
@Page(path = "/createAccount")
@Templated(value = "create-account-page.html#app-container")
public class CreateAccountPage extends AbstractCreatePage {
	
  	private static final String HEADER_TEXT = "Account Details";

	@Inject
  	@DataField
  	private AccountEditor entityEditor;
  	
  	@Inject 
	TransitionTo<ListAccountPage> transitionToListPage;
  
  	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.AbstractPage#doPostConstruct()
	 */
	@Override
	protected void doPostConstruct() {
		artifactHeader.setTextContent(HEADER_TEXT);
		entityEditor.init();
	}
  	
  	/**
   	 * 
   	 */
  	public void onRemoteCreated(final @Observes @Operation(CREATE) AccountOperation accountOperation) {
  		notifySuccess();
  	}
  	
  	/**
   	 *
   	 */
  	public void onRemoteCreateFailed(final @Observes @Operation(CREATE_FAILED) AccountOperation accountOperation) {
  		if(accountOperation.getSourceQueueSessionId().equals(bus.getSessionId()))
  			NotificationUtil.warn("Could not create record");
  	}
  	
  	/**
  	 * 
  	 */
  	public native void notifySuccess() /*-{
  		$wnd.swal.close();
  		var theInstance = this;
	    $wnd.swal({   
            title: "Great Job!",   
            text: "Your order has been successfully created",   
            type: "success",   
            showCancelButton: false,   
        }).then(function(){  
        	theInstance.@com.cloderia.helion.client.local.ui.page.CreateAccountPage::goTo()();
        });
	}-*/;
  	
  	public void goTo(){
    	transitionToListPage.go();
  	}

}
