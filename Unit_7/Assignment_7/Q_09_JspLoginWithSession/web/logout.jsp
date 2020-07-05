<%-- 
    Document   : logout
    Created on : Jun 28, 2020, 11:24:39 AM
    Author     : dipen
--%>

 <% session.invalidate(); %>
 <% response.sendRedirect("LoginForm.jsp"); %>