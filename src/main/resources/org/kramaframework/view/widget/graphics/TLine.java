package org.kramaframework.view.widget.graphics;

import org.kramaframework.view.widget.TWidget;

/**
 * 
 * @author chabane
 *
 */
public class TLine extends TDraw{

	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private String width;
	private String linecap;
	private String color;
	
	private String path;
	private String drawRaphael;
	private int index;
	
	/**
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param width
	 * @param linecap
	 * @param color
	 * @param drawRaphael
	 */
	public TLine(int x1, int y1, int x2, int y2, String width, String linecap,
			String color, String drawRaphael, int index) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.width = width;
		this.linecap = linecap;
		this.color = color;
		this.drawRaphael = drawRaphael;
		this.index = index;
		this.path = "[[\"M\","+x1+", "+y1+"],[\"L\","+x2+", "+y2+"]]";
	}
	
	public String getJavascript(){
		return drawRaphael+".path(path"+index+")" +
				 ".attr({\"stroke-width\":"+width+", " +
				 		"\"stroke-linecap\":\""+linecap+"\", " +
				 		  "stroke:\""+color+"\"})";
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getLinecap() {
		return linecap;
	}

	public void setLinecap(String linecap) {
		this.linecap = linecap;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDrawRaphael() {
		return drawRaphael;
	}

	public void setDrawRaphael(String drawRaphael) {
		this.drawRaphael = drawRaphael;
	}

	@Override
	public String drag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addWidgetDepedency(TWidget widget) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addGraphicsDepedency(TDraw drawWidget) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getIndex() {
		return index;
	}

	public String getPath() {
		return path;
	}
}
