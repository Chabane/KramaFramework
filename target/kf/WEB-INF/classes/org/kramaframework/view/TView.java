package org.kramaframework.view;

import java.io.IOException;

import org.kramaframework.view.interfaces.ILib;

/**
 * Abstract class of simple view bean
 * @author chabane
 * @version 1.0
 */
public abstract class TView implements ILib {

	/**
	 * Method used for build view bean
	 */
	public abstract void start(Object obj) throws IOException;
}
