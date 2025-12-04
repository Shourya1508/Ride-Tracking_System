<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log Out</title>
</head>
<body>
<%
    // Get the session and invalidate it
    HttpSession se = request.getSession(false);
    if (se != null) {
        se.invalidate();
    }
    // Redirect to the login page or any other destination
    
    response.sendRedirect("UserLogin.jsp");
%>
</body>
</html>