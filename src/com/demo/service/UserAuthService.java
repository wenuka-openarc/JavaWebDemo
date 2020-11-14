package com.demo.service;

import com.demo.domain.UserCredentials;

public interface UserAuthService {

	public void insertUserCredentials(UserCredentials credentials); 
	UserCredentials getUserCredentials(UserCredentials userAuth);
	boolean userAuthentication(UserCredentials userAuth);
	
}
