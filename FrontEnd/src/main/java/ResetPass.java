
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
 * Servlet implementation class ResetPass
 */
@WebServlet("/ResetPass")
public class ResetPass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResetPass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public boolean passValidation(String s) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";

		return s.matches(regex);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

			response.setHeader("X-XSS-Protection", "1; mode=block");
			response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
			response.setHeader("X-Content-Type-Options", "nosniff");
			response.setHeader("X-Frame-Options", "DENY");

			HttpSession se = request.getSession(true);

			int user_id = (int) se.getAttribute("USER_ID");
			String password = request.getParameter("set_pass");

			String confirmPass = request.getParameter("set_con_pass");


				JSONObject jsonObject = new JSONObject();
				jsonObject.put("password", password);
				jsonObject.put("confirm_password", confirmPass);
				
				String token="";
				Cookie [] cookies = request.getCookies();
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("Authorization")) {
						token = cookie.getValue();
					}
				}
				
				System.out.println("Resettoken: "+token);

				String apiURL = "http://localhost:9091/reset" + "/" + user_id;

				try {

					URI apiURI = URI.create(apiURL);

					HttpClient httpClient = HttpClient.newHttpClient();

					HttpRequest httpRequest = HttpRequest.newBuilder().uri(apiURI)
							.headers("Content-Type", "application/json")
							.header("Authorization", token)
							.POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString())).build();

					HttpResponse<String> res = httpClient.send(httpRequest, BodyHandlers.ofString());
					if (res.statusCode() == 200) {
						System.out.println("Reset Status code:" + res.statusCode());
						request.getRequestDispatcher("userDashboard.jsp").forward(request, response);
					} else {
						request.setAttribute("error", "Error in setting Password");
						request.getRequestDispatcher("Reset.jsp").forward(request, response);
					}

				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
					System.out.println("Unable to reset Password");
				}
			}
		}

