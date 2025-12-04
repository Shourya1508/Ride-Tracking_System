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
    if(request.getAttribute("emailCh") !=null && (Boolean)request.getAttribute("emailCh") == true){
    request.setAttribute("emailChanged", true);
    }

String token ="";
Cookie [] cookies = request.getCookies();
for(Cookie cookie : cookies){
	if(cookie.getName().equals("Authorization")){
        cookie.setMaxAge(0); // Setting max age to 0 makes the cookie expire
    	cookie.setPath("/");
        response.addCookie(cookie);
        break;
	}
}

    HttpSession se = request.getSession(false);
    if (se != null) {
        se.invalidate();
    }
    // Redirect to the login page or any other destination
    

    
    request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
%>
</body>
</html>