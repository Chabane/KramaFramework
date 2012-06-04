package org.kramaframework.view.widget.graphics;

import org.kramaframework.view.widget.TWidget;

/**
 * 
 * @author chabane
 *
 */
public class TString extends TDraw{

	private String text;
	private int x;
	private int y;
	
	private String drawRaphael;
	private int index;
	
	/**
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @param drawRaphael
	 */
	public TString(String text, int x, int y, String drawRaphael, int index) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.drawRaphael = drawRaphael;
		this.index = index;
	}
	
	public String getJavascript(){
		return drawRaphael+".text("+x+","+y+",\""+text+"\")";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
