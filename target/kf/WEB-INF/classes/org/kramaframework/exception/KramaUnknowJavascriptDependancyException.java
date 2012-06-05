package org.kramaframework.exception;

/**
 * This exception is generated when developer used wrong javascript dependencies
 * @author chabane
 * @version 1.0
 */
public class KramaUnknowJavascriptDependancyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param message
	 */
	public KramaUnknowJavascriptDependancyException(String message) {
		super(message);
	}
}
