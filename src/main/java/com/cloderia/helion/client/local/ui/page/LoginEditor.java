/**
 * 
 */

package com.cloderia.helion.client.local.ui.page;

import java.util.Set;

import static com.cloderia.helion.client.shared.operation.Operation.OperationType.LOGIN_FAILED;
import static com.cloderia.helion.client.shared.operation.Operation.OperationType.LOGIN_SUCCESSFUL;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;

import org.jboss.errai.common.client.api.IsElement;
import org.jboss.errai.common.client.dom.DateInput;
import org.jboss.errai.common.client.dom.Div;
import org.jboss.errai.common.client.dom.HTMLElement;
import org.jboss.errai.common.client.dom.MouseEvent;
import org.jboss.errai.common.client.dom.TextArea;
import org.jboss.errai.common.client.dom.TextInput;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.ForEvent;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.dom.client.AnchorElement;

import com.cloderia.helion.client.shared.model.Login;
import com.cloderia.helion.client.shared.operation.LoginOperation;
import com.cloderia.helion.client.shared.operation.Operation;
import com.cloderia.helion.client.shared.util.DateConverter;
import com.cloderia.helion.client.shared.util.NotificationUtil;

import com.google.gwt.http.client.Response;
/**
 * 
 */
@Templated(value = "create-login-page.html#loginEditor")
public class LoginEditor extends BaseLoginView implements IsElement {
  	
  	@Inject
  	@DataField
  	private AnchorElement submitBtn;
  	
  	/**
   	 * This element is the root element of this component (as declared in the {@code #login} fragment of the
   	 * {@link Templated#value()} above).
     */
  	@Inject
  	@DataField
  	private Div loginEditor;

  	@Inject
	@Bound @DataField
  	private TextInput userName;
  	
  	@Inject
	@Bound @DataField
  	private TextInput password;
  	
    
  	/**
  	 * @param event
  	 */
  	@EventHandler("submitBtn")
    public void onSubmitBtnClicked(final @ForEvent("click") MouseEvent event) {
		NotificationUtil.processing("Authenticating ...");
		Set<ConstraintViolation<Login>> violations = validator.validate(this.binder.getModel());
		if(!violations.isEmpty()){
			NotificationUtil.warn(extractViolations(violations).toString());
		}else {
			// No validation errors we now execute the remote call 
			entityDataService.call((final Response response) -> {
				NotificationUtil.close();
			}).login(new LoginOperation(this.binder.getModel(), bus.getSessionId()));
		}
    }
    
    /**
   	 *
   	 */
  	public void onRemoteCreated(final @Observes @Operation(LOGIN_FAILED) LoginOperation loginOperation) {
    	NotificationUtil.warn("Invalid usernamer or password");
  	}
    
	/* (non-Javadoc)
  	 * @see org.jboss.errai.common.client.api.IsElement#getElement()
  	 */
  	@Override
  	public HTMLElement getElement() {
    	return loginEditor;
  	}

}
