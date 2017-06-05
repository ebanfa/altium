/**
 * 
 */
package com.cloderia.helion.client.local.ui;


/**
 * @author adrian
 *
 */
public class UiComponent {

	protected UiComponentState state = UiComponentState.NOTHING;
	
	public enum UiComponentState {
		NOTHING, LOADING, NONE, ONE, SOME, TOO_MANY, IN_CORRECT, CORRECT, DONE,
	}
	
}
