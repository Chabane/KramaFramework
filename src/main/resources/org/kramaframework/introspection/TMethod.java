package org.kramaframework.introspection;

import java.util.List;

/**
 * Class used to define a java method
 * @author chabane
 * @version 1.0
 */
public class TMethod {

	// Name of class
	private String _class;
	
	// Name of method
	private String _method;
	
	// Types of parameters
	private List<String> _params;

	/**
	 * getters and setters
	 */
	public String get_class() {
		return _class;
	}

	public void set_class(String _class) {
		this._class = _class;
	}

	public String get_method() {
		return _method;
	}

	public void set_method(String _method) {
		this._method = _method;
	}

	public List<String> get_params() {
		return _params;
	}

	public void set_params(List<String> _params) {
		this._params = _params;
	}
}
