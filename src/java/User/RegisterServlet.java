package User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public RegisterServlet() {
    super();
  }
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String confirm =request.getParameter("confirm");
    String email=request.getParameter("email");
    
    User user1 = new Register(username,email, password);
    String result=user1.access(user1.getUsername(),user1.getPassword());
    if (result.equals("User is registered")) {
        HttpSession session=request.getSession();
        session.setAttribute("username", user1.getUsername());
           
        RequestDispatcher dispatcher = request.getRequestDispatcher("Home.html");
        dispatcher.include(request, response);
      }else{
     RequestDispatcher dispatcher = request.getRequestDispatcher("register.html");
        dispatcher.include(request, response);
    }
  }
}