package org.kramaframework.exception;

import java.io.IOException;

/**
 * This exception is generated when Krama not found krama-config.xml 
 * on web resource
 * @author chabane
 * @version 1.0
 */
public class KramaConfigurationFileNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param message
	 * @param exception
	 */
	public KramaConfigurationFileNotFoundException(String message, IOException exception) {
		super(message, exception);
	}
}
