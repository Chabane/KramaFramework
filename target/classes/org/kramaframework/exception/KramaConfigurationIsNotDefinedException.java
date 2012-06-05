package org.kramaframework.exception;

/**
 * This exception is generated when Krama Framework not defined in web.xml file
 * @author chabane
 * @version 1.0
 */
public class KramaConfigurationIsNotDefinedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param message
	 */
	public KramaConfigurationIsNotDefinedException(String message) {
		super(message);
	}
}
