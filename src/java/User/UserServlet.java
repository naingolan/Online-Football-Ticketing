package User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public UserServlet() {
    super();
  }
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    String userName = request.getParameter("username");
    String password = request.getParameter("password");
    
    User user1 = new Login(userName, password);
    String result=user1.admin(user1.getUsername(),user1.getPassword());
    if (result.equals("User is registered")) {
        HttpSession session=request.getSession();
        session.setAttribute("username", user1.getUsername());   
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.include(request, response);
      } 
    
    result=user1.access(user1.getUsername(),user1.getPassword());
    if (result.equals("User is registered")) {
        HttpSession session=request.getSession();
        session.setAttribute("username", user1.getUsername());   
        RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
        dispatcher.include(request, response);
      } else{
     RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
        dispatcher.include(request, response);
    }
  }
}