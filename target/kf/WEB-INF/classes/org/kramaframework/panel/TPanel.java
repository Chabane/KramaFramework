package org.kramaframework.panel;

import java.util.HashMap;
import java.util.Vector;

import org.kramaframework.exception.KramaIllegalAddTagException;
import org.kramaframework.listener.TMouseListener;
import org.kramaframework.util.TUtil;
import org.kramaframework.view.widget.Background;
import org.kramaframework.view.widget.TGraphics;
import org.kramaframework.view.widget.TWidget;
import org.kramaframework.view.widget.TagType;

/**
 * Used by any panel with same properties of class
 * @author chabane
 * @version 1.0
 */
public abstract class TPanel extends TPanelWidget {

	public TPanel(){}

	// name of panel
	protected String panelName;
	// background of panel
	protected Background background;
	private boolean isDrawing = false;
	
	/**
	 * Constructor
	 * @param name
	 * @param id
	 * @param panelName
	 */
	protected TPanel(String name, String id, String panelName) {
		super("div", TagType.BODY_TAG, "krama-" + name);
		html.addAttribut("id", id);
		html.addAttribut("class", "krama-" + name);
		css.addAttribut("clear", "both");
		this.panelName = panelName;
	}
	
	/**
	 * Add a child
	 * @param widget
	 */
	public void add(TWidget widget) {
		
		try {
			// Set a parent name of child  
			widget.setParentName(css.getParentName(), getName(), panelName);
			// Add html of child
			html.addTag(TUtil.encapsulate(widget.getHtml(), panelName));
			// Add css of child
			css.addOthersCSS(widget.getCss());
			// Add a javascript source code of child
			js.addJavascript(widget.getJavascript());
			// Add javascript dependencies of child
			addNecessaryDependency(widget.getJavascriptDependencies());
		} catch (KramaIllegalAddTagException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Css attributs
	 */
	public String getName() {
		return html.getAttribut("class");
	}

	public String getId() {
		return html.getAttribut("id");
	}

	public void setMargin(String margin) {
		css.addAttribut("margin", margin);
	}
	
	public void setPadding(String padding) {
		css.addAttribut("padding", padding);
	}

	public void setHeight(String height) {
		css.addAttribut("height", height);
		paint();
	}

	public void setWidth(String width) {
		css.addAttribut("width", width);
		paint();
	}
	
	public void setMargin(int margin) {
		css.addAttribut("margin", margin+"px");
	}
	
	public void setPadding(int padding) {
		css.addAttribut("padding", padding+"px");
	}

	public void setHeight(int height) {
		css.addAttribut("height", height+"px");
		paint();
	}
	
	public void setWidth(int width) {
		css.addAttribut("width", width+"px");
		paint();
	}

	public void setBackground(Background background) {
		this.background = background;
		css.addCSS(background.getBackground());
	}

	public void setStyle(String style) {
		css.addCSS(style);
	}

	public String getMargin() {
		return css.getAttribut("margin");
	}

	public String getPadding() {
		return css.getAttribut("padding");
	}

	public String getHeight() {
		return css.getAttribut("height");
	}

	public String getWidth() {
		return css.getAttribut("width");
	}

	public Background getBackground() {
		return background;
	}

	public String getStyle() {
		return css.getMoreCss();
	}

	public void setSize(String width, String height) {
		css.addAttribut("width", width);
		css.addAttribut("height", height);
		paint();
	}
	
	public void setSize(int width, int height) {
		css.addAttribut("width", width+"px");
		css.addAttribut("height", height+"px");
		paint();
	}
	
	/**
	 * add a listener for widget and if exist ajax call, a data will be 
	 * add in widget with id's
	 * @param tMouseListener
	 * @param id 
	 */
	public void addTMouseListener(TMouseListener tMouseListener, String id) {

		/*
		 * Obtains a hashmap which defined all events called
		 */
		HashMap allEvents = tMouseListener.getAllEvents(id);

		/*
		 * Add event on html tag
		 */
		for (Object event : allEvents.keySet())
			html.addAttribut(event.toString(), allEvents.get(event).toString());

		/*
		 * Add javascript dependencies 
		 */
		addNecessaryDependency(tMouseListener.getJsDependencies());

		/*
		 * Add a javascript specific of widget
		 */
		js.addJavascript(tMouseListener.getJavascript());
	}
	
	/**
	 * This method allows to define a necessary dependency which should be added to dependencies 
	 * of view
	 * @param dependencies
	 */
	private void addNecessaryDependency(Vector dependencies){
		
		for (Object dependancy : dependencies)
			if(!js.getDependencies().contains(dependancy))
				js.getDependencies().add((String) dependancy);
	}
	
	/**
	 * 
	 * @param g
	 */
	public void paintWidget(TGraphics g){}
	
	private void paint(){
		  
		if( !isDrawing && 
			!css.getAttribut("width").equals("null") && 
			!css.getAttribut("height").equals("null")){
			
			String[] width = css.getAttribut("width").split("px");
			String[] height = css.getAttribut("height").split("px");
			// Paint if any draw exist
			TGraphics g = new TGraphics(html.getAttribut("id"), width[0], height[0]); 
			paintWidget(g);
			
			String jsCode = g.getJavascript();
			if(jsCode != null){
			   js.addDependency("Raphael");
			   // Add a javascript source code of child
			   js.addJavascript(jsCode); 
			}
			isDrawing = true;
		}
	}
}