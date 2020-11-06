package com.demon.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.domain.User;
import com.demo.domain.UserCredentials;
import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;


@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserRegistration() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserService service = new UserServiceImpl();
		User user = new User() ;
		
		user.setfName("abc");
		user.setlName("cdf");
		user.setEmail("abc@abc.abc");
		user.setUserType("user");
		user.setDob( new Date() );
		
		UserCredentials  credentials = new UserCredentials();
		credentials.setUserName("abcd");
		credentials.setPassword("123");
		user.setUserCredentials(credentials);
		
		service.insertUser( user );
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
	}

}
