package org.kramaframework.view;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.kramaframework.util.TUtil;

/**
 * Fill a css tag
 * @author chabane
 * @version 1.0
 */
public class TCssTag extends BodyTagSupport {

	// Value of css page
	private String cssPage;
	
	/**
	 * Recuperate path of css
	 * @throws IOException
	 */
	private void config() throws IOException {
		TUtil.load(pageContext.getServletConfig());
		// Get path of css
		cssPage = TUtil.loader.parsingkramaConfigName(TUtil.document, "css")+"krama.css";
	}
	
	/**
	 * Method of TagSupport, allows write html in page
	 */
	public int doStartTag() throws JspException {

		try {
			config();
			pageContext.getOut().println("<link rel=\"stylesheet\" type=\"text/css\" href=\""+cssPage+"\" />");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Tag.SKIP_BODY;
	}

	public int doAfterBody() throws JspException {

		return Tag.SKIP_BODY;
	}
}
