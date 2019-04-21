
package student;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Student;

/**
 *
 * @author USER
 */
@WebServlet(name = "ProcessStudentLogin", urlPatterns = {"/ProcessStudentLogin"})
public class ProcessStudentLogin extends HttpServlet {
    @PersistenceContext EntityManager em;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
         response.setContentType("text/html;charset=UTF-8");
        
        Student stud=new Student();
        String studentID = request.getParameter("studentid");
        String studentPassword=request.getParameter("studentpassword");
        
        stud.setStudentid(studentID);
        stud.setStudentpassword(studentPassword);
        String result=Identification.studentLoginCheck(stud);
        if(result.equals("true")){
             try {
            List<Student> students = em.createNamedQuery("Student.findByStudentid").setParameter("studentid", studentID).getResultList();
            if (students.isEmpty())
            {
                System.out.println("Student not found");
            }
            Student student = students.get(0);
            HttpSession session = request.getSession();
            session.setAttribute("student", student);
            response.sendRedirect("StudentGetMealList");
        }   
            catch (Exception ex) {
            }
       }

        if(result.equals("false")){
            request.setAttribute("studentID", studentID);
            request.setAttribute("logInInvalidMessage", "You fill a wrong password or ID, or neither, please try again");
            request.getRequestDispatcher("StudentLogin.jsp").forward(request, response);
        }
        
        if(result.equals("error")){
            response.sendRedirect("ErrorHandler.jsp");
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
