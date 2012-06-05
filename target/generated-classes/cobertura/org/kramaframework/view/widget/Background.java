package org.kramaframework.view.widget;

/**
 * Defined a css background
 * @author chabane
 * @version 1.0
 */
public class Background {

	private String url;
	private String position;
	private String repetition;
	private String color;
	private String attachment;

	/**
	 * Constructor
	 */
	public Background() {
	}

	/*
	 * Getters and setters
	 */
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRepetition() {
		return repetition;
	}

	public void setRepetition(String repetition) {
		this.repetition = repetition;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	/**
	 * Get a css of background in string format
	 * @return String
	 */
	public String getBackground() {
		
		if (color == null && position == null && repetition == null
				&& url == null && attachment == null)
			return "";
		if (color == null && position == null && repetition == null
				&& url != null && attachment == null)
			return "background-image:url(" + url + ");";
		else if (color == null && position == null && repetition != null
				&& url == null & attachment == null)
			return "background-repeat:" + repetition + ";";
		else if (color == null && position != null && repetition == null
				&& url == null & attachment == null)
			return "background-position:" + position + ";";
		else if (color != null && position == null && repetition == null
				&& url == null & attachment == null)
			return "background-color:" + color + ";";
		else if (color == null && position == null && repetition == null
				&& url == null & attachment != null)
			return "background-attachment:" + attachment + ";";
		else
			return "background:"
					+ (((url != null) ? " "+url+" " : "")
					+ ((repetition != null) ? " "+repetition+" " : "")
					+ ((position != null) ? " "+position+" " : "") 
					+ ((url != null) ? " "+color+" " : "")
					+ ((attachment != null) ? " "+attachment+" " : "")+";");
	}
}
