package org.kramaframework.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.jdom.Document;
import org.kramaframework.exception.KramaConfigurationBuildFailedException;
import org.kramaframework.exception.KramaConfigurationFileNotFoundException;
import org.kramaframework.exception.KramaConfigurationIsNotDefinedException;
import org.kramaframework.exception.KramaReflectionIllegalArgumentException;
import org.kramaframework.exception.KramaReflectionIllegalClassException;
import org.kramaframework.exception.KramaReflectionIllegalMethodSignatureException;
import org.kramaframework.exception.KramaViewClassNotFoundException;
import org.kramaframework.introspection.TMethod;
import org.kramaframework.introspection.TReflection;
import org.kramaframework.js.JsDependencies;
import org.kramaframework.util.TUtil;
import org.kramaframework.view.TAjaxView;
import org.kramaframework.view.interfaces.IAjax;
import org.kramaframework.xml.TXmlLoader;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * It's a servlet which manage all ajax request and return a result
 * @author chabane
 * @version 1.0
 */
public class TAjaxServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Path of krama-config.xml
	private static String configKrama;
	// Path of krama.js
	private static String jsPath;
	
	// Javascript dependencies
	public static JsDependencies dependency;

	@Override
	public void init(ServletConfig config) throws ServletException {

		if(TUtil.loader == null && TUtil.document == null)
			TUtil.load(config);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		// name of view bean
		String view = request.getParameter("vbName");
		// name of class
		String _class = request.getParameter("cName");
		// name of method
		String _method = request.getParameter("mName");
		// number of parameters
		int paramNumber = Integer.parseInt(request.getParameter("nParam")
				.toString());
		
		Object[] paramValue = null;

		// If method content parameters
		if (paramNumber > 0) {
			
			paramValue = new Object[paramNumber];
			
			// Convert in a correct type
			for (int i = 0; i < paramNumber; i++) {
				String param = request.getParameter("param" + ((int) i + 1))
						.toString();
				if (param.equals("null"))
					paramValue[i] = null;
				else if (param.equals("true") || param.equals("false"))
					paramValue[i] = (Object) Boolean.parseBoolean(param);
				else if (param.matches("\\p{Digit}+")) {
					paramValue[i] = (Object) Integer.parseInt(param);
				} else
					paramValue[i] = (Object) param;
			}
		 }
		try {
				// Recuperate all dependencies declared in krama-config
				dependency = JsDependencies.getInstance(TUtil.loader, TUtil.document);
				// Recuperate a TMethod object which defined an ajax method
				TMethod tMethod = TUtil.loader.parsingkramaConfigMethod(TUtil.document, _class,
						_method, paramValue);
				// With reflection, we recuperate a value returned by method
				Object result = TReflection.getResult(tMethod, paramValue);
				// Recuperate a name of view bean class
				view = TUtil.loader.parsingkramaConfigViewName(TUtil.document, view);
				// Recuperate an instance of view bean
				IAjax lib = (TAjaxView) TReflection.getView(view);
				// Get path of js
				jsPath = TUtil.loader.parsingkramaConfigName(TUtil.document, "js");
				// Execute onAjax method of ajax view bean and recuperate ajax data
				String html = lib.onAjax(result);
				// write in flux
				PrintWriter out = response.getWriter();
				out.println(html);
			} catch (KramaViewClassNotFoundException e) {
				e.printStackTrace();
			} catch (KramaReflectionIllegalClassException e) {
				e.printStackTrace();
			} catch (KramaReflectionIllegalMethodSignatureException e) {
				e.printStackTrace();
			} catch (KramaReflectionIllegalArgumentException e) {
				e.printStackTrace();
			}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
	
	/*
	 * Getters
	 */
	public static String getConfigXML() {
		return configKrama;
	}

	public static String getJsPath() {
		return jsPath;
	}
}
