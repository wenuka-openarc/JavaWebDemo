package com.demon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.domain.UserCredentials;


@WebServlet("/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login Servlet ");
		
		String error = null ;
		
		String userName = request.getParameter("UserName");
		String password = request.getParameter("Password");
		
		if(userName != null  && password != null) {
			
			UserCredentials credentials = new UserCredentials(userName, password);
			
			
			if(credentials.getUserName().equals("wenuka") && credentials.getPassword().equals("123") ) {
				
				System.out.println(credentials);
				
				HttpSession  session = request.getSession();
				
				session.setAttribute("user_name", credentials.getUserName() );
				
				response.sendRedirect("home");
				
				//request.getRequestDispatcher("/Home.jsp").forward(request, response);
				
			}else {
				error = "UserName or Password incorrect";
			}
		}else {
			error = "invalid UserName or Password";
		}
		
		if(error != null) {
			request.setAttribute("error", error);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
		
	}

}
