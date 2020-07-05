<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Demo</title>
    </head>
    <body>
        <h1>Division</h1>
        <%
            if(true)
                throw new RuntimeException("Hello error page!");
        %>
    </body>
</html>
