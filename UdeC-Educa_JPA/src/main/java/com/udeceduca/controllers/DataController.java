/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udeceduca.controllers;

import com.udeceduca.DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author UdeC-Educa Dev's Team
 */
@WebServlet(name = "DataController", urlPatterns = {"/DataController"})
public class DataController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {

            UserDAO userMeth = new UserDAO();
            boolean validate = userMeth.queryFindUser(request.getParameter("username"), request.getParameter("password"));
            out.print(validate);

            if (validate) {
                String captcha = request.getParameter("g-recaptcha-response");
                boolean verify = ValidateProcess.verificar(captcha);
                if (verify) {
                    System.out.println("Funciona");
                    HttpSession session = request.getSession();
                    session.setAttribute("userSession", userMeth);
                    request.getRequestDispatcher("Access.jsp").forward(request, response);
                    //response.sendRedirect("Access.jsp");
                } else {
                    request.getRequestDispatcher("Index.jsp").forward(request, response);
                    request.setAttribute("errorMessage", "Captcha obligatorio");
                }
            } else {
                System.out.println("No funiona");
                request.setAttribute("errorMessage", "Datos incorrectos");
                request.getRequestDispatcher("Index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
