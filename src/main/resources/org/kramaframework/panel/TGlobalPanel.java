package org.kramaframework.panel;

import java.io.IOException;
import java.util.Vector;

import org.kramaframework.exception.KramaIllegalAddTagException;
import org.kramaframework.exception.KramaUnknowJavascriptDependancyException;
import org.kramaframework.js.JsDpendency;
import org.kramaframework.servlet.TAjaxServlet;
import org.kramaframework.view.TViewTag;
import org.kramaframework.view.widget.TGraphics;
import org.kramaframework.view.widget.TWidget;

/**
 * TGlobalPanel is a principal panel of Krama
 * @author chabane
 * @version 1.0
 */
public class TGlobalPanel extends TPanel {

	// Visibility of view bean
	private boolean visible = false;
	// CSS name of widget
	public static String name;
	
	/**
	 * Constructor
	 * @param name
	 * @param id
	 */
	public TGlobalPanel(String name, String id) {
		super(name, id, null);
		// Rename css name class
		this.name = "krama-"+name;
	}
	
	/**
	 * Add a child into GlobalPanel
	 * @param widget
	 */
	public void add(TWidget widget) {
		
		try {
			// Set a parent name of child  
			widget.setParentName(getName());
			// Add html of child
			html.addTag(widget.getHtml());
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
	
	/**
	 * Show or hide a view bean
	 * @param visible
	 */
	public void setVisible(boolean visible) {

		this.visible = visible;

		if (visible) {
			try {
				// Write a html in jsp
				write(getHtml());
			} catch (IOException e) {
				e.printStackTrace();
			}
			// Get a all css of view bean
			TViewTag.css = getCss();
			// Get a js css of view bean
			TViewTag.jsCode = getJavascript();
			// all dependencies of view bean
			TViewTag.dependencies = getJavascriptDependencies();
		}
	}
	
	/**
	 * Get ajax data
	 * @return html of ajax view bean
	 */
	public String getAjaxData() {
		return getJsAjax()+getHtml()+getCssAjax();
	}

	/**
	 * Get css of ajax data
	 * @return css of ajax data
	 */
	public String getCssAjax(){
		return "<style type=\"text/css\">\n" +
				 		getCss() +
			    "</style>";
	}
	
	/**
	 * Get js of ajax data
	 * @return js of ajax data
	 */
	public String getJsAjax(){
		
		String script = "";
		String jsPath;
		
		// Get a path of javasript repository
		if(TAjaxServlet.getJsPath() == null){
			jsPath = "js/";
		}else
			jsPath = TAjaxServlet.getJsPath();
		
		// Add a dependencies in ajax data
		for(Object dependancy : getJavascriptDependencies()){
			JsDpendency jsDependency = TAjaxServlet.dependency.getDependencyByName((String)dependancy);
			 try {
					if(jsDependency !=null){		
						script += "<script type=\"text/javascript\" " +
								"src=\""+jsPath+jsDependency.getFile()+".js\"></script>";
					}else
						throw new KramaUnknowJavascriptDependancyException(jsDependency+" dependency was not found by Krama");
					
			  } catch (KramaUnknowJavascriptDependancyException e) {
					e.printStackTrace();
			  }
		}
		return script;
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
	
	@Override
	public void paintWidget(TGraphics g) {
	}
}
