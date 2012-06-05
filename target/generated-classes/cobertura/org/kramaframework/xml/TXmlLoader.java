package org.kramaframework.xml;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import org.kramaframework.exception.KramaConfigurationBuildFailedException;
import org.kramaframework.exception.KramaConfigurationFileNotFoundException;
import org.kramaframework.exception.KramaConfigurationIsNotDefinedException;
import org.kramaframework.introspection.TMethod;
import org.kramaframework.js.JsDependencies;
import org.kramaframework.js.JsDpendency;
import org.kramaframework.util.TUtil;

/**
 * Manage krama config xml file
 * @author chabane
 * @version 1.0
 */
public class TXmlLoader {

	// Instance of class
	private static TXmlLoader instance = null;
	// Instance of document
	private static Document documentInstance = null;

	/**
	 * Singleton instance
	 * @return TXMLLoader
	 */
	public static TXmlLoader getInstance() {

		if (instance == null) {

			synchronized (TXmlLoader.class) {
				if (instance == null) {
					instance = new TXmlLoader();
				}
			}
		}
		return instance;
	}

	/**
	 * Obtains a SaxBuilder Document
	 * 
	 * @param configkrama
	 * @return Document
	 * @throws KramaConfigurationFileNotFoundException 
	 * @throws KramaConfigurationIsNotDefinedException 
	 * @throws KramaConfigurationBuildFailedException 
	 */
	public Document open(String configkrama) throws KramaConfigurationFileNotFoundException, KramaConfigurationIsNotDefinedException, KramaConfigurationBuildFailedException {

		// Checking a krama-config file DTD
		SAXBuilder sxb = new SAXBuilder(true);
		File file = null;
		if(configkrama != null){
			try {
				if(documentInstance == null){
					synchronized (Document.class) {
						if (documentInstance == null) {
							file = new File(configkrama);
							documentInstance = sxb.build(file);
						}
					}
				}
			} catch (JDOMException e) {
				throw new KramaConfigurationBuildFailedException("Krama cannot build Krama-Config.xml, please respect a DTD", e);
			} catch (IOException e) {
				throw new KramaConfigurationFileNotFoundException("Krama cannot found Krama-Config.xml", e);
			} 
		}else{
			throw new KramaConfigurationIsNotDefinedException("Krama-Config.xml is not defined in web.xml");
		}
		return documentInstance;
	}

	/**
	 * This method allows to check if our informations provided on Ajax call are
	 * correct
	 * 
	 * @param document
	 * @param nClass
	 * @param nMethod
	 * @param nParam
	 * @return boolean 
	 */
	public static boolean checkAjaxInformation(Document document,
			String vbName, String nClass, String nMethod, List nParam) {
		
	if(document != null){
		boolean viewBeanFound = false;
		Element racine = document.getRootElement();
		
		Element krama_Views = racine.getChild("views");
		List krama_ViewList = krama_Views.getChildren("view");
		if (krama_ViewList != null) {
			for (int i = 0; i < krama_ViewList.size(); i++) {
				Element krama_view = ((Element) krama_ViewList.get(i));
				if (krama_view.getAttributeValue("name").equals(vbName)) {
					viewBeanFound = true;
					break;
				}
			}
		}
		
	 if(viewBeanFound){
		 
		Element krama_ajax_call = racine.getChild("ajax-call");
		List krama_MethodList = krama_ajax_call.getChildren("class");
		
		for (int i = 0; i < krama_MethodList.size(); i++) {
			
			Element krama_class = ((Element) krama_MethodList.get(i));
			if (krama_class.getAttributeValue("name").equals(nClass)) {
				Element krama_method = krama_class.getChild("method");
				if (krama_method.getAttributeValue("name").equals(nMethod)) {
					List krama_paramList = krama_method
							.getChildren("param");
					int size = 0;
					if (krama_paramList != null) {
						size = krama_paramList.size();
					}
					if (nParam.size() == size) {

						for (int j = 0; j < nParam.size(); j++) {
							if (!TUtil.isSameKind(((Element) krama_paramList
									.get(j)).getAttributeValue("type"), nParam
									.get(j)))
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		 }
		} else {
			return false;
		}
		return true;
	}
		return false;
	}

	/**
	 * This method return a kind of class and his method with parameter's
	 * 
	 * @param document
	 * @param nClass
	 * @param nMethod
	 * @param nParam
	 * @return TMethod
	 */
	public static TMethod parsingkramaConfigMethod(Document document,
			String nClass, String nMethod, Object[] nParam) {
		
	TMethod tMethod = new TMethod();
	if(document != null){
			
		Element racine = document.getRootElement();
		
		Element krama_ajax_call = racine.getChild("ajax-call");
		List krama_MethodList = krama_ajax_call.getChildren("class");

		for (int i = 0; i < krama_MethodList.size(); i++) {

			Element krama_class = ((Element) krama_MethodList.get(i));

			if (krama_class.getAttributeValue("name").equals(nClass)) {
				Element krama_method = krama_class.getChild("method");
				if (krama_method != null
						&& krama_method.getAttributeValue("name").equals(
								nMethod)) {
					List krama_paramList = krama_method
							.getChildren("param");

					int size = 0;
					if (krama_paramList != null) {
						size = krama_paramList.size();
					}

					tMethod.set_class(krama_class.getAttributeValue("class"));
					tMethod.set_method(krama_method.getAttributeValue("method"));
					if (nParam != null && nParam.length == size) {

						List<String> params = new ArrayList<String>(
								nParam.length);
						for (int j = 0; j < nParam.length; j++) {

							params.add(((Element) krama_paramList.get(j))
									.getAttributeValue("type"));
						}
						tMethod.set_params(params);
					} else {
						break;
					}
				}
			}
		}
		return tMethod;
	}
		return null;
	}

	/**
	 * Obtains a value of CSS/JS file
	 * 
	 * @param document
	 * @return String
	 */
	public String parsingkramaConfigName(Document document, String baliseName) {
		
		if(document != null){
			Element racine = document.getRootElement();
			Element child = racine.getChild(baliseName);
			return child.getAttributeValue("location");
		}
		return null;
	}

	/**
	 * This method allows to get a value of JSP page
	 * 
	 * @param document
	 * @param view
	 * @return String
	 */
	public String parsingkramaConfigViewName(Document document, String view) {
		
	 if(document != null){
		String value = null;
		Element racine = document.getRootElement();
		Element krama_Views = racine.getChild("views");
		List krama_ViewList = krama_Views.getChildren("view");
		if (krama_ViewList != null) {
			for (int i = 0; i < krama_ViewList.size(); i++) {
				Element krama_view = ((Element) krama_ViewList.get(i));
				if (krama_view.getAttributeValue("name").equals(view)) {
					value = krama_view.getAttributeValue("class");
					break;
				}
			}
		}
		return value;
	  }
		return null;
	}

	/**
	 * Obtains all definitions of javascript dependencies
	 * @param document
	 * @param dependencies
	 */
	public JsDependencies parsingkramaJavascriptDependencies(Document document, JsDependencies dependencies) {
		
	if(document != null && dependencies != null){	
		
		Element racine = document.getRootElement();
		Element __dependencies = racine.getChild("js-dependencies");
		List __dependency = __dependencies.getChildren("js-dependency");
		
		if (__dependency != null) {
			for (int i = 0; i < __dependency.size(); i++) {

				Element dependency = ((Element) __dependency.get(i));
				String name = dependency.getChild("name").getText();
				String file = dependency.getChild("file").getText();
				String version = dependency.getChild("version").getText();
				
				dependencies.addDependency(new JsDpendency(name, file, version));
			}
		}
		return dependencies;
	}else
		return null;
	}
}
