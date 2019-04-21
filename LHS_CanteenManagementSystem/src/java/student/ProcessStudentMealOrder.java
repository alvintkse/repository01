package student;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import javax.annotation.Resource;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.transaction.UserTransaction;
import entity.Mealorderb;
import entity.Meal;
import entity.Student;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcessStudentMealOrder extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        Mealorderb mealorderb = new Mealorderb();
        Meal meal = new Meal();
        Student student = new Student();

        int intStudentCreditPoints = Integer.parseInt(request.getParameter("studentcreditpoints"));
        int intMealCreditPoints = Integer.parseInt(request.getParameter("mealCreditPoints"));

        //make sure student's credit point enough else, show error message
        if (intStudentCreditPoints >= intMealCreditPoints) {
            int paidCreditPoints = intStudentCreditPoints - intMealCreditPoints;
            System.out.println(paidCreditPoints);
            Date date;

            try {
                //generate and store ID
                Query query = em.createNamedQuery("Mealorderb.findAll");
                List < Mealorderb > mealOrderBList = query.getResultList();
                String mealIDFormat = "MO";
                String mealID = mealIDFormat + String.valueOf(String.format("%04d",(mealOrderBList.size() + 1)));//the String.valueOf is +1 to the amount of record> format it to 4 digit > convert to string> plus with the meal id format string
                mealorderb.setMealorderid(mealID);
                
                //store date
                date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("mealorderdate"));
                mealorderb.setMealorderdate(date);
                
                //store mealID
                meal.setMealid(request.getParameter("mealid"));
                mealorderb.setMealid(meal);
                
                //store status
                mealorderb.setMealorderstatus("Paid");

                //store student ID
                student.setStudentid(request.getParameter("studentid"));
                mealorderb.setStudentid(student);

                //student.setStudentcreditpoints(paidCreditPoints);
                

                utx.begin();
                em.persist(mealorderb);
                 //em.getTransaction().begin();
                 //em.find(Student.class ,request.getParameter("studentid"));
                 //student.setStudentcreditpoints(paidCreditPoints);
                utx.commit();

                response.sendRedirect("student/Ordered.jsp");
            } catch (Exception ex) {}

        } else {
            /*request.setAttribute("meal.mealid", request.getParameter("mealid"));
            request.setAttribute("meal.mealname", request.getParameter("mealname"));
            request.setAttribute("(meal.foodname).getFoodname()", request.getParameter("foodname"));
            request.setAttribute("(meal.beveragename).getBeveragename()",request.getParameter("beveragename"));
            request.setAttribute("meal.mealcreditpoints", request.getParameter("mealCreditPoints"));
            request.setAttribute("creditPointNotEnough", "Seem like your credit point not enough to buy this meal");
            request.getRequestDispatcher("student/StudentPreOrderMeal.jsp").forward(request, response);*/
             response.sendRedirect("student/CreditPointNotEnough.jsp");
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
        } // </editor-fold>
}