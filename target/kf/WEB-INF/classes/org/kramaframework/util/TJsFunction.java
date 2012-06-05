package org.kramaframework.util;

public class TJsFunction {

	/*
	 * Avoid redundancy javascript source code
	 */
	public static boolean drag = false;
	public static boolean show_data = false;
	
	/**
	 * Allows to drag any Widget of Krama Framework
	 * @return source code of drag fonction
	 */
	public static String drag(){
		
     if(!drag){
		drag = true;
			return "function dragWidget(id) { \n"
				+ "Drag.init(document.getElementById(id));  \n"
				+ "} \n";
		}
		else return "";
	}
	
	/**
	 * This method allows to call Ajax request and to fill a idDiv with an
	 * object returned by Ajax Servlet
	 * 
	 * @return a fonction which allows to load data in html tag
	 */
	public static String showData() {
		
	 if(!show_data){
		show_data = true;
		return "function showData(vbName, cName, mName, paramsTab, idDiv) { \n" +

		"var url = 'result.aj?';" +
				"url +='vbName='+ vbName;\n"+
				"url += '&cName=' + cName;\n"
				+ "   url += '&mName=' + mName;\n"

				+ "  if (paramsTab.length > 0) {\n"
				+ "url += '&nParam=' + paramsTab.length;\n"

				+ "	for ( var i = 0; i < paramsTab.length; i++) {\n"
				+ "		url += '&param' + (i+1) + '=' + paramsTab[i];" + "	}\n"
				+ "} else {" + "	url += '&nParam=' + 0;" + "}\n"
				+ "new Ajax.Request(url, {\n" + "	method : 'get',\n"
				+ "	onSuccess : function(xhr) {\n"
				+ "$(idDiv).innerHTML = xhr.responseText; \n" + "},\n"
				+ "	onException : function(xhr, e) {\n"
				+ " alert(e); \n" + "}\n"
				+ "	});\n"
				+ "}\n\n";
	 }else 
		 return "";
	}
}
