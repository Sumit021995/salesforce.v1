package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {

//	public static void main(String[] args) throws Exception {
//		DatabaseUtility db=new DatabaseUtility();
//		db.connectToDatabase("jdbc:mysql://127.0.0.1:3306/salesForce", "root", "Infocus4999@123");
//		String UN=db.fetchDataFromTable(3);
//		String PWD=db.fetchDataFromTable(4);
//		System.out.println(UN);
//		System.out.println(PWD);
////		db.updateDataIntoTable("admin23456", "admin23456");
//		db.closeDBConnection();
//	}
	
	Connection con;
	public void connectToDatabase(String dbUrl, String UN, String PWD) throws Exception
	{
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(dbUrl, UN, PWD);
	}
	
	public void updateDataIntoTable(String username, String password) throws Exception
	{
		String query="insert into credential (username,password) values (?, ?);";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, password);
		int rs=ps.executeUpdate();
		if(rs>0)
		{
			System.out.println("A new row inserted");
		}
		else
		{
			System.out.println("duplicate row already exists");
		}
	}
	
//	public String fetchDataFromTable(int columnNo) throws Exception
//	{
//		Statement stmt = con.createStatement();
//		ResultSet resultSet = stmt.executeQuery("select * from commondata");
//		while(resultSet.next())
//		{
//			return resultSet.getString(columnNo);			
//		}
//		return null;
//		
//	}
	
	public String fetchDataFromTable(int columnNo) throws Exception {
		PropertiesUtility pUtil = new PropertiesUtility();
	    if (con == null || con.isClosed()) {
	        System.out.println("⚠️ Connection lost. Re-establishing connection...");
	        String dbURL = pUtil.fetchValueFromPropertiesFile("mysqlURL");
	        String dbUN = pUtil.fetchValueFromPropertiesFile("mysqlUN");
	        String dbPWD = pUtil.fetchValueFromPropertiesFile("mysqlPWD");
	        connectToDatabase(dbURL, dbUN, dbPWD);  // Re-establish connection
	    }

	    Statement stmt = con.createStatement();
	    ResultSet resultSet = stmt.executeQuery("SELECT * FROM commondata");
	    
	    while (resultSet.next()) {
	        return resultSet.getString(columnNo); 
	    }
	    return null;
	}
	
	public void closeDBConnection() {
	    try {
	        if (con != null && !con.isClosed()) {
	            con.close();
	            System.out.println("✅ Database connection closed successfully.");
	        }
	    } catch (SQLException e) {
	        System.out.println("❌ Error while closing DB connection: " + e.getMessage());
	    }
	}
	
//	public void closeDBConnection() throws Exception
//	{
//		con.close();
//		System.out.println("DB closed");
//	}
}
//public class DatabaseUtility {
//	Connection conn;
//	
//	public void getDBConnection(String url,String uname,String password) throws SQLException
//	{
//		try {
//			Driver driver=new Driver();
//			DriverManager.registerDriver(driver);
//			conn= DriverManager.getConnection(url, uname, password);
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("connection not established");
//		}
//	}
//	public void closeDBConnection()
//	{
//		try {
//			conn.close();
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	public ResultSet executeSelectQuery(String query)
//	{
//		ResultSet result=null;
//		try {
//			Statement stmt = conn.createStatement();
//			result = stmt.executeQuery(query);
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}
//		return result;
//	}
//	public int executeNonSelectQuery(String query)
//	{
//		
//		int result=0;
//		try {
//			Statement stmt = conn.createStatement();
//			result = stmt.executeUpdate(query);
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}
//		return result;
//	}
//	public String fetchDataFromTable(int columnNo) throws Exception
//	{
//		String query="select * from commondata;";
//		PreparedStatement ps = conn.prepareStatement(query);
////		ResultSet result = statement.executeQuery(query);
//		ResultSet result = ps.executeQuery();
//		String resultData=null;
//		while(result.next())
//		{
//			resultData = result.getString(columnNo);
//		}
//		return resultData;
//	}
//
//	
//	
//	public void connectToDatabase(String dbUrl, String UN, String PWD) throws Exception
//	{
//			Driver driverRef = new Driver();
//			DriverManager.registerDriver(driverRef);
//			conn = DriverManager.getConnection(dbUrl, UN, PWD);	
//	}
	
//	public void updateDataIntoTable(String browser, String url,String uname, String password) throws Exception
//	{
//		String query="insert into commondata (browser,url,uname,password) values (?, ?, ?, ?);";
////		statement = con.prepareStatement(query);
//		ps.setString(0, browser);
//		ps.setString(1, url);
//		ps.setString(2, uname);
//		ps.setString(3, password);
////		int rs=statement.executeUpdate(query);
//		if(rs>0)
//		{
//			System.out.println("A new row inserted");
//		}
//		else
//		{
//			System.out.println("duplicate row already exists");
//		}
//	}
	
//	public String fetchDataFromTable(int columnNo) throws Exception
//	{
//		String query="select * from commondata;";
//		ps = con.prepareStatement(query);
////		ResultSet result = statement.executeQuery(query);
//		ResultSet result = ps.executeQuery();
//
//		while(result.next())
//		{
//			return result.getString(columnNo);
//		}
//		return null;
//	}
	
//	public void closeDatabaseConnection() throws Exception
//	{
////		statement.close();
//		ps.close();
//		con.close();
//		System.out.println("DB closed");
//	}

//}
