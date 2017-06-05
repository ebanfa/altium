/**
 * 
 */
package com.cloderia.helion.client.local.ui;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.bus.client.api.ClientMessageBus;
import org.jboss.errai.ui.nav.client.local.NavigationPanel;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageHiding;
import org.jboss.errai.ui.nav.client.local.PageShown;

import com.cloderia.helion.client.shared.operation.AbstractOperation;

/**
 * @author adrian
 *
 */
public abstract class AbstractPage extends UiComponent {
  	
  	@Inject
  	protected ClientMessageBus bus;
  	
  	/**
	 * 
	 */
  	@PostConstruct
	protected void setUp(){
  		this.doPostConstruct();
	}
	
	/**
     * This method is invoked when this {@link Page} is attached to the {@link NavigationPanel}.
     */
  	@PageShown
  	public void onPageShown() {
  		this.doPageShown();
  	}

    /**
     * This method is invoked when this {@link Page} is being removed from the {@link NavigationPanel}.
     */
  	@PageHiding
  	public void onPageHiding() {
  		this.doPageHiding();
  	}

	/**
	 * 
	 */
	protected abstract void doPostConstruct();
	
	/**
	 * 
	 */
	protected abstract void doPageShown();
	
	/**
	 * 
	 */
	protected abstract void doPageHiding();

  	/**
     * For ignoring remote events that originate from this client.
     */
  	protected boolean sourceIsNotThisClient(final AbstractOperation entityOperation) {
    	return entityOperation.getSourceQueueSessionId() == null || !entityOperation.getSourceQueueSessionId().equals(bus.getSessionId());
  	}
}
