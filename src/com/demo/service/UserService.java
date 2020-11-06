package com.demo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.demo.domain.User;

public interface UserService {

	void insertUser(User p) ;
	List<User> retriveUsers() ;
	User retriveUser(long id) ;
	
}
