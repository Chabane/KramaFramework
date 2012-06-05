package org.kramaframework.exception;

/**
 * This exception is generated when developer used a wrong information 
 * of view bean when put it in javascript function
 * @author chabane
 * @version 1.0
 */
public class KramaViewClassNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param message
	 */
	public KramaViewClassNotFoundException(String message){
		super(message);
	}
}
