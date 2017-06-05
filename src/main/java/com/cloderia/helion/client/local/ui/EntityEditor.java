/**
 * 
 */
package com.cloderia.helion.client.local.ui;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.jboss.errai.common.client.api.IsElement;
import org.jboss.errai.common.client.dom.Div;
import org.jboss.errai.common.client.dom.HTMLElement;
import org.jboss.errai.common.client.dom.MouseEvent;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.ForEvent;

import com.cloderia.helion.client.shared.model.BaseEntity;
import com.cloderia.helion.client.shared.util.NotificationUtil;
import com.google.gwt.user.client.TakesValue;

/**
 * @author adrian
 *
 */
public abstract class EntityEditor<V extends BaseEntity> extends BaseEntityComponent implements Editor, IsElement,  TakesValue<V>{
  	
  	/**
   	 * This element is the root element of this component.
     */
  	@Inject
  	@DataField
  	private Div entityEditor; 
	
	@Inject
	@AutoBound
	protected DataBinder<V> binder;
  	
  	/**
  	 * 
  	 */
  	@Inject
  	protected Validator validator;

	/* (non-Javadoc)
	 * @see org.jboss.errai.common.client.api.IsElement#getElement()
	 */
	@Override
	public HTMLElement getElement() {
		return entityEditor;
	}
  	
  	/**
  	 * @param event
  	 */
  	@EventHandler("submitBtn")
    public void onSubmitBtnClicked(final @ForEvent("click") MouseEvent event) {
		Set<ConstraintViolation<V>> violations = validator.validate(getValue());
		if(!violations.isEmpty())	
			NotificationUtil.warn(extractViolations(violations).toString());
		else save();
    }

	/**
	 * @param violations
	 * @return
	 */
	protected StringBuffer extractViolations(Set<ConstraintViolation<V>> violations) {
		StringBuffer messages = new StringBuffer();
		for (ConstraintViolation<V> violation : violations) {
			messages.append(violation.getMessage() + " <br>");
		}
		return messages;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.TakesValue#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(V value) {
		this.binder.setModel(value);
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.TakesValue#getValue()
	 */
	@Override
	public V getValue() {
		return this.binder.getModel();
	}
	
}
