package org.kramaframework.listener;

import java.util.HashMap;
import java.util.Vector;

import org.kramaframework.event.MouseEvent;
import org.kramaframework.event.TEvent;
import org.kramaframework.event.TEventListener;
import org.kramaframework.event.TMouseEvent;
import org.kramaframework.exception.KramaEventUnknownEventException;
import org.kramaframework.js.Function;

public abstract class TMouseListener extends TListener implements TEventListener {

	// List of function class
	private Vector mfunctionList = new Vector();
	// List of event
	private Vector mEvtList = new Vector();
	// List of javascript dependencies
	private Vector allJsDependencies = new Vector();
	// List of javascript function
	private Vector allJsFunctions = new Vector();
	// A javascript source code
	private String javascript;
	
	/**
	 * Method called by view bean
	 * event
	 */
	@Override
	public void onEvent(TEvent event) throws IllegalArgumentException {
	}
	/**
	 * This function used to create a map of event 
	 * @param id
	 * @param index
	 * @return a building of bonction
	 */
	public String getFunction(String id, int index) {
		return "javascript:"+mfunctionList.get(index)+", '" + id + "');";
	}

	/**
	 * Used to check if event provides it's correct
	 * @param event
	 * @return
	 * @throws KramaEventUnknownEventException
	 */
	public String getEventName(String event) throws KramaEventUnknownEventException {
		
		// Test if event it's recognized
		if(MouseEvent.ONCLICK.equals(event) || 
		   MouseEvent.ONDOUBLECLICK.equals(event) || 
		   MouseEvent.ONCHANGE.equals(event) || 
		   MouseEvent.ONFOCUS.equals(event) || 
		   MouseEvent.ONBLUR.equals(event) || 
		   MouseEvent.ONMOUSEDOWN.equals(event) || 
		   MouseEvent.ONMOUSEOUT.equals(event) || 
		   MouseEvent.ONMOUSEUP.equals(event) || 
		   MouseEvent.ONMOVE.equals(event) 
		   )
			return event;
		else 
			throw new KramaEventUnknownEventException(event+ " was not found by Krama");
	}

	/**
	 * Add a building of function call. It's added in value of HTML event 
	 * @param functionCall
	 */
	@Override
	public void addFunctionCall(String function) {
		mfunctionList.add(function);
	}

	/**
	 * Add a event to widget
	 * @param event
	 */
	@Override
	public void addEvent(String event) {
		mEvtList.add(event);
	}
	
	/**
	 * Get all events used by widget
	 * 
	 * @param id
	 * @return a list of events
	 */
	public HashMap getAllEvents(String id){
		
		// Get an instance of hashmap, we saved it all events to add in html tag
		HashMap allEvents = new HashMap();
		// Get an instance of mouse event
		TMouseEvent mEvt = new TMouseEvent(this);
		// Call event 
		onEvent(mEvt);
		
		try {
			// Put all events in hashMap
			for (int event = 0; event < mEvtList.size(); event++) {
				String evt = (String) mEvtList.get(event);
				allEvents.put(getEventName(evt), getFunction(id, event));
			}
			mEvtList.clear();
			mfunctionList.clear();
			
		} catch (KramaEventUnknownEventException e) {
			e.printStackTrace();
		}
		return allEvents;
	}

	/**
	 * Add a javascript dependency used by Widgets
	 * @param dependancy
	 */
	@Override
	public void addJsDependency(String dependancy){
		allJsDependencies.add(dependancy);
	}
	
	/**
	 * Get all javascript dependancies used by Widgets
	 * @return list of dependencies
	 */
	public Vector getJsDependencies(){
		return allJsDependencies;
	}
	
	/**
	 * Add a javascript function
	 * @param function
	 */
	@Override
	public void addJsFunction(Function function){
		allJsFunctions.add(function);
	}
	
	/**
	 * Add source code of javascript
	 * @param javascript source code
	 */
	public void setJavascript(String javascript){
		this.javascript = javascript;
	}
	
	/**
	 * Get javascript source code 
	 * @return javascript source code
	 */
	public String getJavascript(){
		String sourceCode = javascript;
		
		for(Object code : allJsFunctions)
			sourceCode += ((Function)code).buildFunction();
		
		return sourceCode;
	}
}
