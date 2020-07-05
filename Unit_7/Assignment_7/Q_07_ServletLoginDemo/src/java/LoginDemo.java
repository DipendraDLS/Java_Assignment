import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/LoginDemo"})
public class LoginDemo extends HttpServlet 
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginDemo</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //getting form input values 
            String getUsername = request.getParameter("username"); 
            String getPassword = request.getParameter("password");
            
            //checking username and password.
            if(getUsername.equals("admin") && getPassword.equals("admin"))
            {
               out.println("<h1 style=color:green;>User is authenticated.<br> Welcome to the admin page!</h1>");
            }
            else
            {
                out.println("<h1 style=color:red;>User is invalid!!<br> Username or Password error.</h1>");
            }  
            out.println("</body>");
            out.println("</html>");
        }
    }
}
