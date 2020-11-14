package com.demo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.demo.domain.User;
import com.demo.exceptions.DemoExceptions;

public interface UserService {

	void insertUser(User p) throws DemoExceptions ;
	List<User> retriveUsers() ;
	User retriveUser(long id) ;
	
}
