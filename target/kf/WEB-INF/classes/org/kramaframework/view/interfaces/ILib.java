package org.kramaframework.view.interfaces;

import java.io.IOException;

/**
 * Implemented by view bean
 * @author chabane
 * @version 1.0
 */
public interface ILib {

	/**
	 * Method used for build view bean
	 */
	public void start(Object obj) throws IOException, IllegalArgumentException;
}
