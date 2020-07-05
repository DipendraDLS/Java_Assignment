<%-- 
    Document   : Display10Times
    Created on : Jun 26, 2020, 9:13:20 AM
    Author     : dipen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Address 10 Times</title>
    </head>
    <body>
        <%
            for(int i = 1; i<=10; i++)
            {
                out.println("Tribhuvan University<br>");
            }
        %>
    </body>
</html>
