<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page import="DbConnection.DbConnection" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
Connection con = DbConnection.getConn();
Statement statement = null;
ResultSet resultSet = null;

String username=(String)session.getAttribute("username");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Football Ticketing</title>
</head>
<body>
    <header>
        <div class="head">
            <h1>Online Football Ticekting</h1>
        </div>
         <div class="nav">
             <ul>
                 <li><a href="Home.jsp">Home</a></li>
                 <li><a href="Myticket.jsp">My tickets</a></li>
                 <li><a href="weather.html">Profile</a></li>
                 <li><a href="logout.jsp">Log Out</a></li> 
             </ul>
         </div>
 </header>
 <section>
    <div class="tips">
      <table >
          <thead>
              <tr >
                  <th >ID</th><th>MATCH</th><th>PRICE</th><th>DATE</th><th>BUY</th>
              </tr>
          </thead>
          <tbody>
              <%
 int incre=1;
 try{ 
statement=con.createStatement();
String sql ="SELECT * FROM ticket ORDER BY ID ASC;";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
             
<tr >
<td><%=(incre++) %></td>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("price") %></td>
<td><%=resultSet.getString("date") %></td>
<td>
    <a href="TicketServlet?name=<%=resultSet.getString("name")%>&price=<%=resultSet.getString("price")%>&date=<%=resultSet.getString("date")%>&username=<%=username%>">
        <button type="button"  class="delete">Buy</button>   
   </a>
</td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>

                </tbody>
                </table>
    </div>
   </section>
</body>
</html>