package org.kramaframework.js;

import java.util.Vector;

/**
 * This class defined a simple javascript function
 * @author chabane
 * @version 1.0
 */
public class Function {

	// Name of function
	private String nameFunction;
	// Parameters of function
	private Vector paramFunction;
	// Body content of function
	private String bodyFunction;
	
	/**
	 * Constructor
	 * @param nameFunction
	 * @param paramFunction
	 * @param bodyFunction
	 */
	public Function(String nameFunction, Vector paramFunction,
			String bodyFunction) {

		this.nameFunction = nameFunction;
		this.paramFunction = paramFunction;
		this.bodyFunction = bodyFunction;
	}
	
	/**
	 * This method build a function from attributs
	 * @return a function in string format
	 */
	public String buildFunction(){
		String params = "";
		
		// Add a parameters in signature of function
		for(int i = 0; i < paramFunction.size(); i++)
			if(i ==  paramFunction.size() - 1)
				params += paramFunction.get(i);
			else 
				params += paramFunction+ ", ";
		
		return "function "+nameFunction+"("+params+"){\n"+bodyFunction+"\n}\n";
	}
}
