

<%@page import="java.util.ArrayList"%>
<%@page import="control.AdminBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CuentaloWeb</title>
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

            <%-- verificacion de Conexion a BD--%>
            <% if (AdminBD.sentencia == null) {
                    AdminBD.iniciarConexionConBd();
                }%>

            <div id="mid_content">
                <div class="container">
                    <div class="mid_content_info mid_content_space">

                        <DIV ALIGN=center>
                            <%
                                int puntos = Integer.parseInt(request.getParameter("txtPuntos"));
                                String autor = request.getParameter("autorCuen");
                                AdminBD.aumentarPuntajeEn(puntos, autor);
                            %>
                            Tu calificación ha sido recibida.
                            Gracias por participar calificando este cuento.
                        </DIV>
                    </div>
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
                                    <span class='st_facebook_large' displayText='Facebook'span></span>
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

