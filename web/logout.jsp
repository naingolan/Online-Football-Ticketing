<%
    session.invalidate();
    RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
        dispatcher.include(request, response);
    
%>
