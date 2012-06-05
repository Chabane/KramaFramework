package org.kramaframework.view.widget.graphics;

import org.kramaframework.view.widget.TWidget;

public abstract class TDraw {

	public abstract String getJavascript();
	public abstract String drag();
	public abstract String addWidgetDepedency(TWidget widget);
	public abstract String addGraphicsDepedency(TDraw drawWidget);
}
