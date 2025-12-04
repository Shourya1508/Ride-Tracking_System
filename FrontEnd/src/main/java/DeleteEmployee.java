
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.DbConnection;

/**
 * Servlet implementation class DeleteEmployee
 */
@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

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
    	
    	HttpSession ses = request.getSession();
    	int user_id = (int)ses.getAttribute("USER_ID");
         
    	String emp = request.getParameter("id");
    	
    	String apiURL = "http://localhost:9091/delete" + "/" + user_id + "/" + emp;
    	
    	try {
    		
    		URI apiURI = URI.create(apiURL);
    		
    		HttpClient httpClient = HttpClient.newHttpClient();
    		
    		HttpRequest httpRequest = HttpRequest.newBuilder()
    				.uri(apiURI)
    				.header("Content-Type","application/json")
    				.POST(HttpRequest.BodyPublishers.noBody())
    				.build();
    		
    		HttpResponse<String> res = httpClient.send(httpRequest, BodyHandlers.ofString());
    		
    		if(res.statusCode() == 200) {
    			
    			request.setAttribute("deleted", true);
    			request.getRequestDispatcher("ListDetails").forward(request, response);
    		}
    		else {
    			System.out.println("Unable to delete");
    			request.getRequestDispatcher("userDashboard.jsp").forward(request, response);
    		}
    		
    		
    	}catch(IOException | InterruptedException e) {
    		e.printStackTrace();
    		System.out.println("Unable to Delete");
    	}
    	
//    	try (Connection con = DbConnection.getConnection()) {
//    	    // Retrieve the mast_code first
//    	    PreparedStatement ps = con.prepareStatement("select mast_code from employee_master where emp_id =? ");
//    	    ps.setString(1, emp);
//    	    ResultSet rs = ps.executeQuery();
//    	    int mast = 0;
//    	    if (rs.next()) {
//    	        mast = rs.getInt("mast_code");
//    	    }
//
//    	    // Now delete from employee_detail
//    	    PreparedStatement ps2 = con.prepareStatement("delete from employee_detail where emp_code = ?");
//    	    ps2.setInt(1, mast);
//    	    ps2.executeUpdate();
//
//    	    // Finally, delete from employee_master
//    	    PreparedStatement ps1 = con.prepareStatement("delete from employee_master where emp_id = ? ");
//    	    ps1.setString(1, emp);
//    	    ps1.executeUpdate();
//
//    	    // Redirect to the userDashboard.jsp after successful deletion
//    	    response.sendRedirect("ListDetails");
//    	} catch (SQLException e) {
//    	    e.printStackTrace();
//    	}
		
	}

}
