package org.kramaframework.panel;

import org.kramaframework.util.TUtil;
import org.kramaframework.view.widget.TGraphics;

/**
 * Used to content a drawing and allows paint widget
 * @author crefes
 * @version 1.0
 */
public abstract class TDrawPanel extends TPanel{

	/**
	 * Constructor
	 * @param name
	 * @param id
	 */
	public TDrawPanel(String name, String id) {
		super(name, id, null);
	}
	
	/**
	 * Drawing with Raphael library
	 */
	public abstract void paintWidget(TGraphics g);
}
