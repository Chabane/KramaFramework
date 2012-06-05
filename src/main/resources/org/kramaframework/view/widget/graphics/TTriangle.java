package org.kramaframework.view.widget.graphics;

import org.kramaframework.exception.KramaUnknownTriangleDirectionDefinitionException;
import org.kramaframework.view.widget.TWidget;

public class TTriangle extends TDraw{

	private int x;
	private int y;
	
	private int x1;
	private int x2;
	private int x3;
	private int y1;
	private int y2;
	private int y3;
	
	public static final int DIRECTION_LEFT = 0;
	public static final int DIRECTION_RIGHT = 1;
	public static final int DIRECTION_UP = 2;
	public static final int DIRECTION_DOWN = 3;
	
	private int width;
	private String linecap;
	private String color;
	
	private String path;
	private String drawRaphael;
	private int index;
	
	/**
	 * Simple triangle
	 * @param x
	 * @param y
	 * @param width
	 * @param linecap
	 * @param color
	 * @param drawRaphael
	 * @param index
	 * @throws KramaUnknownTriangleDirectionDefinitionException 
	 */
	public TTriangle(int x, int y, int direction, int width, String linecap,
			String color, String drawRaphael, int index) throws KramaUnknownTriangleDirectionDefinitionException {
		
		this.x = x;
		this.y = y;
		
		switch(direction){
		case(DIRECTION_LEFT):
			this.path = " \"M"+x+", "+y+", L"+(x)+","+(y-12)+","+(x+12)+","+(y-6)+"z \"";
			this.x1 = x;
			this.x2 = x;
			this.x3 = x+12;
			this.y1 = y;
			this.y2 = y-12;
			this.y3 = y-6;
			break;
		case(DIRECTION_RIGHT):
			this.path = " \"M"+x+", "+(y-6)+", L"+(x+12)+","+(y-12)+","+(x+12)+","+y+"z \" ";
			this.x1 = x;
			this.x2 = x+12;
			this.x3 = x+12;
			this.y1 = y-6;
			this.y2 = y-12;
			this.y3 = y;
			break;
		default: throw new KramaUnknownTriangleDirectionDefinitionException("Unknown triangle direction");
		}
	
		this.width = width;
		this.linecap = linecap;
		this.color = color;
		this.drawRaphael = drawRaphael;
		this.index = index;
	}
	
	/**
	 * Custom triangle
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @param width
	 * @param linecap
	 * @param color
	 * @param drawRaphael
	 * @param index
	 */
	public TTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int width, String linecap,
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
		this.path = "\" M"+x1+", "+y1+", L"+x2+","+y2+","+x3+","+y3+"z \" ";
	}
	
	public String getJavascript(){
		return drawRaphael+".path(path"+index+")" +
				 ".attr({\"stroke-width\":"+width+", " +
				 		"\"stroke-linecap\":\""+linecap+"\", " +
				 		  "stroke:\""+color+"\"})";
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
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