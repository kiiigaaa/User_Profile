package com.profile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String Fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String gender = request.getParameter("gender");
		String un = request.getParameter("un");
		String password = request.getParameter("password");
		
		boolean isTrue;
		
		isTrue = CustomerDBUtil.updateProfile(un, password, Fname, lname, address, email,tel,gender);
		List cusDetails = CustomerDBUtil.details(un, password);
		HttpSession session = request.getSession();
		session.setAttribute("cusDetails", cusDetails);
		if(isTrue ==true) {
			out.println("<script type ='text/javascript'>");
			out.println("alert('Planner Updated Successfully');");
			out.println("location = 'userProfile.jsp';");
			out.println("</script>");
		}
		if(isTrue == false){
			out.println("<script type ='text/javascript'>");
			out.println("alert('oops something wrog!!!');");
			out.println("location = 'error.jsp';");
			out.println("</script>");
		}
		
	}

}
