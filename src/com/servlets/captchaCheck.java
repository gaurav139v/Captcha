package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class captchaCheck
 */
@WebServlet("/captchaCheck")
public class captchaCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public captchaCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter wr = response.getWriter();		
		String str = null;
		
		String value = request.getParameter("val");
		String input = request.getParameter("input");
				
		if(value.equals(input)) {			
			str = "Correct Captcha!";		
			
		}else {			
			str = "Incorrect Captcha!";
		}
		
		String page="<html>"
				+ "<body>"
				+ "<center>"
				+ "<h1>"+str+"</h1><br>"
				+ "<a href=\"index.jsp\" style=\"margin-top:10px; text-decoration:none;\">Back</a>"
				+ "</center>"
				+ "</body>"
				+ "</html>";
		
		wr.println(page);				
	}

}
