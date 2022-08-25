package User;

import DbConnection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register extends User{

    public Register(String username, String email, String password) {
        super(username, email, password);
    }
    
    @Override
    public String access(String username, String password){
    Connection con = DbConnection.getConn();
    String sql = "insert into user(username, passwrod) values (?,?) ";
    int i = 0;
   try {
      PreparedStatement preparedStatement = con.prepareStatement(sql);
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, password); 
      i = preparedStatement.executeUpdate();
    } catch (SQLException e) {
    }
    if (i != 0) {
      return "User is registered";
    } else {
      return "Error!!!!";
    }    
  }   

    @Override
    public String admin(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
