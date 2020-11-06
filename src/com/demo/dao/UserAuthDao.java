package com.demo.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.demo.domain.UserCredentials;

public interface UserAuthDao {

	public void insertUserCredentials(Connection conn , UserCredentials credentials , long userId) throws SQLException; 
	public UserCredentials getUserCredentials(Connection conn) throws SQLException ;
	
}
