package controller;

import entity.*;
import java.io.*;
import javax.annotation.Resource;
//import java.util.*;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.transaction.UserTransaction;

public class AddNewFood extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            
            Food food = new Food();
            food.setFoodid(request.getParameter("foodid"));
            food.setFoodname(request.getParameter("foodname"));
            food.setFoodcreditpoints(Integer.parseInt(request.getParameter("foodcreditpoints")));
            food.setFoodquantity(Integer.parseInt(request.getParameter("foodquantity")));
            
            
            try {
            utx.begin();
            em.persist(food);
            utx.commit();
            } catch (Exception e) {
                utx.rollback();
            }
            session.setAttribute("food", food);

            response.sendRedirect("staff/food.jsp");

        } catch (Exception ex) {
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
