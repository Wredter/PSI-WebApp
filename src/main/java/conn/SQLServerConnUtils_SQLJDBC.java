package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnUtils_SQLJDBC {
// Connect to SQLServer
// (Using JDBC Driver: SQLJDBC) 
	public static Connection getH2ServerConnection_JDBC() throws ClassNotFoundException, SQLException {

		// Note: Change the connection parameters accordingly.

		String hostName = "localhost";
		String database = "test";
		String userName = "sa";
		String password = "";
		return getH2ServerConnection_JDBC(hostName, database, userName, password);
	}

//Connect to SQLServer, using SQLJDBC Library.
	private static Connection getH2ServerConnection_JDBC(String hostName, String database,
			String userName, String password) throws ClassNotFoundException, SQLException {

		// Declare the class Driver for SQLServer DB
		// This is necessary with Java 5 (or older)
		// Java6 (or newer) automatically find the appropriate driver.
		// If you use Java> 5, then this line is not needed.
		Class.forName("org.h2.Driver");
		String connectionURL = "jdbc:h2:tcp://" + hostName + "/~/" + database;
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}
}