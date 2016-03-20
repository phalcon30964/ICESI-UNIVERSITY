
<%
    if(session!=null){
    
        session.removeAttribute("Usuario");
        
%>
<!DOCTYPE html>
<html>
<head>
 <link rel="icon" type="image/ico" href="assets3/css/images/favicon.ico"/>

<%@page import="control.AdministradorBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title>Easy Task</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets2/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
</head>
<body>

<!-- Header -->
<div id="header"> 
  
  <!-- Logo -->
  <div id="logo"> <span class="image avatar48"><img src="images2/logo.jpg" alt="" /></span>

  </div>
  
  <!-- Nav -->
  <nav id="nav">
    <ul>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
    </ul>
  </nav>
  <nav id="nav"> 
    
    <!-- Aqui para cerrar sesion -->
    <ul>
      <li></li>
    </ul>
  </nav>
</div>
<div class="bottom"> 
  
  <!-- Social Icons -->
  <ul class="icons">
    <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
    <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
    <li><a href="#" class="icon fa-github"><span class="label">Github</span></a></li>
    <li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
    <li><a href="#" class="icon fa-envelope"><span class="label">Email</span></a></li>
  </ul>
</div>
</div>
<!-- Main -->
<div id="main"> 
  
  <!-- Intro -->
  <section id="top" class="one dark cover">
    <div class="container">
      <header>
        <h2 class="alt"><strong>Sesion cerrada. Te esperamos pronto!</strong></h2>
        <p>&nbsp;</p>
      </header>
      <footer> <a href="index.html" class="button scrolly">Volver</a> </footer>
    </div>
  </section>
  
  <!-- Seccion para agregar una tarea -->
  <section id="about" class="three"></section>

<!-- Tarea en detalle, se actualiza esta sesion cuando dan click en el boton con id="editarTarea" --></div>

<!-- Footer -->
<div id="footer"> 
  
  <!-- Copyright -->
  <ul class="copyright">
    <li>&copy; Easy Task All Rights Reserved.</li>
    <li>Design: By EasyTask <a href="http://www.easytask.com"></a></li>
  </ul>
</div>

<!-- Scripts --> 
<script src="assets/js/jquery.min.js"></script> 
<script src="assets/js/jquery.scrolly.min.js"></script> 
<script src="assets/js/jquery.scrollzer.min.js"></script> 
<script src="assets/js/skel.min.js"></script> 
<script src="assets/js/util.js"></script> 
<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]--> 
<script src="assets/js/main.js"></script>
</body>
</html>
            
<%           

    }else{
            RequestDispatcher rd = request.getRequestDispatcher("errorServer.html");
            rd.forward(request, response);
    }
%>
