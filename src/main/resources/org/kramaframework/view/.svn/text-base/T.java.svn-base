package org.kramaframework.view;

import java.io.IOException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Write html in jsp
 * @author chabane
 * @version 1.0
 */
public abstract class T extends TagSupport {

	public T(){
		
	}
	
	/**
	 * Method of TagSupport, allows write html in page
	 */
	public int doStartTag() {

		try {
			if(TViewTag.context != null){
				TViewTag.context.getContext().getOut().println(html);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

	// html of widget
	private String html;

	/**
	 * called by GlobalPanel to write html
	 * @param html
	 * @throws IOException
	 */
	public void write(String html) throws IOException {
		this.html = html;
		doStartTag();
	}
}
