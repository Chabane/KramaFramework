package org.kramaframework.demo;

import java.io.IOException;

import org.kramaframework.panel.TGlobalPanel;
import org.kramaframework.panel.TVerticalPanel;
import org.kramaframework.util.TColor;
import org.kramaframework.view.TView;
import org.kramaframework.view.widget.TLabel;

/**
 * 
 * @author chabane
 *
 */
public class View extends TView {

	public void start(Object obj) throws IOException,	
			IllegalArgumentException {

		TGlobalPanel panel = new TGlobalPanel("mondiv", "global");
		panel.setWidth(400);
		
			TVerticalPanel hPanel = new Dessiner("hPanel", "idHPanel");
			
			TLabel label = new TLabel("label", "bel");
			label.setText("Krama");
			label.setSize(100);
			label.setColor(TColor.CYAN);
			
			TLabel label2 = new TLabel("label3", "bel3");
			label2.setText("Framework");
			label2.setSize(70);
			/*
			label.addTMouseListener(new TMouseListener() {
				@Override
				public void onEvent(TEvent evt) {
	
					((TMouseEvent)evt).show("viewAjax", "operation", "valeur", new ArrayList() {
						{
							add(10);
							add(2);
							add("somme");
						}
					}, MouseEvent.ONCLICK);
				}
				
			}, label.getId());
			*/
			label.drag();	
			label2.drag();	
			hPanel.add(label);
			hPanel.add(label2);
		panel.add(hPanel);
		panel.setVisible(true);
	}
}
