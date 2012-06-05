package org.kramaframework.demo;

import java.io.IOException;

import org.kramaframework.panel.TGlobalPanel;
import org.kramaframework.view.TAjaxView;
import org.kramaframework.view.widget.TLabel;

public class ViewAjax extends TAjaxView {

	public String onAjax(Object obj) throws IOException,
	IllegalArgumentException {
		
		TGlobalPanel panel = new TGlobalPanel("mondiv3", "kramaAjax");
		
			TLabel label = new TLabel("label22", "bel22");
			label.setText("Hello world !!!");
			label.setSize(15);
			
			panel.add(label);
		return panel.getAjaxData();
	}
}
