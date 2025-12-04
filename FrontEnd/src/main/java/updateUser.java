
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse.BodySubscribers;
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
 * Servlet implementation class updateUser
 */
@WebServlet("/updateUser")
public class updateUser extends HttpServlet {
	private boolean flag;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateUser() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String act = request.getParameter("action");
		if(act.equals("back")) {
			request.getRequestDispatcher("userDashboard.jsp").forward(request, response);
		}
		else {
		
		response.setHeader("X-XSS-Protection", "1; mode=block");
		response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
		response.setHeader("X-Content-Type-Options", "nosniff");
		response.setHeader("X-Frame-Options", "DENY");



			HttpSession session = request.getSession(true);


			String user = request.getParameter("username");
			String mob_no = request.getParameter("mob");
			String Email = request.getParameter("email_");
			String pass = request.getParameter("pass");
			String Cpass = request.getParameter("confirmpass");


				int id = (int) session.getAttribute("USER_ID");
				
				
				String token="";
				Cookie [] cookies = request.getCookies();
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("Authorization")) {
						token = cookie.getValue();
					}
				}
				
				System.out.println("UserUpdatetoken: "+token);
				
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("user_name", user);
				jsonObject.put("mobile", mob_no);
				jsonObject.put("email", Email);
				jsonObject.put("password", pass);
				jsonObject.put("confirm_password", Cpass);

				String userid = Integer.toString(id);
				String baseURL = "http://localhost:9091/updateUser";
				String apiUrl = baseURL + "/" + userid;

				try {

					URI apiURI = URI.create(apiUrl);

					HttpClient httpClient = HttpClient.newHttpClient();

					HttpRequest httpRequest = HttpRequest.newBuilder().uri(apiURI)
							.header("Content-Type", "application/json")
							.header("Authorization", token)
							.POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString()))
							.build();

					HttpResponse<String> res = httpClient.send(httpRequest, BodyHandlers.ofString());
					System.out.println("User update status code :" + res.statusCode());
					
					if(res.statusCode() == 202) {
						request.setAttribute("emailCh", true);
						request.setAttribute("emailChanged", true);
						request.getRequestDispatcher("LogOut.jsp").forward(request, response);
					}
					else {
						request.setAttribute("userUp", true);
					request.getRequestDispatcher("userDashboard.jsp").forward(request, response);
					}

				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
					System.out.println("Unable to Update User Data");
				}
			}
	}
		}
	

