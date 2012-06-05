package org.kramaframework.js;

import java.util.Vector;

import org.jdom.Document;
import org.kramaframework.xml.TXmlLoader;


/**
 * This method saved all javascript dependencies
 * @author chabane
 * @version 1.0
 */
public class JsDependencies extends Vector{

	
	/**
	 * static instance of JsDependencies
	 */
	private static JsDependencies instance = null;
	
	/**
	 * Constructor
	 */
	private JsDependencies(){
	}
	
	/**
	 * Singleton instance
	 * @param document 
	 * @param kramaInstance 
	 * @return JsDependencies Singleton
	 */
	public static JsDependencies getInstance(TXmlLoader kramaInstance, Document document) {

		if (instance == null) {

			synchronized (JsDependencies.class) {
				if (instance == null) {
					// Save all javascript name file from krama-config.xml
					instance = kramaInstance.parsingkramaJavascriptDependencies(document, new JsDependencies());
				}
			}
		}
		return instance;
	}
	
	/**
	 * Add a new dependency, added by developer
	 * @param dependency
	 */
	public void addDependency(JsDpendency dependency){
		add(dependency);
	}
	
	/**
	 * Get a existing dependency
	 * @param name
	 * @return an instance of dependency
	 */
	public JsDpendency getDependencyByName(String name){
		for(Object dependency : this)
			// return dependency if exist
			if(((JsDpendency) dependency).getName().equals(name))
				return ((JsDpendency) dependency);
		return null;
	}
}
