<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="utils.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees List</title>
</head>
<body>

<%

String Emp_name = null;
HttpSession s1 = request.getSession(true);
int id = (int)s1.getAttribute("userID");
try(Connection con = DbConnection.getConnection()){
	
	//PreparedStatement ps = con.prepareStatement("select *, count(*) as c from employee_master group by user_id having user_id= ?");
	PreparedStatement ps = con.prepareStatement("select * from employee_master where user_id= ?");
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()){
		

		Emp_name = rs.getString("emp_name");
		%>
		
		<h4><%=Emp_name%></h4>
		   
		    <form  method="post" action="UpdateEmployee.jsp" >
		    <button type="submit">Edit</button>
		    </form>
		    <br>
		    <button type="submit">Delete</button> 

		    <br>
<% 	}

	
}catch(SQLException e){
	e.printStackTrace();
}
%>







</body>
</html>