package org.kramaframework.exception;

/**
 * This exception is generated when developer used wrong event
 * @author chabane
 * @version 1.0
 */
public class KramaEventUnknownEventException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param message
	 */
	public KramaEventUnknownEventException(String message) {
		super(message);
	}
}
