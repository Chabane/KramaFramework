<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/krama.tld" prefix="k"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<k:css/>
<k:js/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple Ajax Library</title>
</head>
<body>
	<jsp:useBean id="ajax" scope="session" class="java.lang.Object" />
	<k:view viewbean="viewAjax" object="<%= ajax %>" type="ajax"/>
</body>
</html>