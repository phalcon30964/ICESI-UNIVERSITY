<%-- 
    Document   : newjsp
    Created on : 7/05/2015, 03:55:23 PM
    Author     : CL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login result</title>
</head>
<body>
	<%
		String user = request.getParameter("user");
		String pass = request.getParameter("password");
		if ("dd".equals(user) && "dd".equals(pass)) {
			out.println("login ok");
		} else {
			out.println("invalid login");
		}
	%>
</body>
</html>
