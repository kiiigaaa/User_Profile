package test;


import java.sql.*;
import java.util.ArrayList;



public class test {

	public static void main(String[] args) {
		
		String fname ="aaa";
		String lname ="aaa";
		String address ="aaa";
		String email="a@a";
		String tel="123";
		String gender="aaaa";
		String un="kiga";
			
			boolean isSuccess = false;
			
			try {
				Connection con = Conn.getConnection();
				Statement stmt = con.createStatement();
				
				String sql = "update online_grocery_ordering_system.customer set firstName='"+fname+"',lastName='"+lname+"',address='"+address+"',email='"+email+"',telephoneNumber='"+tel+"',gender='"+gender+"' where userName ='"+un+"'";
				
				int rs = stmt.executeUpdate(sql);
				
				if(rs>0) {
					isSuccess = true;
				}else {
					isSuccess = false;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println(isSuccess);
}
}
