package DbConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnection {
  public static Connection getConn() {
    Connection con = null;
    String loadDriver = "com.mysql.jdbc.Driver";
    String dbURL = "jdbc:mysql://localhost:3306/ticketing";
    String dbUSERNAME = "root";
    String dbPASSWORD = "";
    try {
      Class.forName(loadDriver);
      con = DriverManager.getConnection(dbURL, dbUSERNAME, dbPASSWORD);
    } catch (ClassNotFoundException | SQLException e) {
        
    }
      return con;
  }
}