

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.google.gson.Gson;

/**
 * Servlet implementation class EditEmployee
 */
@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployee() {
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
	 *      
	 */

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setHeader("X-XSS-Protection", "1; mode=block");
		response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
		response.setHeader("X-Content-Type-Options", "nosniff");
		response.setHeader("X-Frame-Options", "DENY");

		String emp_id = request.getParameter("emp_id");
		String emp_name = request.getParameter("emp_name");

		request.setAttribute("status", "1");
		String designation = request.getParameter("designation");

		String department = request.getParameter("department");

		String joined_date = request.getParameter("joined_date");

		String salary = request.getParameter("salary");

		String addressline1 = request.getParameter("addressline1");

		String addressline2 = request.getParameter("addressline2");

		String city = request.getParameter("city");

		String state = request.getParameter("state");

		String country = request.getParameter("country");

		
		HttpSession ses = request.getSession(true);
//		System.out.println("Session Employee id :"+ses.getAttribute("Employee_id"));
		int id = (int)ses.getAttribute("USER_ID");
		int mast_code=0;
		
	
	    mast_code = Integer.parseInt(request.getParameter("code"));
	    ses.setAttribute("MAST", mast_code);
			

		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("emp_id", emp_id);
		jsonObject.put("emp_name", emp_name);
		jsonObject.put("designation", designation);
		jsonObject.put("department", department);
		jsonObject.put("joined_date", joined_date);
		jsonObject.put("salary", salary);
		jsonObject.put("id", id);
		jsonObject.put("addressline1", addressline1);
		jsonObject.put("addressline2", addressline2);
		jsonObject.put("city", city);
		jsonObject.put("state", state);
		jsonObject.put("country", country);

		String base1URL = "http://localhost:9091/updateEmp";
		String apiURL1 = base1URL + "/" + mast_code;
		
		try {

		URI api_2URI = URI.create(apiURL1);

		HttpClient httpClient2 = HttpClient.newHttpClient();

		HttpRequest httpRequest2 = HttpRequest.newBuilder().uri(api_2URI)
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString())).build();

		HttpResponse<String> res1 = httpClient2.send(httpRequest2, BodyHandlers.ofString());
		if (res1.statusCode() == 200) {
			request.setAttribute("empUpdated", true);
			request.getRequestDispatcher("ListDetails").forward(request, response);
		} else {
			request.getRequestDispatcher("userDashboard.jsp").forward(request, response);
		}

	} catch(IOException | InterruptedException e) {

		e.printStackTrace();
		System.out.println("Unable to update Employee Data");
	}


}
	

}

