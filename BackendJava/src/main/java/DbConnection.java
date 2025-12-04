

/**
 *
 * @author postgresqltutorial.com
 */

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection {

	public static Connection getConnection() {

		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String userName = "postgres";
		String password = "root";

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, userName, password);

			System.out.println("done...");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

    /**
     * @param args the command line arguments
     */


