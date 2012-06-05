package org.kramaframework.panel;

import java.util.HashMap;

import org.kramaframework.util.TUtil;
import org.kramaframework.view.widget.TGraphics;

/**
 * A horizontal panel
 * @author chabane
 * @version 1.0
 */
public class THorizontalPanel extends TPanel {

	private THorizontalPanel(){}
	
	/**
	 * Constructor
	 * @param name
	 * @param id
	 */
	public THorizontalPanel(String name, String id) {
		super(name, id, TUtil.HORIZONTAL_PANEL);
		addCostumCSS();
	}
	
	/**
	 * Add other css
	 */
	public void addCostumCSS() {
		HashMap costumCss = new HashMap();
		costumCss.put("clear", "both");
		css.addCostumCSS(css.getParentName(), getName(), panelName, costumCss);
	}

	@Override
	public void paintWidget(TGraphics g) {
	}
}
