package org.kramaframework.demo;

import org.kramaframework.panel.TVerticalPanel;
import org.kramaframework.view.widget.TGraphics;
import org.kramaframework.view.widget.TSimpleText;
import org.kramaframework.view.widget.graphics.TCircle;
import org.kramaframework.view.widget.graphics.TLine;

public class Dessiner extends TVerticalPanel{

	public Dessiner(String name, String id) {
		super(name, id);
		setWidth(300);
		setHeight(200);
	}	
	
	public void paintWidget(TGraphics g){
		 TCircle circle = g.drawCircle(30, 30, 3, "yellow", "black");
		 TLine line = g.drawLine(44, 173, 180, 173, "2", "round", "#058105");
		 // circle.drag();
		 // TSimpleText text = new TSimpleText("myTextName", "myTextId");
		 // circle.addWidgetDepedency(text);
	}
}