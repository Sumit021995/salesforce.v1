package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseUtility {

	Connection con;
	PreparedStatement ps;
	
	public static void main(String[] args) throws Exception {
		DatabaseUtility db=new DatabaseUtility();
		db.connectToDatabase("jdbc:mysql://localhost:3306/rajat", "root", "mysql@1234");
		String UN=db.fetchDataFromTable("Admin", "username");
		String PWD=db.fetchDataFromTable("Admin", "password");
		System.out.println(UN);
		System.out.println(PWD);
//		db.updateDataIntoTable("admin23456", "admin23456");
		db.closeDBConnection();
	}
	
	public void connectToDatabase(String dbUrl, String UN, String PWD) throws Exception
	{
		con = DriverManager.getConnection(dbUrl, UN, PWD);
	}
	
	public void updateDataIntoTable(String username, String password) throws Exception
	{
		String query="insert into credential (username,password) values (?, ?);";
		ps = con.prepareStatement(query);
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
	
	public String fetchDataFromTable(String name, String column) throws Exception
	{
		String query="select * from credential where name=?";
		ps = con.prepareStatement(query);
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			return rs.getString(column);
		}
		return null;
	}
	
	public void closeDBConnection() throws Exception
	{
		ps.close();
		con.close();
		System.out.println("DB closed");
	}
}
