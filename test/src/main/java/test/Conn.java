package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	
	private static String url = "jdbc:mysql://localhost:3306/online_grocery_ordering_system";
	private static String username = "root";
	private static String password = "kishen00!!!";
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,username,password);
			
		}catch(Exception e){
			System.out.println("Database connetion failed!!!");
		}
		
		return con;
	}
	

}
