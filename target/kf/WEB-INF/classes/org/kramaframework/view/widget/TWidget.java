package org.kramaframework.view.widget;

import java.util.Vector;


import org.kramaframework.exception.KramaUnknownWidgetKindException;
import org.kramaframework.js.JsWidget;
import org.kramaframework.util.TJsFunction;
import org.kramaframework.view.T;


/**
 * This abstract class used by Panel to draw a widget
 * @author chabane
 * @version 1.0
 */
public abstract class TWidget extends T{

	// defined html of widget
	protected HtmlWidget html;
	// defined css of widget
	protected CssWidget css;
	// defined javascript of widget
	protected JsWidget js;

	public TWidget(){
		
	}
	
	/**
	 * Constructor
	 * @param tagName
	 * @param tagType
	 * @param cssName
	 */
	public TWidget(String tagName, String tagType, String cssName){
		try {
			html = new HtmlWidget(tagName, tagType);
		} catch (KramaUnknownWidgetKindException e) {
			e.printStackTrace();
		}
		css = new CssWidget(cssName);
		js = new JsWidget();
	}
	/**
	 * Used by Panel to draw a html on jsp
	 * @return All html of Widget
	 */
	public String getHtml(){
		return html.getHTML();
	}
	
	/**
	 * Used by Panel to draw a css on krama.css
	 * @return All css of Widget
	 */
	public String getCss(){
		return css.getCSS();
	}
	
	/**
	 * Used by GlobalPanel to rename css class of widget
	 * @param parentName
	 */
	public void setParentName(String parentName){
		css.setParentName(parentName);
	}
	
	/**
	 * Used by any Panel to rename css class of widget
	 * @param parentName
	 */
	public void setParentName(String globalCssName, String parentName, String panelName){
		css.setParentName(globalCssName, parentName, panelName);
	}
	
	/**
	 * Used by Panel to rename css class of widget
	 * @param parentName
	 */
	public String getParentName(){
		return css.getParentName();
	}
	
	/**
	 * Get javascript of Widget
	 * @param jsCode 
	 * @return a javascript to generate
	 */
	public String getJavascript(String jsCode){
		jsCode += js.getJavascript();
		return jsCode;
	}
	
	/**
	 * Get all dependencies of widget
	 * @param dependancies 
	 * @return all dependencies used by the widget
	 */
	public Vector getJavascriptDependencies(Vector dependancies){
		dependancies.addAll(js.getDependencies());
		return dependancies;
	}
	
	/**
	 * Get javascript of Widget
	 * @return a javascript to generate
	 */
	public String getJavascript(){
		return js.getJavascript();
	}
	
	/**
	 * Get all dependencies of widget
	 * @return all dependencies used by the widget
	 */
	public Vector getJavascriptDependencies(){
		return js.getDependencies();
	}
	
	/**
	 * Drag any widget
	 */
	public void drag() {

		js.addDependency("Dom-Drag");
		js.addJavascript(TJsFunction.drag());
		html.addAttribut("onmousedown", "javascript:dragWidget(this.id);");
		css.addCSS("position:relative; cursor: move;");
	}
}
