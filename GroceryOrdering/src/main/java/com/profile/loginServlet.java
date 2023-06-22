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


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("uname");
		String password = request.getParameter("pw");
		
		List cusDetails = CustomerDBUtil.details(username, password);
		
		try {
			boolean isTrue = CustomerDBUtil.validate(username, password);
			
			//validation
			if(isTrue == true) {
				out.println("<script type ='text/javascript'>");
				out.println("alert('Login Success!');");
				RequestDispatcher dis = request.getRequestDispatcher("dashboard.jsp");
				dis.forward(request, response);
			}else {
				out.println("<script type ='text/javascript'>");
				out.println("alert('invalid login!');");
				out.println("location = 'login.jsp';");
				out.println("</script>");
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		HttpSession session = request.getSession();
		session.setAttribute("un", username);
		session.setAttribute("pw", password);
		
		session.setAttribute("cusDetails", cusDetails);
		
		
	}

}
