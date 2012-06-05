package org.kramaframework.view.widget;

import java.util.HashMap;

import org.kramaframework.exception.KramaIllegalAddTagException;
import org.kramaframework.listener.TMouseListener;

/**
 * It's equivalent to span in HTML. It's allows to add a text
 * @author chabane
 * @version 1.0
 */
public class TSimpleText extends TWidget {

	/**
	 * Constructor
	 * @param name
	 * @param id
	 */
	public TSimpleText(String name, String id) {
		super("span", TagType.BODY_TAG, "krama-" + name);
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

	public void setColor(String color) {
		css.addAttribut("color", color);
	}

	public String getColor() {
		return css.getAttribut("color");
	}

	/**
	 * Set text of span
	 * @param text
	 */
	public void setText(String text) {
		try {
			html.addTag(text);
		} catch (KramaIllegalAddTagException e) {
			e.printStackTrace();
		}
	}

	public String getText() {
		return html.getBodyTag();
	}

	public void setSize(String size) {
		css.addAttribut("font-size", size);
	}

	public void setSize(int size) {
		css.addAttribut("font-size", size + "px");
	}

	public String getSize() {
		return css.getAttribut("font-size");
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
		 * Add javascript dependencies 
		 */
		for (Object dependancy : tMouseListener.getJsDependencies())
			js.addDependency((String) dependancy);

		/*
		 * Add a javascript specific of widget
		 */
		js.addJavascript(tMouseListener.getJavascript());
	}
}
