package sampleTestExecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseConnection {
	public static void main(String[] args) throws SQLException {
		
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection(sqlUrl, username, password);
		Statement stmt = conn.createStatement();
		ResultSet resultSet = stmt.executeQuery("query");
		while(resultSet.next())
		{
			String browser = resultSet.getString(1);
			String url = resultSet.getString(2);
			String uname = resultSet.getString(3);
			String pwd = resultSet.getString(4);
			
		}
	}
}
