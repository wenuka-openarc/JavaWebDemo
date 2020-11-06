package com.demo.domain;

public class UserCredentials {
	
	
	private long  	credentialId ;
	private long   	userId ;
	private String 	userName ;
	private String 	password ;
	
	public UserCredentials() {
		super();
	}

	public UserCredentials(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserCredentials [userName=" + userName + ", password=" + password + "]";
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(long credentialId) {
		this.credentialId = credentialId;
	}
	
	
	

}
