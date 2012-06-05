package org.kramaframework.event;

/**
 * This class implemented by listener class
 * @author chabane
 * @version 1.0
 */
public interface TEventListener {

	/**
	 * This method allows to call any event
	 * @param event
	 */
	public void onEvent(TEvent event);
}
