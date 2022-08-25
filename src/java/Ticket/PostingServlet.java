package Ticket;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/PostingServlet"})
public class PostingServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public PostingServlet() {
    super();
  }
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    String name = request.getParameter("name");
    int price;
      price = Integer.parseInt(request.getParameter("price"));
    String date=request.getParameter("date");
    String username=request.getParameter("username");
    
    Ticket ticket1 = new Ticket(name, price, date, username);
    String result= ticket1.adminAdd(name, price, date);
    if (result.equals("User is registered")) {   
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.include(request, response);
      } 
  }
}