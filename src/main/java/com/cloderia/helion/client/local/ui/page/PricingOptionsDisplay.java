/**
 * 
 */

package com.cloderia.helion.client.local.ui.page;

import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.errai.common.client.api.IsElement;
import org.jboss.errai.common.client.dom.Div;
import org.jboss.errai.common.client.dom.HTMLElement;
import org.jboss.errai.common.client.dom.Paragraph;
import org.jboss.errai.common.client.dom.Span;
import org.jboss.errai.common.client.dom.Heading;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cloderia.helion.client.shared.util.DateConverter;

/**
 * 
 */
@Templated(value = "single-pricingoptions-page.html#pricingOptionsDisplay")
public class PricingOptionsDisplay extends BasePricingOptionsView implements IsElement {
  	
  	/**
   	 * This element is the root element of this component (as declared in the {@code #pricingOptions} fragment of the
   	 * {@link Templated#value()} above).
     */
  	@Inject
  	@DataField
  	private Div pricingOptionsDisplay;

	@Inject
	@Bound @DataField
	@Named("h6")
  	private Heading name;

	@Inject
	@Bound @DataField
  	private Span entityCode;

	@Inject
	@Bound(converter = DateConverter.class) @DataField
  	private Span dateCreated;

	@Inject
	@Bound @DataField
  	private Paragraph description;
	
  	@Override
  	public HTMLElement getElement() {
    	return pricingOptionsDisplay;
  	}

}
