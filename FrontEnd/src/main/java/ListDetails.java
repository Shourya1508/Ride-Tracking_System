
import java.awt.Window.Type;
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
import java.util.ArrayList;
import java.util.List;
import com.google.gson.reflect.TypeToken;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import utils.DbConnection;

/**
 * Servlet implementation class ListDetails
 */
@WebServlet("/ListDetails")
public class ListDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET request here if needed (e.g., show a confirmation page)
        // ...
    	doPost(request, response);
    }
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
    	 response.setHeader("X-XSS-Protection", "1; mode=block");
         response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
         response.setHeader("X-Content-Type-Options", "nosniff");
         response.setHeader("X-Frame-Options", "DENY");
    	
		HttpSession session = request.getSession(true);
		int user_id = (int)session.getAttribute("USER_ID");
		System.out.println();
		List<List<String>> ans = new ArrayList<>();
		
		String token="";
		Cookie [] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("Authorization")) {
				token = cookie.getValue();
			}
		}
		
		System.out.println("UserUpdatetoken: "+token);
		
		String baseURL = "http://localhost:9091/allEmp";
		String apiURL = baseURL + "/" + user_id;
		
		try {
			
			URI apiURI = URI.create(apiURL);
			
			HttpClient httpClient = HttpClient.newHttpClient();
			
			HttpRequest httpRequest = HttpRequest.newBuilder()
					.uri(apiURI)
					.GET()
					.header("Authorization", token)
					.build();
			
			HttpResponse<String> res = httpClient.send(httpRequest, BodyHandlers.ofString());
//			System.out.println(res.statusCode());
			String apiResponse = res.body();
//			System.out.println(apiResponse);
			List<Employee> list = parseJsonResponse(apiResponse);
//			System.out.println(list);
			
			for(Employee e : list) {
				List<String> l1 = new ArrayList<String>();
				l1.add(e.getEmp_id());
				l1.add(e.getEmp_name());
				l1.add(e.getDesignation());
				l1.add(e.getDepartment());
				l1.add(e.getJoined_date());
				l1.add(e.getSalary());
				l1.add(e.getAddressline1());
				l1.add(e.getAddressline2());
				l1.add(e.getCity());
				l1.add(e.getState());
				l1.add(e.getCountry());
				
				ans.add(l1);
			}
			
			request.setAttribute("displayList", ans);
			
			request.getRequestDispatcher("Display.jsp").forward(request, response);
			
			
		}catch(IOException | InterruptedException e) {
			e.printStackTrace();
			System.out.println("Unable to fetch Employees");
		}
		
	}
    
    private List<Employee> parseJsonResponse(String responsebody){
    	
    	Gson gson = new Gson(); 
    	java.lang.reflect.Type listtype = new TypeToken<List<Employee>>() {}.getType();
    	List<Employee> emp = gson.fromJson(responsebody,listtype);
    	return emp;
    }

}
