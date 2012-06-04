package org.kramaframework.js;

import java.util.Vector;

import org.kramaframework.exception.KramaUnknowJavascriptDependancyException;
import org.kramaframework.view.TViewTag;

/**
 * This class return all javascript used by an instance of krama view
 * @author chabane
 * @version 1.0
 */
public class GenerateJS {

	private String jsCode = "";

	/**
	 * GPL License description
	 * @return a content of copyright
	 */
	private String copyright(){
		
		return "/* Krama JavaScript framework, version 1.0 \n"+
			   " * (c) 2011-2012 REFES Chabane \n"+
			   " * \n"+
			   " * Krama is freely distributable under the terms of an GPL license. \n"+
			   " * For details, see the Krama Framework web site: http://www.kramaframework.org/ \n"+
			   " * \n"+
			   " *--------------------------------------------------------------------------*/  \n";
	}

	/**
	 * Call addJavascript function for add javascript file
	 * @param jsName
	 * @param pos
	 * @return a source code which allows to add a javascript script tag
	 */
	private String addJavascriptFile(String jsName, String pos) {
		return "addJavascript('" + jsName + "','" + pos + "'); \n\n";
	}

	/**
	 * Allows to add a javascript script tag in JSP file
	 * @return source code of import javascript file
	 */
	private String importJSFile() {

		return "function addJavascript(jsname,pos) { \n"
				+ "var th = document.getElementsByTagName(pos)[0];\n"
				+ "var s = document.createElement('script');\n"
				+ "s.setAttribute('type','text/javascript');\n"
				+ "s.setAttribute('src',jsname);\n" + "th.appendChild(s);\n"
				+ "} \n";
	}
	
	/**
	 * Call all function javascript and add a javascript dependencies
	 * @param dependancies 
	 * @return a javascript to add in krama.js
	 * @throws KramaUnknowJavascriptDependancyException 
	 */
	public String getCode(Vector dependancies, String path) throws KramaUnknowJavascriptDependancyException {

	 // If any dependency  
	 if(dependancies.size() > 0){
			
       // Write a copyright
	   jsCode  = copyright();
			
	   // Write a function to allow import javascript file
	   jsCode += importJSFile();
		 
	   // Add all dependencies on web page
	   for(Object dependancy : dependancies){
				
		   if(TViewTag.dependency != null){
	          // Load dependencies used by view bean 
		      JsDpendency jsDependency = TViewTag.dependency.getDependencyByName((String)dependancy);
		      if(jsDependency !=null){		
			     jsCode += addJavascriptFile(path+jsDependency.getFile(), "head");
		      }else
				 throw new KramaUnknowJavascriptDependancyException("Krama was not found dependency "+jsDependency.getName());
		    } 
		}
	 }
		return jsCode;
	}
}
