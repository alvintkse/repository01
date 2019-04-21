 package student;
 
import java.sql.Connection;
import java.sql.DriverManager;
 
public class ConnectionDB {
    static final String host="jdbc:derby://localhost:1527/canteenDB";
    static final String user = "nbuser";
    static final String pass = "nbuser";
    public static Connection getConnection(){
        Connection con=null;
        try{
            con=DriverManager.getConnection(host,user,pass);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}