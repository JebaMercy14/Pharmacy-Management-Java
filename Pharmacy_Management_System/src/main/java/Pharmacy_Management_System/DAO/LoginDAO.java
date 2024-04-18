package Pharmacy_Management_System.DAO;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.*;
import java.sql.SQLException;



public class LoginDAO {

	public static boolean loginvalidate(String login,String password) throws SQLException
	{
		String query="select * from login";
		Connection con=DbConnection.getConnection();	
		Statement statement=con.createStatement();
		ResultSet rs=statement.executeQuery(query);
		while (rs.next()) {
			if(rs.getString(1).equalsIgnoreCase(login)&& rs.getString(2).equalsIgnoreCase(password))
			{
				return true;
			}	
		
		}
		//rs.close();
		return false;
	}
}
