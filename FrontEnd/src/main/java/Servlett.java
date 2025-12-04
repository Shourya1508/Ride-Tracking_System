

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.HttpURLConnection;
import java.net.URI;

import netscape.javascript.JSObject;
//import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Servlett
 */
@WebServlet("/Servlett")
public class Servlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean flag;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlett() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	public boolean nameValidation(String s) {
//		String regex = "^[a-z A-Z]+$";
//		return s.matches(regex);
//	}
//
//	public boolean emailValidation(String s) {
//		String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";
////    	System.out.println(s+"  ddfdfdf"+s.matches(regex));
//		return s.matches(regex);
//	}
//
//	public boolean passValidation(String s) {
//		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
//
//		return s.matches(regex);
//	}
//
//	public boolean numberValidation(String s) {
//		String regex = "^[6-9][0-9]{9}";
//		return s.matches(regex);
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String s1 = request.getParameter("status");
//		System.out.println(s1);	
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		    response.setHeader("X-XSS-Protection", "1; mode=block");
	        response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
	        response.setHeader("X-Content-Type-Options", "nosniff");
	        response.setHeader("X-Frame-Options", "DENY");
		
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("log")) {
				request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
			} else {
				String user = request.getParameter("username");
                request.setAttribute("user",user);
				String mob_no = request.getParameter("mob");
				 request.setAttribute("mob_no",mob_no);
				String Email = request.getParameter("email_");
				 request.setAttribute("email_id",Email);
				String pass = request.getParameter("pass");
				 request.setAttribute("pass",pass);
				String Cpass = request.getParameter("confirmpass");
				 request.setAttribute("Cpass",Cpass);
					
					  JSONObject jsonData = new JSONObject();
				        jsonData.put("user_name", user);
				        jsonData.put("email", Email);
				        jsonData.put("mobile", mob_no);
				        jsonData.put("password", pass);
				        jsonData.put("confirm_password", Cpass);
				        // Add other form fields to the JSON object as needed

				        // Make API call with the JSON data
				        String apiUrl = "http://localhost:9091/signUp";
				        try {
				        	
				            URI apiUri = URI.create(apiUrl);
				            
				            HttpClient httpClient =  HttpClient.newHttpClient();
				            
				         HttpRequest httpRequest = HttpRequest.newBuilder()
				                 .uri(apiUri)
				                 .header("Content-Type", "application/json")
				                 .POST(HttpRequest.BodyPublishers.ofString(jsonData.toString()))
				                 .build();
				         
				         
				         HttpResponse<String> apiResponse = httpClient.send(httpRequest, BodyHandlers.ofString());

				            // Get the API response status code
				            int statusCode = apiResponse.statusCode();
				            System.out.println("Status code"+statusCode);
				            
				            if(statusCode == 208) {
				            	request.setAttribute("error","Email already exists");
				            	request.getRequestDispatcher("UserRegistration.jsp").forward(request, response);;
				            }
				            else {
				            	
				            request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
				            }
				            
				        } catch (IOException | InterruptedException e) {
				            e.printStackTrace();
				            System.out.println("Didn't call the api");
				        }


					
			        } 
			    }

					
				}
				
			
		
	}

