package org.kramaframework.exception;

/**
 * This exception is generated when developer used a wrong information 
 * of class when put a parameter in javascript function
 * @author chabane
 * @version 1.0
 */
public class KramaReflectionIllegalClassException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param message
	 * @param exception
	 */
	public KramaReflectionIllegalClassException(String message, ClassNotFoundException exception) {
		super(message, exception);
	}
}
