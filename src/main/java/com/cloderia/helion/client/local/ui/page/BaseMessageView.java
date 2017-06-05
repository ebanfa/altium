
package com.cloderia.helion.client.local.ui.page;

import static com.cloderia.helion.client.shared.operation.Operation.OperationType.CREATE_FAILED;

import java.util.Set;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.jboss.errai.bus.client.api.ClientMessageBus;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.slf4j.Logger;

import com.cloderia.helion.client.shared.model.Message;
import com.cloderia.helion.client.shared.operation.MessageOperation;
import com.cloderia.helion.client.shared.operation.Operation;
import com.cloderia.helion.client.shared.service.MessageStorageService;
import com.cloderia.helion.client.shared.util.NotificationUtil;

import com.google.gwt.user.client.TakesValue;

/**
 * <p>
 * A base class for Errai UI components that are views for {@link Message Messages}.
 *
 * <p>
 * This class has an {@link AutoBound @AutoBound} {@link DataBinder} so that UI components in subclasses annotated with
 * {@link Bound @Bound} are kept in sync with the assigned {@link Message} model properties via Errai Data Binding.
 */
public class BaseMessageView implements TakesValue<Message> {
	
    @Inject
    protected Logger logger;
  	
  	@Inject
  	protected Validator validator;
  	
  	@Inject
  	protected ClientMessageBus bus;
  	
  	/**
     * This is a simple interface for calling a remote HTTP service. Behind this interface, Errai has generated an HTTP
   	 * request to the service defined by {@link MessageStorageService} (a JaxRS service).
   	 */
  	@Inject
  	protected Caller<MessageStorageService> entityDataService;
	
	@Inject
	@AutoBound
	protected DataBinder<Message> binder;

	@Override
	public Message getValue() {
		return binder.getModel();
	}

	@Override
	public void setValue(final Message model) {
		binder.setModel(model);
	}

	/**
	 * @param violations
	 * @return
	 */
	protected StringBuffer extractViolations(Set<ConstraintViolation<Message>> violations) {
		StringBuffer messages = new StringBuffer();
		for (ConstraintViolation<Message> violation : violations) {
			messages.append(violation.getMessage() + " <br>");
		}
		return messages;
	}
	
	/**
   	 *
   	 */
  	public void onRemoteCreateFailed(final @Observes @Operation(CREATE_FAILED) MessageOperation messageOperation) {
  		if(messageOperation.getSourceQueueSessionId().equals(bus.getSessionId()))
  			NotificationUtil.warn("Could not create record");
  	}

}