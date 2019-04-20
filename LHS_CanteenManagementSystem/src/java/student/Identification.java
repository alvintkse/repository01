package student;

import controller.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entity.Student;

public class Identification {
    
     public static String registerCheck(Student student){
        String query= "select * from STUDENTLIST  where STUDENTID=?  and STUDENTNAME=? ";
        try{
            Connection con= ConnectionDB.getConnection();
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,student.getStudentid());
            ps.setString(2,student.getStudentname());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){                          
                return "true";
            }
            else{
                return "false";
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "error";
    }
    
    public static String studentLoginCheck(Student student){
        String query= "select * from STUDENT where STUDENTID=? and STUDENTPASSWORD=?";
        try{
            Connection con= ConnectionDB.getConnection();
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,student.getStudentid());
            ps.setString(2,student.getStudentpassword());                       
            ResultSet rs=ps.executeQuery();
            if(rs.next()){                          
                return "true";
            }
            else{
                return "false";
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "error";
    }
}

