package org.kramaframework.view;

import javax.servlet.jsp.PageContext;

/**
 * Defined a context of application
 * @author chabane
 * @version 1.0
 */
public class TContext {

	// Context of page
	private PageContext context;
	
	/**
	 * Constructor
	 * @param context
	 */
	public TContext(PageContext context){
		this.context = context;
	}

	/**
	 * Get a context of page
	 * @return a context
	 */
	public PageContext getContext() {
		return context;
	}
}
