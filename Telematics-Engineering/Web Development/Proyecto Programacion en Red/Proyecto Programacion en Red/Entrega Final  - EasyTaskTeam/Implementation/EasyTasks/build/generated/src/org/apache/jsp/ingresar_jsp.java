package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import control.AdministradorBD;

public final class ingresar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Task Easy</title>\r\n");
      out.write("<meta charset=\"utf-8\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("<!--[if lte IE 8]><script src=\"assets/js/ie/html5shiv.js\"></script><![endif]-->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"assets/css/main.css\" />\r\n");
      out.write("<!--[if lte IE 8]><link rel=\"stylesheet\" href=\"assets/css/ie8.css\" /><![endif]-->\r\n");
      out.write("<!--[if lte IE 9]><link rel=\"stylesheet\" href=\"assets/css/ie9.css\" /><![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"index\">\r\n");
      out.write("<div id=\"page-wrapper\">\r\n");
      out.write("<header id=\"header\" class=\"alt\">\r\n");
      out.write("  <h1 id=\"logo\">&nbsp;</h1>\r\n");
      out.write("  <nav id=\"nav\">\r\n");
      out.write("    <ul>\r\n");
      out.write("      <li class=\"current\"><a href=\"index.html\">Inicio</a></li>\r\n");
      out.write("      <li><a href=\"registrar.jsp\" class=\"button special\">Registrar</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("  </nav>\r\n");
      out.write("</header>\r\n");
      out.write("<!-- Main -->\r\n");
      out.write("<article id=\"main\">\r\n");
      out.write("\r\n");
      out.write("<!-- One -->\r\n");
      out.write("\r\n");
      out.write("<section class=\"wrapper style3 container special-alt\">\r\n");
      out.write("  <div class=\"row 50%\">\r\n");
      out.write("   <form action=\"ingresar.jsp\" method=\"POST\">\r\n");
      out.write("    <div class=\"8u 12u(narrower)\">\r\n");
      out.write("      <header> <img src=\"images/logo.png\" width=\"426\" height=\"242\">\r\n");
      out.write("        <div class=\"row 50%\">\r\n");
      out.write("          <div class=\"6u 12u(mobile)\">\r\n");
      out.write("            <input name=\"usuario\" type=\"text\" class=\"fa-tree\" placeholder=\"Usuario\" />\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"6u 12u(mobile)\">\r\n");
      out.write("            <input type=\"password\" name=\"contrasena\" placeholder=\"Contraseña\" />\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </header>\r\n");
      out.write("      <footer>\r\n");
      out.write("      <div class=\"row 50%\">\r\n");
      out.write("        <div class=\"12u\"></div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("        <div class=\"12u(mobile)\">\r\n");
      out.write("          <ul>\r\n");
      out.write("          <input type=\"submit\" class=\"special\" value=\"Ingresar\" />\r\n");
      out.write("          </ul>  \r\n");
      out.write("            <ul>\r\n");
      out.write("            \r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>  \r\n");
      out.write("      </form>\r\n");
      out.write("      <form action=\"contrasenaRestablecida.jsp\" method=\"POST\">\r\n");
      out.write("            <script>\r\n");
      out.write("\t\t\tfunction restablecer(){\r\n");
      out.write("\t\t\tvar nombreUsuarioRestablecer =\tprompt(\"Porfavor Ingrese su nombre: \");\r\n");
      out.write("                        document.getElementById('elemento').value=nombreUsuarioRestablecer;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("            </script>\r\n");
      out.write("            <input type=\"hidden\" name=\"elemento\" id=\"elemento\" />\r\n");
      out.write("            <input type=\"submit\" class=\"special\" value=\"Restablecer Contraseña\" onClick=\"restablecer()\" />\r\n");
      out.write("      </form> \r\n");
      out.write("      \r\n");
      out.write("    </div>\r\n");
      out.write("   \r\n");
      out.write("        \r\n");
      out.write("    <div class=\"6u 12u(narrower) important(narrower)\">\r\n");
      out.write("      <ul class=\"featured-icons\">\r\n");
      out.write("        <li><span class=\"icon fa-clock-o\"><span class=\"label\">Feature 1</span></span></li>\r\n");
      out.write("        <li><span class=\"icon fa-volume-up\"><span class=\"label\">Feature 2</span></span></li>\r\n");
      out.write("        <li><span class=\"icon fa-laptop\"><span class=\"label\">Feature 3</span></span></li>\r\n");
      out.write("        <li><span class=\"icon fa-inbox\"><span class=\"label\">Feature 4</span></span></li>\r\n");
      out.write("        <li><span class=\"icon fa-lock\"><span class=\"label\">Feature 5</span></span></li>\r\n");
      out.write("        <li><span class=\"icon fa-cog\"><span class=\"label\">Feature 6</span></span></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write(" \r\n");
      out.write("  </div>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");

            if(AdministradorBD.getConnection()){
            
            String usuario = request.getParameter("usuario");
            String contrasena = request.getParameter("contrasena");
            
                if(usuario != null && contrasena!= null){
        
                        if(AdministradorBD.iniciarSesion(usuario, contrasena)){ 
                            //valido sesion
                            HttpSession s = request.getSession(true);
                            s.setAttribute("Usuario", usuario);
                            //redireciono al cuerpo
                            RequestDispatcher rd = request.getRequestDispatcher("casa - copia.jsp");
                            rd.forward(request, response);
                            
                        }else{  

      out.write("\r\n");
      out.write("            \r\n");
      out.write("                        <script> alert('Usuario y contraseña no coinciden') </script> \r\n");
      out.write("            \r\n");
                      }
            
                }
                
            }else{
            

      out.write("\r\n");
      out.write("            \r\n");
      out.write("             <script> alert('Error de conexion con el servidor') </script> \r\n");
      out.write("             \r\n");

            }
  

      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
