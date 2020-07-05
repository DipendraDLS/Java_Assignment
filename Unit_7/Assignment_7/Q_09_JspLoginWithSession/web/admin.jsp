<%-- 
    Document   : admin.jsp
    Created on : Jun 28, 2020, 11:27:32 AM
    Author     : dipen
--%>

<%
        String username = (String)session.getAttribute("username");
        if(username == null || username.equals("")) 
        {
            response.sendRedirect("LoginForm.jsp");
        }     
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page.</title>
    </head>
    <body>
        <h1 style="color:green">Welcome to the Admin Page!</h1>
        <a href="logout.jsp">Logout</a>
    </body>
</html>
