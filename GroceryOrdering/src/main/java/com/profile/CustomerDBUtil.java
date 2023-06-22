package com.profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;




public class CustomerDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//login validation
	public static boolean validate(String userName, String password ) {
		boolean check = false;
		
		try{
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "Select * from customer where userName = '"+userName+"' and password = '"+password+"' " ;
			rs = stmt.executeQuery(sql);
			check = rs.next();
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return check;			
			
	}
	
	//displaying user details
	public static List<customerProfile> details(String userName,String password){
		
		ArrayList<customerProfile> cus = new ArrayList<>();
		
		//validate
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from online_grocery_ordering_system.customer where userName='"+userName+"' and password= '"+password+"'";
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String address = rs.getString(4);
				String email = rs.getString(5);
				String telNo = rs.getString(6);
				String gender = rs.getString(7);
				String un = rs.getString(8);
				String pass = rs.getString(9);
				
				customerProfile c = new customerProfile(id,firstName,lastName,address,email,telNo,gender,un,pass);
				
				cus.add(c);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return cus;
	}
	
	//adding payment methods
	public static boolean addpay(String cardNo,String type,String pin){
		
		boolean isSuccess = false;
		
		
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into paymentmethod values('"+type+"','"+cardNo+"','"+pin+"')";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	//updating card information
	public static boolean updateProfile(String userName,String pw,String Fname,String Lname,String Address,String email,String tel,String gender ) {
		
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "update customer set firstName='"+Fname+"',lastName='"+Lname+"',address='"+Address+"',email='"+email+"',telephoneNumber='"+tel+"',gender='"+gender+"' where userName ='"+userName+"' and password = '"+pw+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	//deleting card information
	public static boolean delete(String cardNo) {
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "delete from paymentmethod where cardNo='"+cardNo+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
}
