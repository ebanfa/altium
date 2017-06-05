/**
 * 
 */
package com.cloderia.helion.client.local.ui;

/**
 * @author adrian
 *
 */
public class NativeUIFunctions {

	
	public static native double doDatePicker() /*-{
	   	if ($wnd.$('.datetime-picker')[0]) {
			$wnd.$('.datetime-picker').datetimepicker({
				format: 'YYYY-MM-DD'
			});
		}
	 }-*/;
	

	public static native double doSelectPicker() /*-{
		if ($wnd.$('.selectpicker')[0]) {
			$wnd.$('.selectpicker').selectpicker({
			  size: 4
			});
		}
	 }-*/;
	
	public static native void refreshWidgets() /*-{
		if ($wnd.$('.selectpicker')[0]) {
			$wnd.$('.selectpicker').selectpicker('refresh');
		}
		$wnd.$('.selectpicker').selectpicker('val', 1); 
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
		$wnd.$('.selectpicker').selectpicker('val', 1);
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
	
}
