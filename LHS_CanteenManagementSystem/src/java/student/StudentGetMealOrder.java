package student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.*;
import java.io.*;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.*;
import javax.transaction.UserTransaction;

/**
 *
 * @author user
 */
public class StudentGetMealOrder extends HttpServlet {
    @PersistenceContext EntityManager em;
    @Resource UserTransaction ut;

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
         
        HttpSession session = request.getSession(false);
        Student student = (Student) session.getAttribute("student");
        
        try {
               ut.begin();
               List<Mealorderb> mealorders = em.createQuery("SELECT m FROM Mealorderb m WHERE m.studentid = :studentid").setParameter("studentid",request.getParameter("studentid")).getResultList();
               System.out.println("studentid");
               ut.commit();
               System.out.println(mealorders.size());
               System.out.println("text text etxt" + mealorders.size());
                request.setAttribute("mealorders", mealorders);
              request.getRequestDispatcher("student/StudentMealOrder.jsp").forward(request, response);
        }   
        catch (Exception ex) {
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