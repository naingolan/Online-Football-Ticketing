
package User;

import DbConnection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends User{
    
    public Login(String username, String password) {
        super(username, password);
    }
    
    /**
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public String access(String username, String password){
    Connection con = DbConnection.getConn();
    int i = 0;
   try {
     Statement stmt=con.createStatement(); 
     ResultSet rs=stmt.executeQuery("select username, passwrod from user where username='"+username+"'and passwrod='"+password+"';");  
     while(rs.next())
      i++;
    } catch (SQLException e) {
    }
    if (i != 0) {
      return "User is registered";
    } else {
      return "Error!!!!";
    }
    }
    @Override
        public String admin(String username, String password){
    Connection con = DbConnection.getConn();
    int i = 0;
    try {
     Statement stmt=con.createStatement(); 
     ResultSet rs=stmt.executeQuery("select username, password from admin where username='"+username+"' and password='"+password+"';");  
     while(rs.next())
      i++;
    } catch (SQLException e) {
    }
    if (i != 0) {
      return "User is registered";
    } else {
        return "Error!!!!";
    }
   }
   
}
