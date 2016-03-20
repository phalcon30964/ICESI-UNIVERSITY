<%-- 
    Document   : hora
    Created on : 12/05/2015, 08:44:26 AM
    Author     : CL
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>La fecha de hoy es:</h1>
        <%! GregorianCalendar calendario = new GregorianCalendar();%>
        <p> Día:
            <%= Integer.toString(calendario.get(Calendar.DATE))%>,
            Mes:
            <%= Integer.toString(calendario.get(Calendar.MONTH) + 1)%>,
            Año:
            <%= Integer.toString(calendario.get(Calendar.YEAR))%>
        </p>

    </body>
</html>
