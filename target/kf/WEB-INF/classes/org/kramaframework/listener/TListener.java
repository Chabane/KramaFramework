package org.kramaframework.listener;

import org.kramaframework.js.Function;

/**
 * Abstract class which content a method necessary to manage a listener
 * @author chabane
 * @version
 */
public abstract class TListener {
	
	/**
	 * Add a building of function call. It's added in value of HTML event 
	 * @param functionCall
	 */
	public abstract void addFunctionCall(String functionCall);
	
	/**
	 * Add a event to widget
	 * @param event
	 */
	public abstract void addEvent(String event);
	
	/**
	 * Add a javascript dependency used by Widgets
	 * @param event
	 */
	public abstract void addJsDependency(String event);
	
	/**
	 * Add a source code of a javascript function
	 * @param function
	 */
	public abstract void addJsFunction(Function function);
	
	/**
	 * Update a source code javascript in an existent source code 
	 * @param javascript
	 */
	public abstract void setJavascript(String javascript);
}
