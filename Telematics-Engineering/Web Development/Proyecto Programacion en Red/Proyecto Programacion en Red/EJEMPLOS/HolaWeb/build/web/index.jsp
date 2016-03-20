<%-- 
    Document   : index
    Created on : 12/05/2015, 08:13:11 AM
    Author     : CL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulario de consulta</h1>
        <b>Por favor escriba su nombre:</b>
        <form name="Formulario de solicitud nombre" action="/HolaWeb/ServletSaluda">
            <input type="text" name="nombre" value="" /> 
            <input type="submit" value="Ok" />
            <a href=" /HolaWeb/hora.jsp ">Consultando la fecha</a>
        </form>
    </body>
</html>
