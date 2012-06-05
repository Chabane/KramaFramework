package org.kramaframework.view;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.kramaframework.exception.KramaUnknowJavascriptDependancyException;
import org.kramaframework.exception.KramaViewClassNotFoundException;
import org.kramaframework.introspection.TReflection;
import org.kramaframework.js.GenerateJS;
import org.kramaframework.js.JsDependencies;
import org.kramaframework.util.TUtil;
import org.kramaframework.view.interfaces.ILib;

/**
 * Fill a html tag, this class is a heart of Krama Framework
 * @author chabane
 * @version 1.0
 */
public class TViewTag extends BodyTagSupport implements ILib {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5470383217236484806L;
	// Path of krama-config.xml
	private static String configXML;
	// Name of view from Krama config XML
	private String view;
	// Name of view from JSP
	private String viewbean;
	// Data provides by JSP
	private Object object;
	// Generate JS
	private GenerateJS generateCode = new GenerateJS();
	// Name of repository js file
	private String jsPath;
	// Name of repository css file
	private String cssPath;
	// Javascript dependencies from Krama config XML
	public static JsDependencies dependency;
	// JS source code
	public static String jsCode = "";
	// CSS source code
	public static String css = "";
	// Dependencies from view bean
	public static Vector dependencies;
	// Context of page
	public static TContext context;
	// Path of js repository file
	public static String jsPage;
	// Path of css repository file
	public static String cssPage;
	
	private void config() throws IOException {

		ServletConfig config = pageContext.getServletConfig();
		// Load configuration
		if(TUtil.loader == null && TUtil.document == null)
			TUtil.load(config);
		// Recuperate a css repostiroy name
		cssPath = TUtil.loader.parsingkramaConfigName(TUtil.document, "css");
		// Recuperate a js repostiroy name
		jsPath = TUtil.loader.parsingkramaConfigName(TUtil.document, "js");
		// Recuperate class name of view bean
		view = TUtil.loader.parsingkramaConfigViewName(TUtil.document, viewbean);
		// Recuperate dependencies declared on krama config xml file
		dependency = JsDependencies.getInstance(TUtil.loader, TUtil.document);
		// Recuperate a path of js file
		jsPage = config.getServletContext().getRealPath(jsPath);
		// Recuperate a path of css file
		cssPage = config.getServletContext().getRealPath(cssPath);
	}
	
	/**
	 * Method of BodyTagSupport, allows write html in page
	 */
	public int doStartTag() throws JspException {

		try {
			config();

			// Recuperate an instance of view bean
			ILib lib = (TView) TReflection.getView(view);
			
			// Recuperate context of page
			context = new TContext(pageContext);
			
			// Initialized a javascript dependancies 
			dependencies = new Vector();
			
			// Start building view bean
			lib.start(object);
			
			// Get all javascript code necessary to execute a current view
			try {
				jsCode = generateCode.getCode(dependencies, jsPath)+jsCode;
			} catch (KramaUnknowJavascriptDependancyException e) {
				e.printStackTrace();
			}

			// Write a css code on krama.js
			TUtil.writeInFile(cssPage+"/krama.css", css);
			
			// Write a javascript code on krama.js
			TUtil.writeInFile(jsPage+"/krama.js", jsCode);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KramaViewClassNotFoundException e) {
			e.printStackTrace();
		}
		return Tag.EVAL_BODY_INCLUDE;
	}

	public int doAfterBody() throws JspException {

		return Tag.SKIP_BODY;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public void setViewbean(String viewbean) {
		this.viewbean = viewbean;
	}

	public void start(Object obj) throws IOException {
	}
}
