
import java.io.IOException;
import java.lang.reflect.Type;
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
import org.w3c.dom.html.HTMLPreElement;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import utils.DbConnection;

/**
 * Servlet implementation class updateEmployee
 */
@WebServlet("/updateEmployee")
public class updateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean nameValidation(String s) {
		String regex = "^[a-z A-Z]+$";
		return s.matches(regex);
	}

	public boolean salaryValidation(String s) {
		try {
			int n = Integer.parseInt(s);
			if (n >= 0) {
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 *      /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub


			int mast = 0;
			String emp_id="";
			 emp_id = request.getParameter("id");
			 HttpSession ses = request.getSession(true);
			 ses.setAttribute("Employee_id", emp_id);
			 request.setAttribute("status1","1");
			 System.out.println("During not error employeeid:"+(String)request.getAttribute("status1")+" "+(String)ses.getAttribute("Employee_id"));
			 String st = request.getParameter("status");
			 request.setAttribute("ST", st);

				
				String token="";
				Cookie [] cookies = request.getCookies();
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("Authorization")) {
						token = cookie.getValue();
					}
				}
				
				System.out.println("UpdateEmptoken: "+token);

			String baseURL = "http://localhost:9091/editEmployee";
			String apiURL = baseURL + "/" + emp_id;

			try {

				URI apiURI = URI.create(apiURL);

				HttpClient httpClient = HttpClient.newHttpClient();

				HttpRequest httpRequest = HttpRequest.newBuilder()
						.uri(apiURI)
						.GET()
						.header("Authorization", token)
						.build();

				HttpResponse<String> res = httpClient.send(httpRequest, BodyHandlers.ofString());

				String body = res.body();

				Employee employee = parseApiResponse(body);
//				System.out.println();
				System.out.println();
				System.out.println("BEFORE ERROR UPDATE:"+employee.getMast_code());

				mast = employee.getMast_code();
				request.setAttribute("emp_id", emp_id);
				
				request.setAttribute("mast", mast);	
                request.setAttribute("flg", "false");
				request.getRequestDispatcher("UpdateEmployee.jsp").forward(request, response);

			} catch (IOException | InterruptedException e) {

				e.printStackTrace();
			}
		}


	private Employee parseApiResponse(String rBody) {

		Gson gson = new Gson();
		Employee emp = gson.fromJson(rBody, Employee.class);
		return emp;
	}
}
