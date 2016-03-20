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
        <title>CuentaloWeb-Home</title>
        <link rel="stylesheet" type="text/css" href="stylesheets/reset.css" />
        <link rel="stylesheet" type="text/css" href="stylesheets/main.css" />
        <script type="text/javascript">var switchTo5x = true;</script>
        <script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
        <script type="text/javascript">stLight.options({publisher: "ur-feaac732-bb42-b64-411d-c7b7e32e3c48", doNotHash: false, doNotCopy: false, hashAddressBar: true});</script>
    </head>
    <body>
        
     <% if(AdminBD.sentencia==null){
            AdminBD.iniciarConexionConBd();
        }
     %>
        
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

            <div id="mid_content">
                <div class="container">
                    <div class="mid_content_info mid_content_space">
                        <h2 id="anonimo">Anónimo</h2>

                        <form name="Acceso como anonimo" ACTION="acceder.jsp" METHOD="POST">
                            <DIV ALIGN=center>
                                Para acceder como un usuario Anonimo<BR>
                                haga clic aqui<BR>
                                <input name="tipoUsuario" type="hidden" value="Anonimo" />
                                <input type="submit" value="Acceso Anonimo" /><BR>
                            </DIV>
                        </form>
                    </div>

                    <div class="mid_content_info mid_content_space">
                        <h2 id="acceso">Acceder</h2>
                        <form name="Formulario de acceso" action="acceder.jsp" method="POST">
                            <DIV ALIGN=center>
                                <BR>Para Acceder como Lector,<BR> Colaborador o Administrador<BR>
                                <BR>
                                Usuario: <input type="text" name="nombre" value="" /><BR>
                                Contraseña: <input type="password" name="contrasena" value="" /><BR>
                                Tipo de Usuario: <select name="tipoUsuario">
                                    <option selected="selected">Lector</option>
                                    <option >Colaborador</option>
                                    <option >Administrador</option>
                                </select><BR>
                                <input type="submit" value="Acceder" />
                            </DIV>
                        </form>
                    </div>

                    <div class="mid_content_info mid_content_space">
                        <h2 id="fully">Registro</h2>
                        <form action="registrarUsuario.jsp" method="POST">
                            <DIV ALIGN=center>
                                Para registrarte ingresa los siguientes datos:<br><br>
                                Nombre:<input type="text" name="nombre" value="" /><br>
                                Apellido:<input type="text" name="apellido" value="" /><br>
                                Contraseña:<input type="password" name="contrasena" value="" /><br>
                                Direccion:<input type="text" name="direccion" value="" /><br>
                                Telefono:<input type="text" name="telefono" value="" /><br>
                                Fecha de Nacimiento:
                                <select name="dia">
                                    <OPTION selected>1</OPTION> <OPTION>2</OPTION> 
                                    <OPTION>3</OPTION> <OPTION>4</OPTION> <OPTION>5</OPTION> 
                                    <OPTION>6</OPTION> <OPTION>7</OPTION> <OPTION>8</OPTION> 
                                    <OPTION>9</OPTION> <OPTION>10</OPTION> <OPTION>11</OPTION> 
                                    <OPTION>12</OPTION> <OPTION>13</OPTION> <OPTION>14</OPTION> 
                                    <OPTION>15</OPTION> <OPTION>16</OPTION> <OPTION>17</OPTION> 
                                    <OPTION>18</OPTION> <OPTION>19</OPTION> <OPTION>20</OPTION> 
                                    <OPTION>21</OPTION> <OPTION>22</OPTION> <OPTION>23</OPTION> 
                                    <OPTION>24</OPTION> <OPTION>25</OPTION> <OPTION>26</OPTION> 
                                    <OPTION>27</OPTION> <OPTION>28</OPTION> <OPTION>29</OPTION> 
                                    <OPTION>30</OPTION> <OPTION>31</OPTION>
                                </SELECT> 

                                <SELECT name=Mes> 
                                    <OPTION selected>Enero</OPTION> <OPTION >Febrero</OPTION> <OPTION 
                                        >Marzo</OPTION> <OPTION >Abril</OPTION> <OPTION 
                                        >Mayo</OPTION> <OPTION >Junio</OPTION> <OPTION 
                                        >Julio</OPTION> <OPTION >Agosto</OPTION> <OPTION 
                                        >Septiembre</OPTION> <OPTION >Octubre</OPTION> <OPTION 
                                        >Noviembre</OPTION> <OPTION >Diciembre</OPTION>
                                </SELECT> 

                                <SELECT name=Anho>
                                    <OPTION selected >2013</OPTION> <OPTION
                                        >2012</OPTION> <OPTION >2011</OPTION> <OPTION 
                                        >2010</OPTION> <OPTION >2009</OPTION> <OPTION 
                                        >2008</OPTION> <OPTION >2007</OPTION> <OPTION 
                                        >2006</OPTION> <OPTION >2005</OPTION> <OPTION 
                                        >2004</OPTION> <OPTION >2003</OPTION> <OPTION 
                                        >2002</OPTION> <OPTION >2001</OPTION> <OPTION 
                                        >2000</OPTION> <OPTION >1999</OPTION> <OPTION 
                                        >1998</OPTION> <OPTION >1997</OPTION> <OPTION 
                                        >1996</OPTION> <OPTION >1995</OPTION> <OPTION 
                                        >1994</OPTION> <OPTION >1993</OPTION> <OPTION 
                                        >1992</OPTION> <OPTION >1991</OPTION> <OPTION 
                                        >1990</OPTION> <OPTION >1989</OPTION> <OPTION 
                                        >1988</OPTION> <OPTION >1987</OPTION> <OPTION 
                                        >1986</OPTION> <OPTION >1985</OPTION> <OPTION 
                                        >1984</OPTION> <OPTION >1983</OPTION> <OPTION 
                                        >1982</OPTION> <OPTION >1981</OPTION> <OPTION 
                                        >1980</OPTION> <OPTION >1979</OPTION> <OPTION 
                                        >1978</OPTION> <OPTION >1977</OPTION> <OPTION 
                                        >1976</OPTION> <OPTION >1975</OPTION> <OPTION 
                                        >1974</OPTION> <OPTION >1973</OPTION> <OPTION 
                                        >1972</OPTION> <OPTION >1971</OPTION> <OPTION 
                                        >1970</OPTION> <OPTION >1969</OPTION> <OPTION 
                                        >1968</OPTION> <OPTION >1967</OPTION> <OPTION 
                                        >1966</OPTION> <OPTION >1965</OPTION> <OPTION 
                                        >1964</OPTION> <OPTION >1963</OPTION> <OPTION 
                                        >1962</OPTION> <OPTION >1961</OPTION> <OPTION 
                                        >1960</OPTION> <OPTION >1959</OPTION> <OPTION 
                                        >1958</OPTION> <OPTION >1957</OPTION> <OPTION 
                                        >1956</OPTION> <OPTION >1955</OPTION> <OPTION 
                                        >1954</OPTION> <OPTION >1953</OPTION> <OPTION 
                                        >1952</OPTION> <OPTION >1951</OPTION> <OPTION 
                                        >1950</OPTION> <OPTION >1949</OPTION> <OPTION 
                                        >1948</OPTION> <OPTION >1947</OPTION> <OPTION 
                                        >1946</OPTION> <OPTION >1945</OPTION> <OPTION 
                                        >1944</OPTION> <OPTION >1943</OPTION> <OPTION 
                                        >1942</OPTION> <OPTION >1941</OPTION> <OPTION 
                                        >1940</OPTION> <OPTION >1939</OPTION> <OPTION 
                                        >1938</OPTION> <OPTION >1937</OPTION> <OPTION 
                                        >1936</OPTION> <OPTION >1935</OPTION> <OPTION 
                                        >1934</OPTION> <OPTION >1933</OPTION> <OPTION 
                                        >1932</OPTION> <OPTION >1931</OPTION> <OPTION 
                                        >1930</OPTION> <OPTION >1929</OPTION> <OPTION 
                                        >1928</OPTION> <OPTION >1927</OPTION> <OPTION 
                                        >1926</OPTION></SELECT>
                                <br>
                                Email: <input type="text" name="email" value="" />
                                <br>
                                <input type="submit" value="Registrar" />
                            </DIV>
                        </form>
                    </div>
                </div> <!-- END .container -->
            </div> <!-- END #mid_content -->
        </div> <!-- END #main_content -->

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
