package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionManager {
	public static String url = "jdbc:mysql://localhost:3306/";
	public static String dbName = "newschema";
	public static String driver = "com.mysql.cj.jdbc.Driver";
	public static String userName = "Lorenzo";
	public static String password = "sistemi";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Connection conn = null;
		Class.forName(driver);
		
		conn = DriverManager.getConnection(url+dbName,userName,password);
		
		return conn;
	}
	
	public static void closeConnection(Connection c) throws SQLException{
		
		c.close();
	}
	
	public static ResultSet selectQuery(String query) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnection();
		
		Statement statement = conn.createStatement();
		
		ResultSet ret = statement.executeQuery(query);
		
		return ret;
	}
	
	public static int updateQuery(String query) throws ClassNotFoundException, SQLException{
		
		Connection conn = getConnection();
		
		Statement statement = conn.createStatement();
		
		int ret = statement.executeUpdate(query);
		conn.close();
		return ret;
	}
}
