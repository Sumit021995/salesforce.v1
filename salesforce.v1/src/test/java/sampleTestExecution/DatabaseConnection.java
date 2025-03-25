package sampleTestExecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//import com.mysql.cj.jdbc.Driver;

import genericUtility.PropertiesUtility;

public class DatabaseConnection {
	public static void main(String[] args) throws Exception {
		
//		Driver driverRef = new Driver();
//		DriverManager.registerDriver(driverRef);
		PropertiesUtility pUtil = new PropertiesUtility();
		String mysqlURL = pUtil.fetchValueFromPropertiesFile("mysqlURL");
		String mysqlUN = pUtil.fetchValueFromPropertiesFile("mysqlUN");
		String mysqlPWD = pUtil.fetchValueFromPropertiesFile("mysqlPWD");
		Connection conn = DriverManager.getConnection(mysqlURL, mysqlUN, mysqlPWD);
		Statement stmt = conn.createStatement();
		ResultSet resultSet = stmt.executeQuery("select * from commondata");
		while(resultSet.next())
		{
			String browser = resultSet.getString(1);
			String url = resultSet.getString(2);
			String uname = resultSet.getString(3);
			String pwd = resultSet.getString(4);
			System.out.println(browser);
			System.out.println(url);
			System.out.println(uname);
			System.out.println(pwd);
			
		}
	}
}
