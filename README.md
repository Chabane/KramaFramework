KramaFramework
==============

Krama is a Java EE / Ajax open source framework. The aim was to provide widgets (similar to Swing, GWT, Wicket, Vaadin) for representing the view in Java, instead of doing it on a simple JSP page.
Krama can manage itself generating HTML / CSS and JavaScript corresponding to the view developed in Java and intelligently, within it, only generates what has been coded. This framework uses several JavaScript libraries such as jQuery, Prototype, Raphael-js.

```java
public class Dessiner extends TVerticalPanel{

	public Dessiner(String name, String id) {
		super(name, id);
		setWidth(300);
		setHeight(200);
	}	
	
	public void paintWidget(TGraphics g){
		 TCircle circle = g.drawCircle(30, 30, 3, "yellow", "black");
		 TLine line = g.drawLine(44, 173, 180, 173, "2", "round", "#058105");
	}
}
```
