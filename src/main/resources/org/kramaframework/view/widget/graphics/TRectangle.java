package org.kramaframework.view.widget.graphics;

import org.kramaframework.view.widget.TWidget;

/**
 * 
 * @author chabane
 *
 */
public class TRectangle extends TDraw{

	private int x;
	private int y;
	private int width;
	private int height;
	private int radius;
	private String backgroundColor;
	private String borderColor;

	private String drawRaphael;
	private int index;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param radius
	 * @param backgroundColor
	 * @param borderColor
	 * @param drawRaphael
	 */
	public TRectangle(int x, int y, int width, int height, int radius,
			String backgroundColor, String borderColor, String drawRaphael, int index) {
		this.x = x; 
		this.y = x; 
		this.width = width; 
		this.height = height;
		this.radius = radius;
		this.backgroundColor = backgroundColor;  
		this.borderColor = borderColor;
		this.drawRaphael = drawRaphael;
		this.index = index;
	}

	public String getJavascript(){
		return drawRaphael+".rect("+x+","+y+","+width+","+height+","+radius+")"+
                ".attr({fill: \""+backgroundColor+"\", stroke: \""+borderColor+"\"})";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
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
}
