<%-- 
    Document   : registro
    Created on : 28/05/2015, 02:45:15 PM
    Author     : JuanDiego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Task Easy - Registro</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
        <link rel="stylesheet" href="assets/css/main.css" />
        <!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
        <!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
    </head>
    <body class="contact">
        <div id="page-wrapper">

            <!-- Header -->
            <header id="header">
                <h1 id="logo">&nbsp;</h1>
                <nav id="nav">
                    <ul>
                        <li class="current"><a href="index.jsp">Inicio</a></li>

                        <li><a href="login.jsp" class="button special">Iniciar Sesion</a></li>
                    </ul>
                </nav>
            </header>

            <!-- Main -->
            <article id="main">

                <header class="special container">
                    <span class="icon fa-envelope"></span>
                    <h2>Registrarse</h2>
                    <p>Ingrese todos los datos para crear su cuenta</p>
                </header>

                <!-- One -->
                <section class="wrapper style4 special container 75%">

                    <!-- Content -->
                    <div class="content">
                        <form method="POST">
                            <div class="row 50%">
                                <div class="6u 12u(mobile)">
                                    <input type="text" name="nombres" placeholder="nombres" />
                                </div>
                                <div class="6u 12u(mobile)">
                                    <input type="text" name="apellidos" placeholder="apellidos" />
                                </div>
                            </div>
                            <div class="row 50%">
                                <div class="6u 12u(mobile)">
                                    <input type="text" name="usuario" placeholder="usuario" />
                                </div>
                                <div class="6u 12u(mobile)">
                                    <input type="password" name="contraseña" placeholder="contraseña" />
                                </div>
                            </div>
                            <div class="row 50%">
                                <div class="12u">
                                    <input type="text" name="correo" placeholder="correo" />
                                </div>
                            </div>
                            <div class="row 50%">
                                <div class="12u"></div>
                            </div>
                            <div class="row">
                                <div class="12u">
                                    <ul class="buttons">
                                        <li><input type="submit" class="special" value="Registrar" /></li>
                                    </ul>
                                </div>
                            </div>
                        </form>
                    </div>

                </section>

            </article>

            <!-- Footer -->
            <footer id="footer">

                <ul class="icons">
                    <li><a href="#" class="icon circle fa-twitter"><span class="label">Twitter</span></a></li>
                    <li><a href="#" class="icon circle fa-facebook"><span class="label">Facebook</span></a></li>
                    <li><a href="#" class="icon circle fa-google-plus"><span class="label">Google+</span></a></li>
                    <li><a href="#" class="icon circle fa-github"><span class="label">Github</span></a></li>
                    <li><a href="#" class="icon circle fa-dribbble"><span class="label">Dribbble</span></a></li>
                </ul>

                <ul class="copyright">
                    <li>&copy; Untitled</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
                </ul>

            </footer>

        </div>

        <!-- Scripts -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/jquery.dropotron.min.js"></script>
        <script src="assets/js/jquery.scrolly.min.js"></script>
        <script src="assets/js/jquery.scrollgress.min.js"></script>
        <script src="assets/js/skel.min.js"></script>
        <script src="assets/js/util.js"></script>
        <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
        <script src="assets/js/main.js"></script>

    </body>
</html>
