/**
 * 
 */

package com.cloderia.helion.client.local.ui.page;

import java.util.List;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.common.client.dom.DateInput;
import org.jboss.errai.common.client.dom.Div;
import org.jboss.errai.common.client.dom.TextArea;
import org.jboss.errai.common.client.dom.TextInput;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.dom.client.AnchorElement;

import com.cloderia.helion.client.local.ui.EntityEditor;
import com.cloderia.helion.client.local.ui.NativeUIFunctions;

import com.cloderia.helion.client.shared.model.Signup;
import com.cloderia.helion.client.shared.operation.SignupOperation;
import com.cloderia.helion.client.shared.operation.Operation;
import com.cloderia.helion.client.shared.service.SignupStorageService;
import com.cloderia.helion.client.shared.util.DateConverter;

import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.ListBox;

/**
 * 
 */
@Templated(value = "create-signup-page.html#entityEditor")
public class SignupEditor extends EntityEditor<Signup> {
  	
  	@Inject
  	@DataField
  	private AnchorElement submitBtn;

  	@Inject
	@Bound @DataField
  	private TextInput userName;
  	
  	@Inject
	@Bound @DataField
  	private TextInput password;
  	
	
  	@Inject
  	protected Caller<SignupStorageService> entityDataService;

	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.EntityEditor#init()
	 */
	@Override
	public void init() {
	}
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.Editor#load(java.lang.String)
	 */
	@Override
	public void load(String entityCode) {
	}
  	
  	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.EntityEditor#save()
	 */
	@Override
	public void save() {
		// No validation errors we now execute the remote call 
		entityDataService.call((final Response response) -> {
		}).create(new SignupOperation(getValue(), bus.getSessionId()));
	}
	/**
	 * 
	 */
	protected native void registerHandlers()/*-{
  		var theInstance = this;
		$wnd.$('.selectpicker').on('changed.bs.select', function (e, clickedIndex, newValue, oldValue) {
			var id = e.target.id;
        	theInstance.@com.cloderia.helion.client.local.ui.page.SignupEditor::onChangedBSSelect(Ljava/lang/String;Ljava/lang/String;)(id, clickedIndex);
        });
	}-*/;

	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.EntityEditor#onChangedBSSelect()
	 */
	protected void onChangedBSSelect(String id, String clickedIndex) {
	}

}
