/**
 * 
 */
package com.cloderia.helion.client.local.ui;

import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.errai.common.client.dom.HTMLElement;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

/**
 * @author adrian
 *
 */
@Templated(value = "page/app-page.html#app-container")
public class PortalPage extends AbstractPage {

	@Inject
	@DataField
	protected PortalHeader header;

	@Inject
	@DataField
	protected PortalSidebar sidebar;

	@Inject
	@DataField
	protected PortalFooter footer;

	@Inject
	@DataField
	@Named("div")
	protected HTMLElement artifactHeader;

	/* (non-Javadoc)//.on('dp.change', function(e){$wnd.$(this).data("DateTimePicker").hide();});
	 * @see com.cloderia.helion.client.local.ui.AbstractPage#doPostConstruct()
	 */
	@Override
	protected void doPostConstruct() {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.AbstractPage#doPageShown()
	 */
	@Override
	protected void doPageShown() {
		doDatePicker();
		doSelectPicker();
		refreshWidgets();
		
	}
	
	protected native double doDatePicker() /*-{
	   	if ($wnd.$('.datetime-picker')[0]) {
			$wnd.$('.datetime-picker').datetimepicker({
				format: 'YYYY-MM-DD'
			});
		}
	 }-*/;
	

	protected native double doSelectPicker() /*-{
		if ($wnd.$('.selectpicker')[0]) {
			$wnd.$('.selectpicker').selectpicker({
			  size: 4
			});
		}
	 }-*/;
	
	protected native void refreshWidgets() /*-{
		if ($wnd.$('.selectpicker')[0]) {
			$wnd.$('.selectpicker').selectpicker('refresh');
		}
		if ($wnd.$('.c-overflow')[0]) {
			$wnd.$('.c-overflow').mCustomScrollbar({
	            theme: 'minimal-dark',
	            scrollInertia: 100,
	            axis:'yx',
	            mouseWheel: {
	                enable: true,
	                axis: 'y',
	                preventDefault: true
	            }
	        });
		}
		//Add blue animated border and remove with condition when focus and blur
		if($wnd.$('.fg-line')[0]) {
	        $wnd.$('body').on('focus', '.fg-line .form-control', function(){
	            $wnd.$(this).closest('.fg-line').addClass('fg-toggled');
	        })
	        $wnd.$('body').on('blur', '.form-control', function(){
	            var p = $wnd.$(this).closest('.form-group, .input-group');
	            var i = p.find('.form-control').val();
	
	            if (p.hasClass('fg-float')) {
	                if (i.length == 0) {
	                    $wnd.$(this).closest('.fg-line').removeClass('fg-toggled');
	                }
	            }
	            else {
	                $wnd.$(this).closest('.fg-line').removeClass('fg-toggled');
	            }
	        });
	    }
		
	 }-*/;


	/* (non-Javadoc)
	 * @see com.cloderia.helion.client.local.ui.AbstractPage#doPageHiding()
	 */
	@Override
	protected void doPageHiding() {
		// TODO Auto-generated method stub
		
	}
	
}
