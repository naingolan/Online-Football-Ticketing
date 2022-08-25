<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page import="DbConnection.DbConnection" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Ticket.Ticket"%>
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
            <h1>Football Ticketing</h1>
        </div>
         <div class="nav">
             <ul>
                 <li><a href="Home.jsp">Home</a></li>
                 <li><a href="Myticket.jsp">My tickets</a></li>
                 <li><a href="weather.html">Profile</a></li>
                 <li><a href="#">Log Out</a></li> 
             </ul>
         </div>
 </header>
 <section>
    <div class="tips">
      <table >
          <thead>
              <tr >
                  <th >ID</th><th>MATCH</th><th>PRICE</th><th>DATE</th>
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
<div class="insert">
    <h2>Add More Matches</h2><!-- comment -->
    <form action="PostingServlet" method="get" >
    <input type='text' name ='name' placeholder='Enter Match Name'>
    <input type='text' name ='price' placeholder='Enter Entrance Price'><!-- comment -->
    <input type='date' name ='date' placeholder='Enter Match Date'>
    <input type="hidden" name ='username' value="none">
    <input style="background-color:darkblue; color:#ffffff" type="submit" value='Add'>
    </form>
</div>
   </section>
</body>
</html>