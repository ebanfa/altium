package com.cloderia.helion.client.local.ui.page;


import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.errai.common.client.dom.Div;
import org.jboss.errai.common.client.api.IsElement;
import org.jboss.errai.common.client.dom.TableCell;
import org.jboss.errai.common.client.dom.TableRow;
import org.jboss.errai.common.client.dom.HTMLElement;
import org.jboss.errai.common.client.dom.MouseEvent;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.ForEvent;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cloderia.helion.client.shared.util.DateConverter;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * 
 */
@Templated(value = "list-account-page.html#accountListItem")
public class ListAccountItemDisplay extends BaseAccountView implements IsElement {

  	/**
   	 * This element is the root element of this component (as declared in the {@code #account} fragment of the
   	 * {@link Templated#value()} above).
     */
  	@Inject
  	@DataField
  	private TableRow accountListItem;
  	
  	@Inject
  	@DataField
  	private Div listItemBody;
  	
  	@Inject 
	TransitionTo<SingleAccountPage> transitionToSinglePage;

	@Inject
  	@Named("td")
	@Bound @DataField
  	private TableCell entityCode;
  	
  	@Inject
  	@Named("td")
	@Bound @DataField
  	private TableCell name;
  	
  	@Inject
  	@Named("td")
	@Bound @DataField
  	private TableCell userName;
  	
  	@Inject
  	@Named("td")
	@Bound @DataField
  	private TableCell password;
  	
  	@Inject
	@Bound(converter = DateConverter.class) @DataField
	/*
	 * We specify a converter because Errai does not provide built-in conversion from String to Date.
	 */
  	@Named("td")
  	private TableCell dateCreated;
  	
  	@Inject
	@Bound @DataField
  	@Named("td")
  	private TableCell description;
  	

  	
  	/**
  	 * @param event
  	 */
  	@EventHandler("listItemBody")
    public void onListItemBodylicked(final @ForEvent("click") MouseEvent event) {
		Multimap<String, String> params = HashMultimap.create();
		params.put("code", getValue().getEntityCode());
		transitionToSinglePage.go(params);
    }
    
  	@Override
  	public HTMLElement getElement() {
    	return accountListItem;
  	}

}
