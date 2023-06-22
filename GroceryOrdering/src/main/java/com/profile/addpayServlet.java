package com.profile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addpayServlet")
public class addpayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		String cardNo = request.getParameter("cardNo");
		String type = request.getParameter("ctype");
		String pin = request.getParameter("pin");
		
		boolean isTrue;
		isTrue = CustomerDBUtil.addpay(cardNo, type, pin);
		
		if(isTrue == true) {
			
			out.println("<script type ='text/javascript'>");
			out.println("alert('New Card Added!');");
			out.println("location = 'payMethodDetails.jsp';");
			out.println("</script>");
		}
		
	}

}
