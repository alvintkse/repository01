package student;
 
import java.sql.*;

public class GenerateOrderID {
    public static String addRecord(Member member) {
        ResultSet rs = null;
        int memberCount = 0;
        try {
            Connection con= DBConnection.getConnection();
            PreparedStatement stmt;
            
            stmt = con.prepareStatement("Select COUNT(*) from MEMBER");
            rs= stmt.executeQuery();
            while(rs.next()){

               memberCount = Integer.parseInt(rs.getString(1));
            }
            String memberID = "M1" + String.format("%03d",memberCount+1);
            
            

            

            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
