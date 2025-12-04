

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import utils.DbConnection;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/EmployeeDetails")
public class EmployeeDetails extends HttpServlet {
//	private String Em; 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public boolean nameValidation(String s) {
    	String regex = "^[a-z A-Z]+$";
    	return s.matches(regex);
    }
    
    public boolean salaryValidation(String s) {
    	try {
    		int n = Integer.parseInt(s);
    		if(n>=0) {
    			return true;
    		}
    		else {
    			return false;
    		}
    	}catch(NumberFormatException e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    
//    public void insert(String s) {
//    	this.Em = s;
//    }
//    
//    public String getEm() {
//    	return Em;
//    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("back")) {
				request.getRequestDispatcher("userDashboard.jsp").forward(request, response);
			} else {
		
		    response.setHeader("X-XSS-Protection", "1; mode=block");
	        response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
	        response.setHeader("X-Content-Type-Options", "nosniff");
	        response.setHeader("X-Frame-Options", "DENY");
		
		
		String emp_id = request.getParameter("emp_id");
		request.setAttribute("emp_id",emp_id );
		String emp_name = request.getParameter("emp_name");
		request.setAttribute("emp_name", emp_name);
		String designation = request.getParameter("designation");
		 request.setAttribute("designation", designation);
		String department = request.getParameter("department");
		 request.setAttribute("department", department);
		String joined_date = request.getParameter("joined_date");
		request.setAttribute("joined_date",joined_date);
		String salary = request.getParameter("salary");
		request.setAttribute("salary", salary);
		String addressline1 = request.getParameter("addressline1");
		request.setAttribute("addressline1", addressline1);
		String addressline2 = request.getParameter("addressline2");
		request.setAttribute("addressline2", addressline2);
		String city = request.getParameter("city");
		 request.setAttribute("city", city);
		String state = request.getParameter("state");
		request.setAttribute("state", state);
		String country = request.getParameter("country");
		request.setAttribute("country", country);
		
		HttpSession session = request.getSession(true);
		

			   
			   int user_id = (int)session.getAttribute("USER_ID");
			   
				String token="";
				Cookie [] cookies = request.getCookies();
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("Authorization")) {
						token = cookie.getValue();
					}
				}
				
				System.out.println("AddEmptoken: "+token);
			   
			   JSONObject jsonObject = new JSONObject();
			   jsonObject.put("emp_id", emp_id);
			   jsonObject.put("emp_name", emp_name);
			   jsonObject.put("designation", designation);
			   jsonObject.put("department",department);
			   jsonObject.put("joined_date", joined_date);
			   jsonObject.put("salary", salary);
			   jsonObject.put("id", user_id);
			   jsonObject.put("addressline1", addressline1);
			   jsonObject.put("addressline2", addressline2);
			   jsonObject.put("city", city);
			   jsonObject.put("state", state);
			   jsonObject.put("country", country);
			   
			   
			   
			   String apiUrl = "http://localhost:9091/addEmployee";
			   
			   try {
				   
				   URI apiURI = URI.create(apiUrl);
				   
				   HttpClient httpClient = HttpClient.newHttpClient();
				   
				   HttpRequest httpRequest = HttpRequest.newBuilder()
						   .uri(apiURI)
						   .header("Content-Type", "application/json")
						   .header("Authorization", token)
						   .POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString()))
						   .build();
				   
				   HttpResponse<String> res = httpClient.send(httpRequest, BodyHandlers.ofString());
				   System.out.println("Add Employee status code :"+res.statusCode());
				   
				   if(res.statusCode() == 208) {
					   request.setAttribute("error", "Employee id already exists");
					   request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
				   }
				   else {  
					   request.setAttribute("empAdded", true);
				   request.getRequestDispatcher("userDashboard.jsp").forward(request, response);
				   }
				   
			   }catch(IOException | InterruptedException e) {
				   e.printStackTrace();
				   System.out.println("Unable to add employee");
			   }
			   
		   }
	}
}
}