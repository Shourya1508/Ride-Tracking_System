
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

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
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
//	private String Email_id;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

    
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		   response.setHeader("X-XSS-Protection", "1; mode=block");
	        response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
	        response.setHeader("X-Content-Type-Options", "nosniff");
	        response.setHeader("X-Frame-Options", "DENY");
		
		String email = request.getParameter("email_id");
		String password = request.getParameter("pass");
		System.out.println("****"+email+"**"+password);
		HttpSession session = request.getSession(true);
		session.setAttribute("userEmail", email);
		
//		EmployeeDetails ed = new EmployeeDetails();
		
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", email);
		jsonObject.put("password", password);
		
		String url = "http://localhost:9091/authenticate";
		
		try {
		
		URI api_uri =  URI.create(url);
		
			
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpRequest httpReq = HttpRequest.newBuilder()
				.uri(api_uri)
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString()))
				.build();
		
		HttpResponse<String> res = httpClient.send(httpReq, BodyHandlers.ofString());
		System.out.println("Login Status code:"+res.statusCode());
		
		if(res.statusCode() != 200) {
			
			request.setAttribute("error", "Invalid email or password");
			request.setAttribute("setFocus","email_ID");
			request.setAttribute("email", email);
			request.setAttribute("password",password);
			
			request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
		}
		else {
		  
			String responseBody = res.body();
			
			JSONObject jsonRes = new JSONObject(responseBody);
			String token = jsonRes.getString("token");
			
			Cookie tokenCookie = new Cookie("Authorization", "Bearer+" + token);
			tokenCookie.setPath("/");
			tokenCookie.setMaxAge(7 * 24 * 60 * 60);
			tokenCookie.setHttpOnly(true);
			response.addCookie(tokenCookie);
			
			
			try(Connection con = DbConnection.getConnection()){
				PreparedStatement ps = con.prepareStatement("select user_id from user_details where email = ?");
				ps.setString(1, email);
				ResultSet rs = ps.executeQuery();
				
				int id = 0;
				while(rs.next()) {
					
					id = rs.getInt("user_id");
					session.setAttribute("USER_ID", id);
					System.out.println("ID :"+id);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		request.setAttribute("loggedIn", true);	
		request.getRequestDispatcher("userDashboard.jsp").forward(request, response);
		}
		
		}catch(IOException | InterruptedException e) {
			e.printStackTrace();
			System.out.println("Unable to call /Login Api");
		}
//		try(Connection con = DbConnection.getConnection()){
//		PreparedStatement ps1 = con.prepareStatement("select user_id from user_master where email = ? and pass = ? ");
//
//		ps1.setString(1,email);
//		ps1.setString(2,password);
//		ResultSet rs = ps1.executeQuery();
//	    int user_id=0;
//		if(rs.next()) {
////			setEmail(email);
////			ed.insert(email);
//			user_id = rs.getInt("user_id");
//			session.setAttribute("userID", user_id);
//            
//			PreparedStatement ps = con.prepareStatement("select * from user_master where user_id =?");
//			
//			ps.setInt(1, user_id);
//			ResultSet rs1 = ps.executeQuery();
//			
//			while(rs1.next()) {
//				
//				request.setAttribute("user_name", rs1.getString("user_name"));
//				request.setAttribute("user_email", rs1.getString("email"));
//				request.setAttribute("user_number", rs1.getString("mobile_no"));	
//			}
//			
//			
//			
//			request.getRequestDispatcher("userDashboard.jsp").forward(request, response);
//		}
//		else {
//			request.setAttribute("error", "Invalid email or password");
//			request.setAttribute("setFocus","email_ID");
//			request.setAttribute("email", email);
//			request.setAttribute("password",password);
//			request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
//		}
//		
//		}catch(SQLException e) {
//			e.printStackTrace();
//			request.setAttribute("error","Invalid Credentials");
//			request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
//		}
		
		
		
	
		
	}


}
