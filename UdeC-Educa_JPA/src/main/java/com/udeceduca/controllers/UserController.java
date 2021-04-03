/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udeceduca.controllers;

import com.udeceduca.DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author UdeC-Educa Dev's Team
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    
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
        UserDAO ud = new UserDAO();
         try (PrintWriter out = response.getWriter()) {
            //Se obtienen los parametros desde el form
            String firstName = request.getParameter("firstName");
            String secondName = request.getParameter("secondName");
            String firstLast = request.getParameter("firstLast");
            String secondLast = request.getParameter("secondLast");
            String identification = request.getParameter("identification");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            boolean val = ud.uniqueUser(identification);
            if (val){
                request.setAttribute("errorMessageRegister", "Usuario existente con esa identificacion");
                request.getRequestDispatcher("Index.jsp").forward(request, response);
            }else{
                ud.insertData(identification, firstName, secondName, firstLast, secondLast, email);
                ud.sp_UpdateUser(identification);
                ud.sp_EncryptPassword(identification, password);
                request.setAttribute("errorMessage", "Por favor revise su correo electrónico");
                request.getRequestDispatcher("Index.jsp").forward(request, response);
                
            }
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
