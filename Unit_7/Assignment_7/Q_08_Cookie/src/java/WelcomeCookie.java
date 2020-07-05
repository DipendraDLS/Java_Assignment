import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/WelcomeCookie"})
public class WelcomeCookie extends HttpServlet 
{
    //create Cookie
     private void addCookies(HttpServletResponse response,String name, String value) 
     {
        Cookie cookie = new Cookie(name, value);
        response.addCookie(cookie);
    }
    //Read Cookie 
    private String getCookie(HttpServletRequest request, String name)
    {
        Cookie[] cookies = request.getCookies();
 
        if(cookies == null) 
            return null;
        for(Cookie cookie: cookies) 
        {
            if(cookie.getName().equals(name))
                return cookie.getValue();
        }
        return null;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WelcomeCookie</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //getting the form input from user
            String name = request.getParameter("username");
            
            //Creating Cookie
            addCookies(response, name, name);
            out.print("Cookie was created with the cookie name as " + name);
                     
            //calling getCookie() method to get the cookie value that we have set it through addCookie() method.
            String cookieValue = getCookie(request,name);
            if(cookieValue!=null)
                out.println("</br>Welcome " + cookieValue);
            out.println("</body>");
            out.println("</html>");
        }
    }  
}
