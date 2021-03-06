package org.kramaframework.panel;

import java.util.HashMap;

import org.kramaframework.util.TUtil;
import org.kramaframework.view.widget.TGraphics;

/**
 * A vertical panel
 * @author chabane
 * @version 1.0
 */
public class TVerticalPanel extends TPanel {

	private TVerticalPanel(){}
	
	/**
	 * Constructor
	 * @param name
	 * @param id
	 */
	public TVerticalPanel(String name, String id) {
		super(name, id, TUtil.VERTICAL_PANEL);
		addCostumCSS();
	}
	
	/**
	 * Add other css
	 */
	public void addCostumCSS() {
		HashMap costumCss = new HashMap();
		costumCss.put("float", "left");
		css.addCostumCSS(css.getParentName(), getName(), panelName, costumCss);
	}

	@Override
	public void paintWidget(TGraphics g) {
	}
}
