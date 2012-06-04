package org.kramaframework.view;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.kramaframework.util.TUtil;

/**
 * Fill a js tag
 * @author chabane
 * @version 1.0
 */
public class TJsTag extends BodyTagSupport {

	// Value of js page
	private String jsPage;
	
	/**
	 * Recuperate path of css
	 * @throws IOException
	 */
	private void config() throws IOException {
		
		if(TUtil.loader == null && TUtil.document == null)
			TUtil.load(pageContext.getServletConfig());
		// Get path of js
		jsPage = TUtil.loader.parsingkramaConfigName(TUtil.document, "js")+"krama.js";
	}
	
	/**
	 * Method of TagSupport, allows write html in page
	 */
	public int doStartTag() throws JspException {

		try {
			config();
			pageContext.getOut().println("<script type=\"text/javascript\" src=\""+jsPage+"\"></script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Tag.SKIP_BODY;
	}

	public int doAfterBody() throws JspException {

		return Tag.SKIP_BODY;
	}
}