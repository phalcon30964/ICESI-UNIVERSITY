/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CL
 */
@WebServlet(name = "SetCookies", urlPatterns = {"/SetCookies"})
public class SetCookies extends HttpServlet {

    
    private String i;
    
    public void io(){
    }
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
        
        
         for (int i = 0; i < 3; i++) {
                //Estas cookies son temporales, porque por defecto tiene el MaxAge como -1. 
                //Se borrara cuando se reinicie el navegador
                Cookie cookie = new Cookie("Session-Cookie-"+i,"Cookie-Value-S"+i);
                response.addCookie(cookie);
                //Estas otras cookies son persistentes,porque su MaxAge estará para 10 min, 
                //se guardaran por 10 min en el disco duro
                cookie = new Cookie("Persistent-Cookie-"+i, "Cookie-Value-P"+i);
                //60 segudos por 10 minutos
                cookie.setMaxAge(60*2);
                response.addCookie(cookie);
            }
        
         io();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String tittle = "Setting Cookies";
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>"+tittle+"</title>");            
            out.println("</head>");
            out.println("<body BGCOLOR=\"#FDF5E6\">");
            out.println("<h1 ALIGN=\"CENTER\">"+tittle+"</h1>");
            out.println("Hay 6 cookies asociadas a esta pagina, para verlas  visite:");
            out.println("<A HREF=\"/Cookies/ShowCookies\">");
            out.println("<CODE>ShowCookies</CODE>");
            out.println("servlet </A>");
            out.println("<P>");
            out.println("Tres de las cookies estan asociadas solo a esta sesion, \n miestras que otras persistiran por 2 min. \n Salga del navegador y luego ingrese al servlet <CODE>ShowCookies</CODE> para comprobar esto.\nLos 3 persistentes deberan todavia aparecer.");
            out.println("<P>");
            out.println("Si desea ver la hora haga click ");
            out.println("<A HREF=\"/Cookies/hora/hora.jsp\" title=\"Servlet hora\">");
            out.println("<CODE>aquí</CODE>");
            out.println("</A>");            
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
