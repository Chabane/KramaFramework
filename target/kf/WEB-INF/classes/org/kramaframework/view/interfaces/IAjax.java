package org.kramaframework.view.interfaces;

import java.io.IOException;

/**
 * Implemented by ajax view bean
 * @author chabane
 * @version 1.0
 */
public interface IAjax {

	/**
	 * Method used for ajax call
	 */
	public String onAjax(Object obj) throws IOException;
}
