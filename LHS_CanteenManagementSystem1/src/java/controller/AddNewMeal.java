/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author user
 */
public class AddNewMeal extends HttpServlet {
    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
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
        try  {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();            
            EntityManager entityManager = (EntityManager) session.getAttribute("sessionEntity");
            
            // Create new meal object
            Meal meal = new Meal();
            // Retrieve meal attributes from session
            meal.setMealid(request.getParameter("mealid"));
            meal.setMealname(request.getParameter("mealname"));
            meal.setMealtype(request.getParameter("mealtype"));
            //meal.setMealtype("Breakfast"); //for now hardcoded, roger you code this one in the AddMeal.jsp
            meal.setMealcreditpoints(Integer.parseInt(request.getParameter("mealcreditpoints")));
           
            log("mealid----------->"+meal.getMealid());
            log("mealname--------->"+meal.getMealname());
            log("mealtype--------->"+meal.getMealtype());
            log("mealcreditpoint-->"+meal.getMealcreditpoints().toString());
            
            String selectedFood = request.getParameter("foodselname");
            String selectedBeverage = request.getParameter("beverageselname");
            log("foodname--------->"+selectedFood);
            log("beveragename----->"+selectedBeverage);
            
            // Retrieve selected food from session and query the food to get the correct food and store it with meal
            Query foodQuery = entityManager.createNamedQuery("Food.findByFoodname", Food.class);
            foodQuery.setParameter("foodname", selectedFood);
            Food foodResult = (Food) foodQuery.getSingleResult();
            meal.setFoodname(foodResult);
            
            // Retrieve selected beverage from session and query the beverage to get the correct beverage and store it with meal
            Query beverageQuery = entityManager.createNamedQuery("Beverage.findByBeveragename", Beverage.class);
            beverageQuery.setParameter("beveragename", selectedBeverage);
            Beverage beverageResult = (Beverage) beverageQuery.getSingleResult();
            meal.setBeveragename(beverageResult);
            
            // Now save the meal once the food and beverage are selected and stored with the meal
            try {
                utx.begin();
                em.persist(meal);
                utx.commit();
            } catch (Exception e) {
                utx.rollback();
             }
            //HttpSession session = request.getSession(); 
            session.setAttribute("meal", meal);
            //session.setAttribute("food", food);
            //session.setAttribute("beverage", beverage);

            response.sendRedirect("GetMealList");

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
