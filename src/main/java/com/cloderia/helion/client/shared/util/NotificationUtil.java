/**
 * 
 */
package com.cloderia.helion.client.shared.util;

/**
 * @author adrian
 *
 */
public class NotificationUtil {
	
	/**
  	 * 
  	 */
  	public static native void success(String message) /*-{
  		$wnd.swal.close();
	    $wnd.swal({   
            title: "Great Job!",   
            text: message,   
            type: "success",   
            showCancelButton: false,   
        });
	}-*/;

  	/**
  	 * 
  	 */
  	public static native void warn(String message) /*-{
  		$wnd.swal.close();
	    $wnd.swal({   
            title: "Oops!",   
            text: message,   
            type: "warning",   
            showCancelButton: false,   
        });
	}-*/;
  	
  	/**
  	 * 
  	 */
  	public static native void processing(String message) /*-{
  		$wnd.swal.close();
	    $wnd.swal({title: "Please wait!", text: message, showConfirmButton: false });
	}-*/;
  	
  	/**
  	 * 
  	 */
  	public static native void close() /*-{
	    $wnd.swal.close();
	}-*/;
}
