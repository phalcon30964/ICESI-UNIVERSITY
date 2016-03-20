
<%@page import="modelo.Tarea"%>
<%    
if(session!=null && AdministradorBD.getConnection()){
    //nombre del usuario actual en sesion
    String sx = (String)session.getAttribute("Usuario");
    
    
    if(sx!=null){
        
        String nuevaCategoria = request.getParameter("nuevaCategoriaNombre");
        
        String nombreTareaNueva = request.getParameter("nombreTareaNueva");
        String fechaNuevaTarea = request.getParameter("fechaTareaNueva");
        String horaNuevaTarea = request.getParameter("horaTareaNueva");
        String descripcionTareaNueva = request.getParameter("descripcionTareaNueva");
        String tagsTareaNueva = request.getParameter("tagsTareaNueva");
        String ubicacionTareaN = request.getParameter("ubicacionTareaNueva");
        String categoria = request.getParameter("categoria");
        String prioridad = request.getParameter("prioridad");
 
        if(nuevaCategoria!=null){
            if(AdministradorBD.crearCategoria(nuevaCategoria, sx)){

%>
                        <script> alert('Categoria creada') </script> 
<%
		}else{
%>
                        <script> alert('Probablemente la categoria ya existe') </script> 
<%
		}
        }
        
        
        if( nombreTareaNueva !=null && fechaNuevaTarea!=null && horaNuevaTarea!=null && descripcionTareaNueva!=null && tagsTareaNueva!=null && ubicacionTareaN!=null && categoria!=null && prioridad!=null ){
        String fechaLimiteNuevaTarea = request.getParameter("fechaTareaNueva")+" "+request.getParameter("horaTareaNueva");
        String [] ubicacionTareaNueva = ubicacionTareaN.split(",");
        int prio = Integer.parseInt(request.getParameter("prioridad"));
        double ubiLat = Double.parseDouble(ubicacionTareaNueva[0]);
        double ubiLong = Double.parseDouble(ubicacionTareaNueva[1]);
        
            if(AdministradorBD.crearTarea(nombreTareaNueva, descripcionTareaNueva, fechaLimiteNuevaTarea, prio, ubiLat, ubiLong, tagsTareaNueva, categoria, sx)){

%>
                        <script> alert('Tarea creada') </script> 
<%
		}else{
%>
                        <script> alert('Probablemente la Tarea ya existe') </script> 
<%
		}
        }
            
        
        
        //cuando se unde boton crear tarea, 
        
%>
﻿<!DOCTYPE html>
<html>
<head>
<title>Easy Task</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets2/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<%@page import="java.util.ArrayList"%>
<%@page import="control.AdministradorBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
</head>

<body>

<!-- Header -->
<div id="header"> 
  
  <!-- Logo -->
  <div id="logo"> <span class="image avatar48"><img src="images2/logo.jpg" alt="" /></span>
    <h1 id="title"><%=sx%></h1>
  </div>
  
  <!-- Nav -->
  <nav id="nav">
    <ul>
      <li><a href="#top" id="top-link" class="skel-layers-ignoreHref"><span class="icon fa-home">Inicio</span></a></li>
      <li><a href="#about" id="about-link" class="skel-layers-ignoreHref"><span class="icon fa-user">Crear Tarea</span></a></li>
      <li><a href="#tareas" id="portfolio-link" class="skel-layers-ignoreHref"><span class="icon fa-th">Lista de Tareas</span></a></li>
      <li><a href="#contact" id="contact-link" class="skel-layers-ignoreHref"><span class="icon fa-envelope">Tarea en Detalle</span></a></li>
    </ul>
  </nav>
  <h1 id="logo">&nbsp;</h1>
  <nav id="nav"> 
    
    <!-- Aqui para cerrar sesion -->
    <ul>
        <li><a href="cerrarSesion.jsp" class="button special">Cerrar Sesion</a></li>
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
        <h2 class="alt">Hola! Bienvenido a <strong>Easy Task</strong>.</h2>
        <p>Esta cuenta es completamente gratis y usted tiene habilitadas <br>
          todas las funciones de la aplicación</p>
      </header>
      <footer> <a href="#about" class="button scrolly">Agregar Tarea</a> </footer>
    </div>
  </section>
  
  <!-- Seccion para agregar una tarea -->
  <section id="about" class="three">
  <div class="container">
    <header>
      <h2><B>Nueva Tarea<B></h2>
    </header>
    <a href="#" class="image featured"><img src="images2/task2.jpg" alt="" /></a>
<!--    ---------------------------------------------------------------------------->
 <form method="post" action="casa.jsp">
    <div class="row">
            <div class="6u 12u$(mobile)">
              <input type="text" name="nombreTareaNueva" placeholder="Nombre Tarea" REQUIRED title = "Debe ingregar primero un nombre para la tarea"/>
            </div>
            <div class="6u$ 12u$(mobile)">
              <input type="date" name="fechaTareaNueva" REQUIRED title = "Debe ingregar una fecha"/>
              <input type="time" name="horaTareaNueva" REQUIRED title = "Debe ingregar una hora"/>
            </div>
    </div>
    <div class="row">
            <div class="6u 12u$(mobile)">
              <input type="text" name="descripcionTareaNueva" placeholder="Descripción" REQUIRED title = "Debe ingregar primero una descripcion para la tarea"/>
            </div>
            <div class="6u$ 12u$(mobile)">
              <input type="text" name="tagsTareaNueva" placeholder="Tags" REQUIRED title="Escriba los tags seguidos de un coma (,)"/>
            </div>
    </div>
    <div class="row">
            <div class="30u$ 12u$(mobile)">
                 <input name="checkUbicacion" type="button" id="checkUbicacion" value="Check" onclick="codeAddress()"/>
            </div>
            <div class="6u$ 12u$(mobile)">
               <input id="address" type="text" name="ubicacionTareaNueva" placeholder="Ubicacion" title="Direccion o lugar del evento"/>
            </div>
    </div>
    <div class="row">
        <div>
                <div class="12u$">
                      <select name="prioridad" REQUIRED>
                        <OPTION value="">Prioridad</OPTION>
                        <option disabled>- - -</option>
                        <OPTION VALUE="0">Sin prioridad</OPTION>
                        <OPTION VALUE="1">Prioridad 1</OPTION>
                        <OPTION VALUE="2">Prioridad 2</OPTION>
                        <OPTION VALUE="3">Prioridad 3</OPTION>
                      </select>  
                </div>
         </div>
        <div>
                <div class=""12u$"">
                    <select name="categoria" REQUIRED>
                      <option value="">Categoría</option>
                      <option disabled>- - -</option>
                        <% 
                        ArrayList<String> lista = AdministradorBD.getCategoriasDisponibles(sx);
                        for(int i = 0 ; i<lista.size();i++){
                        String categ = lista.get(i);
                        %>     
                             <OPTION VALUE="<%=categ%>"><%=categ%></OPTION>
                        <%
                          }
                        %> 
                    </select>
                </div>
        </div>>
    </div>             
    <div class="row">
                <div class="12u$">
                        <input name="crearTarea" type="submit" id="crearTarea" value="Crear Tarea"/>
                </div>  
    </div>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true"></script> 
      <script>
    var geocoder;
    var map;
    function initialize() {
      geocoder = new google.maps.Geocoder();
      var latlng = new google.maps.LatLng(3.341812, -76.530879);
      var mapOptions = {
        zoom: 15,
        center: latlng
      }
      map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
    }
     function codeAddress() {
      var address = document.getElementById('address').value;
      geocoder.geocode( { 'address': address}, 
      function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
          map.setCenter(results[0].geometry.location);
          var marker = new google.maps.Marker({
              map: map,
              position: results[0].geometry.location
              document.getElementById('ubicacionDeGoogle').value = position;
          });
              alert('Se ha guardado su Ubicación: '+ address +', Las cordenadas son: ' + position +'.');
        } else {
          alert('No se pudo guardar la ubicacion, por favor intente una direccion cercana: ' + status);
        }
      });
    }
            google.maps.event.addDomListener(window, 'load', initialize);
    </script> 
    <input type="hidden" name="ubicacionDeGoogle" id="ubicacionDeGoogle" />   
 </form>
                    <form>

<!--    
       
      <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true"></script> 
      <script>
var geocoder;
var map;
function initialize() {
  geocoder = new google.maps.Geocoder();
  var latlng = new google.maps.LatLng(3.341812, -76.530879);
  var mapOptions = {
    zoom: 15,
    center: latlng
  }
  map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
}

	function codeAddress() {
  var address = document.getElementById('address').value;
  geocoder.geocode( { 'address': address}, 
  function(results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
      map.setCenter(results[0].geometry.location);
      var marker = new google.maps.Marker({
          map: map,
          position: results[0].geometry.location
          document.getElementById('ubicacion').value = position;
      });
	  alert('Se ha guardado su Ubicación: '+ address +', Las cordenadas son: ' + position +'.');
    } else {
      alert('No se pudo guardar la ubicacion, por favor intente una direccion cercana: ' + status);
    }
  });
}
	google.maps.event.addDomListener(window, 'load', initialize);

    </script> 
    </div>
    
    
    </div>>-->
<!--</form>

<form action="casa.jsp" method="POST">
      <script>	  
            function crearCategoria(){
            var newCategory = prompt("Por favor nueva categoria: ");
            document.getElementById('nuevaCategoriaNombre').value=newCategory;
            }
       </script>
      <input type="submit" class="special" value="Nueva Categoria" onClick="crearCategoria()" />
</form>
  
 </div>-->
  
</div>
</form>
</div>
</section>
<section id="tareas" class="two">
  <div class="container">
    <header>
      <h2>Tareas</h2>
    </header>
    
      <div class="row">
        <div class="12u$"> 
          <!--  En este punto se escoje como se va a organizar las tareas  -->
          <form method="post" action="casa.jsp">
          <select name="ordenarPor" >
            <option value="">Ordenar Por :</option>
            <option disabled>- - -</option>
            <OPTION disabled>Prioridad :</OPTION>
            <option value="porPrioridad1">... Prioridad 1</option>
            <option value="porPrioridad2">... Prioridad 2</option>
            <option value="porPrioridad3">... Prioridad 3</option>
            <option value="porPrioridadNull">... Sin Prioridad</option>
            <option value="porPrioridadMasAMenos">... Mayor a menor</option>
            <option disabled>- - -</option>
            
            <!-- Aqui pendiente si se agrega una nueva categoria -->
            <OPTION disabled>Categoría :</OPTION>
            <option value="porTrabajo">... Trabajo</option>
            <option value="porEstudio">... Estudio</option>
            <option value="porPersondal">... Personal</option>
            <option disabled>- - -</option>
            <option disabled>Fecha :</option>
            <OPTION VALUE="porFechaLimite">... Fecha Limite</OPTION>
            <option value="porHoy">... por hoy</option>
            <option value="porAtrasadas">... Atrasadas</option>
          </select>
          <input type="submit" value="Ordenar">
          <input name="Enviar a correo" type="submit"  id="enviarCorreo" value="Enviar Tarea(s) por email" />
          </form>
        </div>
        <div class="12u$">
        <form method="post" action="casa.jsp">
         <select name="tareas" multiple>
    <%
    
    ArrayList<Tarea> listaTareasDefecto = AdministradorBD.getTareasPorFechaLimite(sx);
    
    for(int i = 0; i<listaTareasDefecto.size();i++){
        Tarea homework = listaTareasDefecto.get(i);
        String nombre = homework.getNombre();
        
        String mensaje = homework.toStringSimple();
    %>
    <OPTION VALUE="<%=nombre%>"><%=mensaje%></OPTION>
    <%
    }
    %>
          <input name="editarTarea" type="submit"  id="editarTarea" value="Editar/Detalle Tarea" />
          <input name="eliminar" type="submit" id="eliminar" value="Eliminar Tarea(s)" size="2"/>
          <input name="reportePDF" type="submit"  id="reportePDF" value="Generar Reporte PDF" />
        </select>
        </form>
        </div>
      </div>
  </div>
</section>

<!-- Tarea en detalle, se actualiza esta sesion cuando dan click en el boton con id="editarTarea" -->

<section id="contact" class="four">
  <div class="container">
    <header>
      <h2>Tarea en Detalle</h2>
    </header>
    <form method="post" action="#">
      <div class="row">
        <div class="6u 12u$(mobile)">
          <input type="text" name="nombreTareaEdit" title="Nombre de la tarea" />
        </div>
        <div class="6u$ 12u$(mobile)">
          <input type="text" name="fechaHoraEdit" title="Fecha y hora de la tarea">
        </div>
        <div class="6u 12u$(mobile)">
          <input type="text" name="descripcionEdit" title="Descripción de la tarea"/>
        </div>
        <div class="6u$ 12u$(mobile)">
          <input type="text" name="tagsEdit" title="Tags de la tarea"/>
        </div>
        <div class=""12u$"">
          <select name="prioridad" title="Prioridad de la tarea">
            <OPTION value="">Prioridad</OPTION>
            <option disabled>- - -</option>
            <OPTION VALUE="uno">1</OPTION>
            <OPTION VALUE="dos">2</OPTION>
            <OPTION VALUE="tres">3</OPTION>
          </select>
        </div>
        <div class=""12u$"">
          <select name="categoria">
            <option value="">Categoría</option>
            <option disabled>- - -</option>
            <OPTION VALUE="trabajo">Trabajo</OPTION>
            <OPTION VALUE="personal">Personal</OPTION>
            <OPTION VALUE="estudio">Estudio</OPTION>
          </select>
          
        </div>
        <style>
      #map-canvas {
	  	position:absolute;
		left:1030px;
		top:2750px;
		width: 280px;
        height: 260px;
        padding: 10px
      }
      #panel {
        position: overflow;
        top: 0px;
        left: 40%;
        margin-left: 50px;
        z-index: 5;
        background-color: #fff;
        padding: 9px;
        border: 1px solid #999;
      }
    </style>
        <div id="map-canvas"></div>
        
        <form action="#" method="post">
        <div class="12u$">
          <input name="guardarCambios" type="button" value="Guardar Cambios" />
        </div>
        </form>
      </div>
    </form>
  </div>
</section>
</div>

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
    //No ha iniciado session, se redigije a la pagina de error
    RequestDispatcher rd = request.getRequestDispatcher("errorSesion.html");
    rd.include(request, response);
    }

}else{
    //No ha iniciado session, se redigije a la pagina de error
    RequestDispatcher rd = request.getRequestDispatcher("errorServer");
    rd.include(request, response);
}  
%>


    

