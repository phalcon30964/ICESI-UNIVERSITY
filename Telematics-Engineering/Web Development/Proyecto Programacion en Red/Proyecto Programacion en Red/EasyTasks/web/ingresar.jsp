<!DOCTYPE html>
<%@page import="control.AdministradorBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
 <link rel="icon" type="image/ico" href="assets3/css/images/favicon.ico"/>

<title>Task Easy</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
</head>
<body class="index">
<div id="page-wrapper">
<header id="header" class="alt">
  <h1 id="logo">&nbsp;</h1>
  <nav id="nav">
    <ul>
      <li class="current"><a href="index.html">Inicio</a></li>
      <li><a href="registrar.jsp" class="button special">Registrar</a></li>
    </ul>
  </nav>
</header>
<!-- Main -->
<article id="main">

<!-- One -->

<section class="wrapper style3 container special-alt">
  <div class="row 50%">
   <form action="ingresar.jsp" method="POST">
    <div class="8u 12u(narrower)">
      <header> <img src="images/logo.png" width="426" height="242">
        <div class="row 50%">
          <div class="6u 12u(mobile)">
            <input name="usuario" type="text" class="fa-tree" placeholder="Usuario" />
          </div>
          <div class="6u 12u(mobile)">
            <input type="password" name="contrasena" placeholder="Contraseña" />
          </div>
        </div>
      </header>
      <footer>
      <div class="row 50%">
        <div class="12u"></div>
      </div>
      <div class="row">
        <div class="12u(mobile)">
          <ul>
          <input type="submit" class="special" value="Ingresar" />
          </ul>  
            <ul>
            
            </ul>
        </div>
      </div>  
      </form>
      <form action="contrasenaRestablecida.jsp" method="POST">
            <script>
			function restablecer(){
			var nombreUsuarioRestablecer =	prompt("Porfavor Ingrese su nombre: ");
                        document.getElementById('elemento').value=nombreUsuarioRestablecer;
			}
            </script>
            <input type="hidden" name="elemento" id="elemento" />
            <input type="submit" class="special" value="Restablecer Contraseña" onClick="restablecer()" />
      </form> 
      
    </div>
   
        
    <div class="6u 12u(narrower) important(narrower)">
      <ul class="featured-icons">
        <li><span class="icon fa-clock-o"><span class="label">Feature 1</span></span></li>
        <li><span class="icon fa-volume-up"><span class="label">Feature 2</span></span></li>
        <li><span class="icon fa-laptop"><span class="label">Feature 3</span></span></li>
        <li><span class="icon fa-inbox"><span class="label">Feature 4</span></span></li>
        <li><span class="icon fa-lock"><span class="label">Feature 5</span></span></li>
        <li><span class="icon fa-cog"><span class="label">Feature 6</span></span></li>
      </ul>
    </div>
 
  </div>
</section>

<%
            if(AdministradorBD.getConnection()){
            
            String usuario = request.getParameter("usuario");
            String contrasena = request.getParameter("contrasena");
            
                if(usuario != null && contrasena!= null){
        
                        if(AdministradorBD.iniciarSesion(usuario, contrasena)){ 
                            //valido sesion
                            HttpSession s = request.getSession(true);
                            s.setAttribute("Usuario", usuario);
                            //redireciono al cuerpo
                            RequestDispatcher rd = request.getRequestDispatcher("casa.jsp");
                            rd.forward(request, response);
                            
                        }else{  
%>
            
                        <script> alert('Usuario y contraseña no coinciden') </script> 
            
<%                      }
            
                }
                
            }else{
            
%>
            
             <script> alert('Error de conexion con el servidor') </script> 
             
<%
            }
  
%>

</body>
</html>