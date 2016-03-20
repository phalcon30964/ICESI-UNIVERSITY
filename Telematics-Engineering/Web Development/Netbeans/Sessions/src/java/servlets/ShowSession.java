/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CL
 */
@WebServlet(name = "ShowSession", urlPatterns = {"/ShowSession"})
public class ShowSession extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String title = "Session Tracking";
            
            //Pregunto por la session si la sesion no existe la crea automaticamente;
            HttpSession session = request.getSession(true);
            
            String heading;
            //pregunto por el atributo, si no existe lo creo
            Integer accesCount = (Integer)session.getAttribute("accesCount");
            
            if(accesCount == null){
                accesCount = 0;
                heading = "Bienvenido visitante";
            }else{
                accesCount += 1;
                heading = "Bienvenido de vuelta";
            }
            
            session.setAttribute("accesCount", accesCount);
                                    
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>"+title+"</title>");            
            out.println("</head>");
            out.println("<body BGCOLOR=\"#FDF5E6\">");
            out.println("<h1 ALIGN=\"CENTER\">"+heading+"</h1>");
            out.println("<h2 >Informacion de su session</h2>");
            out.println("<table border=1 align=\"CENTER\">");
            out.println("<tr BGCOLOR=\"#FFAD00\">");
            out.println("<th>Info Type");
            out.println("<th>value");
            out.println("<tr>");
            out.println("<td>ID");
            out.println("<td>"+session.getId());
            out.println("<tr>");
            out.println("<td>Fecha de creacion");
            out.println("<td>"+ new Date(session.getCreationTime()));
            out.println("<tr>");
            out.println("<td>Ultimo acceso");
            out.println("<td>"+new Date(session.getLastAccessedTime()));
            out.println("<tr>");
            out.println("<td>Numero de accesos previos");
            out.println("<td>"+accesCount);
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
