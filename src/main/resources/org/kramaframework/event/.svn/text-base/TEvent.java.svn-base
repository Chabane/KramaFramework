package org.kramaframework.event;

import java.util.ArrayList;
import java.util.List;


import org.jdom.Document;
import org.kramaframework.exception.KramaConfigurationBuildFailedException;
import org.kramaframework.exception.KramaConfigurationFileNotFoundException;
import org.kramaframework.exception.KramaConfigurationIsNotDefinedException;
import org.kramaframework.exception.KramaReflectionIllegalArgumentException;
import org.kramaframework.listener.TListener;
import org.kramaframework.servlet.TAjaxServlet;
import org.kramaframework.util.TUtil;
import org.kramaframework.view.TViewTag;
import org.kramaframework.xml.TXmlLoader;

/**
 * TEvent is a super class of all events
 * @author chabane
 * @version 1.0
 */
public abstract class TEvent {

	/**
	 * Instance of listner
	 */
	protected static TListener mlistner;
	
	/**
	 * Constructor
	 */
	protected TEvent(TListener mlistner){
		this.mlistner = mlistner;
	}
	
	/**
	 * Build a function of an HTML event
	 * 
	 * @param _viewBean
	 * @param _class
	 * @param _method
	 * @param _params
	 * @param _functionName
	 * @return a function built
	 * @throws KramaReflectionIllegalArgumentException 
	 */
	protected static String buildFunctionCall(String _viewBean, String _class, String _method,
			List _params, String _functionName) throws KramaReflectionIllegalArgumentException {

		// Store a parameter of the event function 
		String paramFunction = "";
		// Store a parameters of the Java method in a javascript table
		String rawTable = "";
		// Path of configuration XML file
		String configXmlPath;
		
		/*
		 * Recuperate an instance of TXmlLoader to check if informations
		 * provides by Krama View class are correct
		 */	
			// Check if the values of class and method are correct
			if (TUtil.stringOk(_class) && TUtil.stringOk(_method) && TUtil.stringOk(_viewBean)) {

				/*
				 *  If value of parameters are null, it means that a kind 
				 *  of method is without parameters. we create a empty 
				 *  list 
				 */
				if (_params == null)
					_params = new ArrayList();

					
					// Check if ajax informations provides in method of view class are correct 
					if (TUtil.loader.checkAjaxInformation(TUtil.document, _viewBean, _class, _method,
							_params)) {
						
						// Add a name of view bean class content a data of ajax call, on javascript function
						paramFunction = "'" + _viewBean + "'";
						// Add a name of class which defined a method call, on javascript function
						paramFunction += ",'" + _class + "'";
						// Add a name of method
						paramFunction += ",'" + _method + "'";

						// Check if a value of parameters of method are correct, on javascript function
						if (TUtil.listOk(_params)) {
	
							// Add a value of parameter on javascript function, in a table
							for (int r = 0; r < _params.size(); r++) {
								
								// If value of parameter is null, we added a "null" value
								if (_params.get(r) == null
										|| (_params.get(r).toString()).length() == 0)
									_params.set(r, "null");
								if (r == _params.size() - 1)
									rawTable += "'" + _params.get(r) + "'";
								else
									rawTable += "'" + _params.get(r) + "',";
							}
							// Add a value of table
							paramFunction += ", [" + rawTable + "]";
						} else {
							
							// If method without parameters, we added a empty table
							paramFunction += ", []";
						}
					} else
						throw new KramaReflectionIllegalArgumentException("A informations provided on ajax method call, " +
								"not correspend with informations provides on krama configuration!");
			
			} else
				throw new KramaReflectionIllegalArgumentException("A informations provided on ajax method call, are not valid !");
			
		return _functionName+"("+paramFunction;
	}
}
