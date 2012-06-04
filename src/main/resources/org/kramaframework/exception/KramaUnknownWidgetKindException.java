package org.kramaframework.exception;

/**
 * This exception is generated when developer used wrong kind of widget 
 * for develop a custom widget. 
 * @author chabane
 * @version 1.0
 */
public class KramaUnknownWidgetKindException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param message
	 */
	public KramaUnknownWidgetKindException(String message){
		super(message);
	}
}
