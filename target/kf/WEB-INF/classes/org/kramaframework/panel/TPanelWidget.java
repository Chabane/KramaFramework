package org.kramaframework.panel;

import org.kramaframework.view.widget.TWidget;

/**
 * Used by specific widget to create a custom panel
 * @author chabane
 * @version 1.0
 */
public abstract class TPanelWidget extends TWidget{

	/**
	 * Constructor
	 * @param tagName
	 * @param tagType
	 * @param cssName
	 */
	protected TPanelWidget(String tagName, String tagType, String cssName) {
		super(tagName, tagType, cssName);
	}
	
	public TPanelWidget(){}
}
