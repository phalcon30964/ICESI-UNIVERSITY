<%-- 
    Document   : index
    Created on : 23-oct-2013, 11:52:00
    Author     : jhcp
--%>
<%@page import="control.AdminBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CuentaloWeb-Registro</title>
        <link rel="stylesheet" type="text/css" href="stylesheets/reset.css" />
        <link rel="stylesheet" type="text/css" href="stylesheets/main.css" />
        <script type="text/javascript">var switchTo5x = true;</script>
        <script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
        <script type="text/javascript">stLight.options({publisher: "ur-feaac732-bb42-b64-411d-c7b7e32e3c48", doNotHash: false, doNotCopy: false, hashAddressBar: true});</script>
    </head>
    <body>

        <div id="header">
            <div class="container">
                <div id="main_menu">
                    <ul>
                        <li class="first_list"><a href="index.jsp" class="main_menu_first main_current">Inicio</a></li>
                        <li class="first_list"><a href="sobreNosotros.jsp" class="main_menu_first">Sobre Nosotros</a></li>
                        <li class="first_list"><a href="contacto.jsp" class="main_menu_first">Contacto</a></li>
                    </ul>
                </div> <!-- END #main_menu -->
            </div> <!-- END .container -->
        </div> <!-- END #header -->

        <div id="main_content">
            <div id="slideshow_area">
                <div class="container">
                    <div id="slideshow_container">
                        <ul>
                            <li><img src="images/baner.jpg" alt="banner1" /></li>
                        </ul>
                    </div> <!-- END #slideshow_container -->
                </div> <!-- END .container -->
            </div> <!-- END #slideshow_area -->


            <%-- Primero verificacion de la conexion con la BD, luego atencion a peticion de registro --%>
            <% if (AdminBD.sentencia == null) {
                    AdminBD.iniciarConexionConBd();
                }
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String contrasena = request.getParameter("contrasena");
                String direccion = request.getParameter("direccion");
                String telefono = request.getParameter("telefono");
                String fechaNacimiento = request.getParameter("dia") + "-"
                        + request.getParameter("Mes") + "-"
                        + request.getParameter("Anho");
                String email = request.getParameter("email");

                boolean estaRegistrado = AdminBD.buscarUsuario(email, contrasena, "Lector");
                boolean estaRegistrado1 = AdminBD.buscarUsuario(email, contrasena, "Colaborador");
                boolean estaRegistrado2 = AdminBD.buscarUsuario(email, contrasena, "Administrador");

                if (!estaRegistrado && !estaRegistrado1 && !estaRegistrado2) {
                    boolean quedoRegistrado = AdminBD.registrar("Lector", nombre, apellido, direccion, telefono, fechaNacimiento, email, contrasena);

                    if (quedoRegistrado) {%>
            <div class="mid_content_info mid_content_space">
                <h2 id="fully">Registro</h2>
                <DIV ALIGN=center>
                    <p style="text-align: center;">
                        Registro Exitoso<br>
                        <a href="index.jsp">Volver a inicio</a>
                        <br><br><br>
                    </p>
                </DIV>
            </div>

            <%} else {%>
            <div class="mid_content_info mid_content_space">
                <h2 id="fully">Registro</h2>
                <DIV ALIGN=center>
                    <p style="text-align: center;">
                        Registro no Exitoso<br>
                        Posiblemente el usuario "<%=email%>" ya exista
                        <br>
                        <a href="index.jsp">Volver a inicio</a>
                        <br><br><br>
                    </p>
                </DIV>
            </div>
            <%}
                }%>


            <div id="footer">
                <div class="container">
                    <div id="footer_about" class="footer_info">
                        <h4>Quienes Somos</h4>
                        <p>Cuentalo es una plataforma digital para la creación e intercambio de experiencias, en la
                            modalidad de cuentos y relatos, como un recurso para el fortalecimiento de la historia popular
                        </p>
                    </div> <!-- END #footer_about -->

                    <div id="footer_explore" class="footer_info">

                        <h4>Explora</h4>
                        <ul>
                            <li><a href="index.jsp">Inicio</a></li>
                            <li><a href="sobreNosotros.jsp">Sobre Nosotros</a></li>
                            <li><a href="contacto.jsp">Contacto</a></li>
                        </ul>
                    </div> <!-- END #footer_explore -->

                    <div id="footer_connect" class="footer_info">
                        <h4>Comparte</h4>
                        <ul>
                            <span class='st_facebook_large' displayText='Facebook'</span>
                            <span class='st_googleplus_large' displayText='Google +'></span>
                            <span class='st_twitter_large' displayText='Tweet'></span>
                            <span class='st_sharethis_large' displayText='ShareThis'></span>
                            <span class='st_linkedin_large' displayText='LinkedIn'></span>
                            <span class='st_email_large' displayText='Email'></span>
                            <span class='st_blogger_large' displayText='Blogger'></span>
                            <span class='st_google_large' displayText='Google'></span>
                        </ul>
                    </div> <!-- END #footer_about -->
                </div> <!-- END .container -->
            </div> <!-- END #footer -->

    </body>
</html>
