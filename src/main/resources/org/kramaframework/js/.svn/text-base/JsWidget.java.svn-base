package org.kramaframework.js;

import java.util.Vector;


/**
 * Used to specify a dependency of widget
 * 
 * @author chabane
 * @version 1.0
 */
public class JsWidget {


	// Javascript Source code 
	private String javascript;
	
	// Javascript dependencies used by a widget
	private Vector dependencies;

	/**
	 * Constructor
	 */
	public JsWidget() {
		
		// init
		dependencies = new Vector();
		javascript = "";
	}

	/**
	 * Add a javascript dependency
	 * @param dependencyName
	 */
	public void addDependency(String dependencyName) {
			dependencies.add(dependencyName);
	}

	/**
	 * Add a javascript source code to execute a widget
	 * @param sourceCode
	 */
	public void addJavascript(String sourceCode) {
		javascript += sourceCode;
	}

	/**
	 * Get a list of javascript depandencies
	 * @return all dependencies
	 */
	public Vector getDependencies() {
		return dependencies;
	}
	
	/**
	 * Get javascript used by widget
	 * @return javascript of Widget
	 */
	public String getJavascript(){
		return javascript;
	}

	/**
	 * Add a javascript dependency from others widgets
	 * @param dependences
	 */
	public void addDependencies(Vector Dependencies) {
		dependencies.addAll(Dependencies);
	}
}
