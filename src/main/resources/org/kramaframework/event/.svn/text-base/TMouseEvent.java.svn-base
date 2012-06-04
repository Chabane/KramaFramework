package org.kramaframework.event;

import java.util.List;

import org.kramaframework.exception.KramaReflectionIllegalArgumentException;
import org.kramaframework.listener.TListener;
import org.kramaframework.util.TJsFunction;
import org.kramaframework.util.TUtil;

import com.sun.corba.se.impl.javax.rmi.CORBA.Util;

/**
 * This class content all method called by mouse event
 * @author chabane
 * @version 1.0
 */
public class TMouseEvent extends TEvent{

	/**
	 * Constructor
	 */
	public TMouseEvent(TListener mlistner){
		super(mlistner);
	}
	
	/**
	 * This method allows to build a javascript function for generate javascript
	 * code later
	 * 
	 * @param _class
	 * @param _method
	 * @param _params
	 * @param _event 
	 * @return String
	 */
	public static void show(String viewAjax, String _class, String methode, List params, String event) {
		
		try{
			// Add a function call built on widget
			mlistner.addFunctionCall(buildFunctionCall(viewAjax, _class, methode, params, "showData"));
			
			// Add type of event
			mlistner.addEvent(event);
			
			// Add a javascript dependency necessary to execute a widget
			mlistner.addJsDependency("Prototype");
			
			// Add a javascript function necessary to work
			mlistner.setJavascript(TJsFunction.showData());
			
		}catch(KramaReflectionIllegalArgumentException e){
			e.printStackTrace();
		}
	}
}
