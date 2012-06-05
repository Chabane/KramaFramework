package org.kramaframework.view;

import java.io.IOException;

import javax.servlet.jsp.PageContext;

import org.kramaframework.view.interfaces.IAjax;

/**
 * Abstract class of ajax view bean
 * @author chabane
 * @version 1.0
 */
public abstract class TAjaxView implements IAjax{

	/**
	 * Method used for ajax call
	 */
	public abstract String onAjax(Object obj) throws IOException;
}
