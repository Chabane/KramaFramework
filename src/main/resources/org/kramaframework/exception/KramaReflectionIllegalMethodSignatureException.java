package org.kramaframework.exception;

/**
 * This exception is generated when developer used a wrong information 
 * of method when put a parameter in javascript function
 * @author chabane
 * @version 1.0
 */
public class KramaReflectionIllegalMethodSignatureException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param message
	 * @param exception
	 */
	public KramaReflectionIllegalMethodSignatureException(String message, NoSuchMethodException exception) {
		super(message, exception);
	}
}
