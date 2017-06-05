package com.cloderia.helion.client.local.ui.page;


import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.errai.common.client.api.IsElement;
import org.jboss.errai.common.client.dom.Div;
import org.jboss.errai.common.client.dom.Span;
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
@Templated(value = "list-assignment-page.html#assignmentListItem")
public class ListAssignmentItemDisplay extends BaseAssignmentView implements IsElement {

  	/**
   	 * This element is the root element of this component (as declared in the {@code #assignment} fragment of the
   	 * {@link Templated#value()} above).
     */
  	@Inject
  	@DataField
  	private Div assignmentListItem;

	@Inject
	@Bound @DataField
  	private Div name;
  	
  	@Inject
  	@DataField
  	private Div listItemBody;
  	
  	@Inject 
	TransitionTo<SingleAssignmentPage> transitionToSinglePage;

	@Inject
	@Bound @DataField
	@Named("small")
  	private HTMLElement description;

	@Inject
	@Bound(converter = DateConverter.class) @DataField
  	private Span dateCreated;

	@Inject
	@Bound @DataField
  	private Span pageCount;
  	
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
    	return assignmentListItem;
  	}

}
