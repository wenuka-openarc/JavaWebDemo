package com.demo.service;

import com.demo.domain.UserCredentials;

public interface UserAuthService {

	public void insertUserCredentials(UserCredentials credentials); 
	public UserCredentials getUserCredentials() ;
	
}
