package Ticket;
import DbConnection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Ticket extends User.User {
    private String name;
    private String date;
    private int price;

    public Ticket(String name, int price, String date, String username) {
        super(username);
        this.name = name;
        this.date = date;
        this.price = price;
    }
    
 

    public String getName() {
        return name;
    }

    public void setName(String id) {
        this.name= name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public String userAdd(String name, int price, String date, String username){
         Connection con = DbConnection.getConn();
    String sql = "insert into paid (name, price, date, buyer) values (?,?,?,?)";
    int i = 0;
   try {
      PreparedStatement preparedStatement = con.prepareStatement(sql);
      preparedStatement.setString(1, name);
      preparedStatement.setInt(2, price);
      preparedStatement.setString(3, date); 
      preparedStatement.setString(4, username);
      i = preparedStatement.executeUpdate();
    } catch (SQLException e) {
    }
    if (i != 0) {
      return "User is registered";
    } else {
      return "Error!!!!";
    }    
  } 
      public String adminAdd(String name, int price, String date){
         Connection con = DbConnection.getConn();
    String sql = "insert into ticket(name, price, date) values (?,?,?) ";
    int i = 0;
   try {
      PreparedStatement preparedStatement = con.prepareStatement(sql);
      preparedStatement.setString(1, name);
      preparedStatement.setInt(2, price);
      preparedStatement.setString(3, date); 
      i = preparedStatement.executeUpdate();
    } catch (SQLException e) {
    }
    if (i != 0) {
      return "User is registered";
    } else {
      return "Error!!!!";
    }    
  } 

   
    public String userDelete(String name, int price, String date){
         Connection con = DbConnection.getConn();
    int i = 0;
   try {
     Statement stmt=con.createStatement(); 
     ResultSet rs=stmt.executeQuery("select userName, password from user");  
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
    public String access(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String admin(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
