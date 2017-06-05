/**
 * Copyright (C) 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cloderia.helion.client.local.ui;

import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.errai.common.client.api.IsElement;
import org.jboss.errai.common.client.dom.HTMLElement;
import org.jboss.errai.common.client.dom.MouseEvent;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.ForEvent;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.slf4j.Logger;

import com.cloderia.helion.client.local.ui.page.CreateLoginPage;
import com.google.gwt.dom.client.AnchorElement;

/**
 * <p>
 * An Errai UI component for displaying a bootstrap 3 navigation bar.
 */
@Templated("page/app-page.html#header")
public class PortalHeader implements IsElement {

    @Inject
    private Logger logger;
    
	@Inject
	@Named("portalHeader")
	@DataField
	private HTMLElement header;

	private AnchorElement headerSignoutLink;

	@Inject
	private TransitionTo<CreateLoginPage> transitionToLoginPage;
	
	/**
  	 * @param event
  	 */
  	@EventHandler("headerSignoutLink")
    public void onSignoutLinkClicked(final @ForEvent("click") MouseEvent event) {
  		transitionToLoginPage.go();
  		logger.info("####################################");
    }
    

	@Override
	public HTMLElement getElement() {
		return header;
	}

	public void add(final HTMLElement element) {

	}

	public void remove(final HTMLElement element) {

	}
}
