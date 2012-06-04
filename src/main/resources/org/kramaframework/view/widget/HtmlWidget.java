package org.kramaframework.view.widget;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.kramaframework.exception.KramaIllegalAddTagException;
import org.kramaframework.exception.KramaUnknownWidgetKindException;



/**
 * This class defined a html of Widget
 * 
 * @author chabane
 * @version 1.0
 */
public class HtmlWidget {

	/**
	 * HTML attributs of Widgeet
	 */
	private String tagName;
	private String tagType;
	private HashMap tagAttributAndValue;
	private String prefixTag;
	private String suffixTag;
	private String attributTag;
	private String bodyTag;

	/**
	 * Enumeration which defined a kind of Widget Simple Tag means a simple HTML
	 * Tag with out body Body Tag means a complexe HTML Tag with a body
	 * 
	 * @author chabane
	 * @version 1.0
	 */


	/**
	 * Constructor
	 * 
	 * @param tagName
	 * @param tagType
	 * @throws KramaUnknownWidgetKindException 
	 */
	public HtmlWidget(String tagName, String tagType) throws KramaUnknownWidgetKindException {

		tagAttributAndValue = new HashMap();
		this.tagName = tagName;
		this.tagType = tagType;

		/**
		 * Assign a correct format for a Widget
		 */
		if(TagType.SIMPLE_TAG.equals(tagType)){
			prefixTag = "<" + tagName + " ";
			attributTag = " ";
			suffixTag = " />";
		}
		else if(TagType.BODY_TAG.equals(tagType)){
			prefixTag = "<" + tagName + " ";
			attributTag = "";
			bodyTag = ">";
			suffixTag = "</" + tagName + ">\n";
		} else
			throw new KramaUnknownWidgetKindException("Unknown tag type "+tagType);
	}

	/**
	 * Add a tag on body of Widget
	 * 
	 * @param tag
	 * @throws IllegalAddTagException 
	 */
	public void addTag(String tag) throws KramaIllegalAddTagException {
		if(TagType.BODY_TAG.equals(tagType))
			bodyTag += tag;
		else
			throw new KramaIllegalAddTagException("");
	}

	/**
	 * Add HTML attribut into HashMap
	 * 
	 * @param name
	 * @param value
	 */
	public void addAttribut(String name, String value) {
		tagAttributAndValue.put(name, value);
	}

	/**
	 * Get HTML attribut from HashMap
	 * 
	 * @param name
	 * @return html attribut
	 */
	public String getAttribut(String name) {
		return "" + tagAttributAndValue.get(name);
	}

	/**
	 * Update HTML attribut from HashMap
	 * 
	 * @param name
	 * @param value
	 */
	public void updateAttribut(String name, String value) {
		tagAttributAndValue.put(name, value);
	}

	/**
	 * Remove HTML attribut of HashMap
	 * 
	 * @param name
	 */
	public void removeAttribut(String name) {
		tagAttributAndValue.remove(name);
	}

	/**
	 * Check if HTML attributs provided on paramater is available
	 * 
	 * @param name
	 * @return boolean if attribut is available
	 */
	public boolean isAttributAvailable(String name) {
		return tagAttributAndValue.containsKey(name);
	}

	/**
	 * Get HTML of this Widget
	 * 
	 * @param name
	 * @return All HTML of Widget
	 */
	public String getHTML() {

	
		for (Object obj : tagAttributAndValue.keySet()) {
			attributTag += obj + "=\""
					+ tagAttributAndValue.get(obj) + "\" ";
		}

		String html = prefixTag + attributTag;
		if (tagType.equals(TagType.BODY_TAG))
			html += bodyTag;
		html += suffixTag;

		return html;
	}
	
	/**
	 * Get a value of body tag
	 * @return Body tag
	 */
	public String getBodyTag(){
		return bodyTag;
	}
}
