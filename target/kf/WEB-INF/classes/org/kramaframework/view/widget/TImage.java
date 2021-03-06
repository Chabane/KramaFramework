package org.kramaframework.view.widget;

import java.util.HashMap;

import org.kramaframework.listener.TMouseListener;

/**
 * It's equivalent to src in HTML. It's allows to add a picture
 * @author chabane
 * @version 1.0
 */
public class TImage extends TWidget {

	/**
	 * Constructor
	 * @param name
	 * @param id
	 */
	public TImage(String name, String id) {
		super("img", TagType.SIMPLE_TAG, "krama-" + name);
		html.addAttribut("id", id);
		html.addAttribut("class", "krama-" + name);
	}
	
	/*
	 * Css and html attributs
	 */
	public String getName() {
		return html.getAttribut("class");
	}

	public String getId() {
		return html.getAttribut("id");
	}
	
	public void setSrc(String src) {
		html.addAttribut("src", src);
	}

	public String getSrc() {
		return html.getAttribut("src");
	}
	
	public void setTitle(String title) {
		html.addAttribut("title", title);
	}

	public String getTitle() {
		return html.getAttribut("title");
	}
	
	public String getStyle() {
		return css.getMoreCss();
	}
	
	public void setStyle(String style) {
		css.addCSS(style);
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
		 * Add javascript dependancies 
		 */
		for (Object dependancy : tMouseListener.getJsDependencies())
			js.addDependency((String) dependancy);

		/*
		 * Add a javascript specific of widget
		 */
		js.addJavascript(tMouseListener.getJavascript());
	}
}
