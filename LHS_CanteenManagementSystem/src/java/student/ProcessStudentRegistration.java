package student;

import java.io.*;
import javax.annotation.Resource;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.transaction.UserTransaction;
import entity.Student;

public class ProcessStudentRegistration extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         Student student = new Student();
        
         String studentID=request.getParameter("studentid");
         String studentName=request.getParameter("studentname");
         String studentPassword=request.getParameter("studentpassword");
         String studentPhoneNo=request.getParameter("studentphoneno");
         String studentEmail=request.getParameter("studentemail");
        
         student.setStudentid(studentID);
         student.setStudentname(studentName);
         String result=Identification.registerCheck(student);
        
        if(result.equals("true")){
            try {
                HttpSession session = request.getSession();
                student.setStudentid(studentID);
                student.setStudentname(studentName);
                 student.setStudentpassword(studentPassword);
                student.setStudentemail(studentEmail);
                student.setStudentcreditpoints(0);
                student.setStudentphoneno(studentPhoneNo);
                try {
                    utx.begin();
                    em.persist(student);
                    utx.commit();
                } 
                catch (Exception e) {
                    utx.rollback();
                }
            session.setAttribute("student", student);
            response.sendRedirect("Registered.html");
            } 
            catch (Exception ex) {
            }
       }
        
        if(result.equals("false")){
            request.setAttribute("studentID",studentID);
            request.setAttribute("studentName",studentName);
            request.setAttribute("studentPhoneNo",studentPhoneNo);
            request.setAttribute("studentEmail",studentEmail);
            request.setAttribute("ID_NoExistMessage", "No such registered ID or name, you may enter a wrong ID or name or both, or filled an ID and name that did not register yet");
            request.getRequestDispatcher("StudentRegistration.jsp").forward(request, response);
        }
        
        if(result.equals("error")){
            response.sendRedirect("TestFile1.jsp");
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
