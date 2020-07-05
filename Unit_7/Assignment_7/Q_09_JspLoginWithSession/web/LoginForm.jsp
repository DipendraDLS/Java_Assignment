<%-- 
    Document   : LoginForm.jsp
    Created on : Jun 25, 2020, 10:36:25 AM
    Author     : dipen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String error ="";
      if(request.getMethod().equalsIgnoreCase("POST"))
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("admin") && password.equals("admin"))
            {
                session.setAttribute("username", username);
                response.sendRedirect("admin.jsp");
            }
            else
            {
                error = "Invalid Username or Password!!";    
            }
        }

%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Form</title>
    </head>
    <body>
        <h1>User Login Form.</h1>
        <form action ="" method="POST">
            Username: <input type="text" name="username"><br><br>
            Password:<input type="password" name="password"><br><br>
            <p style= color:red;><%= error %></p>
            <input type="Submit" value="Submit">
            
       
    </body>
</html>
