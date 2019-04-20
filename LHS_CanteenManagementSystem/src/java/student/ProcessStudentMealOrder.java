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

        if (intStudentCreditPoints >= intMealCreditPoints) {
            int paidCreditPoints = intStudentCreditPoints - intMealCreditPoints;
            System.out.println(paidCreditPoints);
            Date date;

            try {
                Query query = em.createNamedQuery("Mealorderb.findAll");
                List < Mealorderb > mealOrderBList = query.getResultList();
               // int mealOrderAmountPlus1 = mealOrderBList.size() + 1;
                //String stringMealOrderAmountPlus1 = String.valueOf(String.format("%04d",(mealOrderBList.size() + 1)));
                String mealIDFormat = "MO";
                String mealID = mealIDFormat + String.valueOf(String.format("%04d",(mealOrderBList.size() + 1)));//the String.valueOf is +1 to the amount of record> format it to 4 digit > convert to string> plus with the meal id format string
                mealorderb.setMealorderid(mealID);

                date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("mealorderdate"));
                mealorderb.setMealorderdate(date);

                meal.setMealid(request.getParameter("mealid"));
                mealorderb.setMealid(meal);

                mealorderb.setMealorderstatus("Paid");

                student.setStudentid(request.getParameter("studentid"));
                mealorderb.setStudentid(student);

                //student.setStudentcreditpoints(paidCreditPoints);

                utx.begin();
                em.persist(mealorderb);
                //em.persist(student);
                utx.commit();

                response.sendRedirect("student/Ordered.jsp");
            } catch (Exception ex) {}

        } else {
            //request.setAttribute("meal", meal);
            request.setAttribute("creditPointNotEnough", "Seem like your credit point not enough to buy this meal");
            request.getRequestDispatcher("student/StudentPreOrder.jsp").forward(request, response);
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