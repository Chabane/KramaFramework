package org.kramaframework.demo;
import org.apache.struts.action.ActionMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;

public class TestAction extends Action{

	/**
	 * methode execute de l'action struts
	 */
	 public ActionForward execute(
			  ActionMapping mapping,
			  ActionForm form,
			  HttpServletRequest request,
			  HttpServletResponse response) throws Exception{
		
		request.getSession().setAttribute("krama", "afficher");
		return mapping.findForward("success");
	}
}
