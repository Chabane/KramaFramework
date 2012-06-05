package org.kramaframework.view.widget;

import java.util.Vector;

import org.kramaframework.exception.KramaUnknownTriangleDirectionDefinitionException;
import org.kramaframework.view.widget.graphics.TCircle;
import org.kramaframework.view.widget.graphics.TDraw;
import org.kramaframework.view.widget.graphics.TLine;
import org.kramaframework.view.widget.graphics.TRectangle;
import org.kramaframework.view.widget.graphics.TString;
import org.kramaframework.view.widget.graphics.TTriangle;

/**
 * 
 * @author chabane
 * @version 1.0
 */
public class TGraphics {

	private String javascript;
	private String drawRaphael;
	private String drawingRaphael;
	private Vector elements;
	private String width;
	private String height;
	private String idRaphael;
	
	private TGraphics(){}
	/**
	 * 
	 * @param idRaphael
	 * @param width
	 * @param height
	 */
	public TGraphics(String idRaphael, String width, String height){
		
		this.idRaphael = idRaphael;
		drawRaphael = "draw_"+idRaphael;
		drawingRaphael = "drawing_"+idRaphael;
		elements = new Vector();
		this.width = width;
		this.height = height;
	}
	
	public Vector getElements() {
		return elements;
	}
	/**
	 * 
	 * @param text
	 * @param x
	 * @param y
	 * @return 
	 */
	public TString drawString(String text, int x, int y){
		TDraw tString = new TString(text, x, y, drawRaphael, elements.size());
		elements.add(tString);
		return (TString) tString;
	}
	
	/**
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param width
	 * @param linecap
	 * @param color
	 * @return
	 */
	public TLine drawLine(int x1, int y1, int x2, int y2, int width, String linecap, String color){
		
		TDraw tLine = new TLine(x1, y1, x2, y2, width, linecap, color, drawRaphael, elements.size());
		elements.add(tLine);
		return (TLine) tLine;
	}	 	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param radius
	 * @param backgroundColor
	 * @param borderColor
	 * @return
	 */
	public TRectangle drawRect(int x, int y, int width, int height, int radius, String backgroundColor, String borderColor){
		
		TDraw rect = new TRectangle(x, y, width, height, radius, backgroundColor, borderColor, drawRaphael, elements.size());
		elements.add(rect);
		return (TRectangle) rect;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param radius
	 * @param backgroundColor
	 * @param borderColor
	 * @return
	 */
	public TCircle drawCircle(int x, int y, int radius, String backgroundColor, String borderColor){
		
		 TDraw circle = new TCircle(x, y, radius, backgroundColor, borderColor, drawRaphael, elements.size());
		 elements.add(circle);
		 return (TCircle) circle;
	}
	
	/**
	 * Draw a custom triangle 
	 * @param x1 coord X of first point of triangle
	 * @param y1 coord Y of first point of triangle
	 * @param x2 coord X of second point of triangle
	 * @param y2 coord Y of second point of triangle
	 * @param x3 coord X of third point of triangle
	 * @param y3 coord Y of third point of triangle
	 * @param width
	 * @param linecap
	 * @param color
	 * @return
	 */
	public TTriangle drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int width, String linecap, String color){
		
		TDraw tTriangle = new TTriangle(x1, y1, x2, y2, x3, y3, width, linecap, color, drawRaphael, elements.size());
		elements.add(tTriangle);
		return (TTriangle) tTriangle;
	}	

	/**
	 * 
	 * @return
	 */
	public String getJavascript() {
		
		if(elements.size() > 0){
			
			javascript  = "window.onload = function () {\n";
			javascript += "var "+drawRaphael+" = Raphael(\""+idRaphael+"\", "+width+", "+height+");\n";
			
			javascript += "var ";
			for(int i = 0; i < elements.size(); i++){
				if(((TDraw) elements.elementAt(i)) instanceof TLine){
					javascript += "path"+((int)i)+" = "+((TLine) elements.elementAt(i)).getPath()+",\n";
				}
			}
			
			for(int i = 0; i < elements.size(); i++){
				if(((TDraw) elements.elementAt(i)) instanceof TTriangle){
					javascript += "path"+((int)i)+" = "+((TTriangle) elements.elementAt(i)).getPath()+",\n";
				}
			}
			
			javascript += ""+drawingRaphael+" = draw_"+idRaphael+".set(\n";
			for(int i = 0; i < elements.size(); i++){
			javascript += ((TDraw) elements.elementAt(i)).getJavascript();
				if(i != elements.size() - 1){
				   javascript +=", \n";
				}
			}
			javascript += "\n);\n";
			javascript += "}\n";
			return javascript;
		}else{
			return null;
		}
	}
	public String getDrawRaphael() {
		return drawRaphael;
	}
	public String getDrawingRaphael() {
		return drawingRaphael;
	}
	public String getWidth() {
		return width;
	}
	public String getHeight() {
		return height;
	}
	public String getIdRaphael() {
		return idRaphael;
	}
}