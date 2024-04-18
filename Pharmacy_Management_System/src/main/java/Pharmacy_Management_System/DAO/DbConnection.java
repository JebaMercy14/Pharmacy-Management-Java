package Pharmacy_Management_System.DAO;


import java.sql.*;

public class DbConnection {
	private static final String url="jdbc:mysql://localhost:3306/Pharmacy_Management_System";
	private static final String userName="root";
	private static final String  password="root";
	 public static Connection getConnection() throws SQLException{
		 return DriverManager.getConnection(url, userName, password);
	 }

}
