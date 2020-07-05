<%-- 
    Document   : PrintDetail
    Created on : Jun 26, 2020, 9:33:47 AM
    Author     : dipen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Print Student Details.</title>
    </head>
    <body>
        
        <h1>Student Details!</h1>
        Name: <%= request.getParameter("name") %><br>
        Roll No.: <%= request.getParameter("roll") %><br>
        Address: <%= request.getParameter("address") %><br>
        
    </body>
</html>
