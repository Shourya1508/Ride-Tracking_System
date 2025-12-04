<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
if(request.getAttribute("errorMessage")!=null){ %>
<h2 style="color: red;"><%=request.getAttribute("errorMessage") %> </h2>	
<% } else { %>
<%= request.getAttribute("message") %>
<% } %>


</body>
</html>