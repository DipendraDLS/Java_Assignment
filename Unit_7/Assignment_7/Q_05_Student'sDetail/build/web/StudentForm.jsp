<%-- 
    Document   : StudentForm
    Created on : Jun 26, 2020, 9:26:23 AM
    Author     : dipen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Form.</title>
    </head>
    <body>
        <h1>Fill up the form!</h1>
        <form action="PrintDetail.jsp" method="POST">
            
            Name: <input type="text" name="name"><br><br>
            Roll No.: <input type="text" name="roll"><br><br>
            Address: <input type="text" name="address"><br><br>
            <input type="submit" value="Submit">
            
        </form>
    </body>
</html>
