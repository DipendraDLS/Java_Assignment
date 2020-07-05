<%-- 
    Document   : UsingJSP
    Created on : Jun 26, 2020, 9:22:29 AM
    Author     : dipen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Illustrate the use of JSP</title>
    </head>
    <body>
        <%
            for(int i =1; i<=5; i++)
                out.println("Illustration for the use of JSP.<br>");
        %>
    </body>
</html>
