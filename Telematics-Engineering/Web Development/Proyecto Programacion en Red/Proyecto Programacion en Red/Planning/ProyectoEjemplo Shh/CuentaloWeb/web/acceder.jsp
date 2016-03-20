
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

            <%-- Verificacion de usuario --%>

            <%

                HttpSession sesion = request.getSession();

                String nombreUsuario = "";
                if (request.getParameter("nombre") != null) {
                    nombreUsuario = request.getParameter("nombre");
                }
                String contrasena = "";
                if (request.getParameter("contrasena") != null) {
                    contrasena = request.getParameter("contrasena");
                }
                String tipoUsuario = "";
                if (request.getParameter("tipoUsuario") != null) {
                    tipoUsuario = request.getParameter("tipoUsuario");
                } else {
                    tipoUsuario = (String) sesion.getAttribute("tipoUsuario");
                }
                boolean estaRegistrado = AdminBD.buscarUsuario(nombreUsuario, contrasena, tipoUsuario);

                if (estaRegistrado || tipoUsuario.equalsIgnoreCase("Anonimo")) {
                    sesion.setAttribute("tipoUsuario", tipoUsuario);
            %>

            <p style="text-align: center;">
                Como usuario
                <%= (tipoUsuario == null) ? ((String) sesion.getAttribute("tipoUsuario")) : tipoUsuario%>
                puedes realizar:</p>

            <div id="mid_content">
                <div class="container">
                    <div class="mid_content_info mid_content_space">
                        <h2 id="abierto">Concursos Abiertos</h2>
                        <DIV ALIGN=center>
                            <form action="verCuentosParticipantes.jsp" method="POST" style="text-align: center;"> 
                                <select name="campoAbiertos" size="<%AdminBD.contarConcursos();%>" style="text-align: center;">
                                    <%ArrayList<String> concursosAbiertos = AdminBD.darConcursosAbiertos();
                                        String elConcurso = "";
                                        for (int i = 0; i < concursosAbiertos.size(); i++) {
                                            elConcurso = concursosAbiertos.get(i);
                                    %>
                                    <option value="<%=elConcurso%>"><%=elConcurso%></option>
                                    <%}%>
                                </select>
                                <br>
                                <input name="btnVerCuentosParticipantes" type="submit" value="Ver cuentos participantes" />
                            </form>
                        </DIV>
                    </div>

                    <div class="mid_content_info mid_content_space">
                        <h2 id="cerrado">Concursos Cerrados</h2>
                        <form action="verCuentosGanadores.jsp" method="POST" style="text-align: center;">
                            <p style="text-align: center; margin-left: 40px;">
                                <select name="campoCerrados" size="<%AdminBD.contarConcursos();%>" style="text-align: center;">

                                    <%ArrayList<String> concursosCerrados = AdminBD.darConcursosCerrados();
                                        String elConcursoCerrado = "";
                                        for (int i = 0; i < concursosCerrados.size(); i++) {
                                            elConcursoCerrado = concursosCerrados.get(i);

                                    %>
                                    <option value="<%=elConcursoCerrado%>"><%=elConcursoCerrado%></option>
                                    <%}%>
                                </select>
                            <p style="text-align: center; margin-left: 40px;">
                                <input name="btnVerGanadores" type="submit" value="Ver ganadores" /></p>
                        </form>
                    </div>

                    <%--condicional para los colaboradores y administradores--%>

                    <% if (tipoUsuario.equalsIgnoreCase("Colaborador") || ((String) sesion.getAttribute("tipoUsuario")).equalsIgnoreCase("Colaborador")) {%>
                    <div class="mid_content_info mid_content_space">
                        <h2 id="concursos">Opciones con Concursos</h2>
                        <p style="text-align: center;">
                            Participar concurso:</p>
                        <p style="text-align: center;">

                        <form ACTION="crearCuento.jsp" method="POST" style="text-align: center;">
                            <input name="btnCrearCuento" type="submit" value="Crear cuento" /><br />
                        </form>
                    </div>

                    <% } else if (tipoUsuario.equalsIgnoreCase("Administrador") || ((String) sesion.getAttribute("tipoUsuario")).equalsIgnoreCase("Administrador")) {%>

                    <div class="mid_content_info mid_content_space">
                        <h2 id="concursos">Opciones con Concursos</h2>

                        <p style="text-align: center;">
                            Participar concurso:</p>
                        <br>
                        <p style="text-align: center;">

                        <form ACTION="crearCuento.jsp" method="POST" style="text-align: center;">
                            <input name="btnCrearCuento" type="submit" value="Crear cuento" /><br />
                        </form>
                        <br><br><br>

                        <p style="text-align: center;">
                            Crear Concurso</p>
                        <br>
                        <p style="text-align: center;">

                        <form ACTION="crearConcurso.jsp" style="text-align: center;">
                            <input name="btnCrear" type="submit" value="Crear concurso" />
                        </form>

                    </div>

                    <%}%>

                </div> <!-- END .container -->
            </div> <!-- END #mid_content -->
        </div> <!-- END #main_content -->

        <%} else if (!estaRegistrado) {%>

        <div class="mid_content_info mid_content_space">
            <h2 id="acceso">Acceso</h2>
            <DIV ALIGN=center>
                Datos erroneos por favor verifica
                <br>
                <a href="index.jsp">volver a inicio</a>
                </p>
                <br><br><br>
                </p>
            </DIV>
        </div>
        <%}%>
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

