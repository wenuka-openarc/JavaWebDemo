package com.demo.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.demo.connections.JDBCConnection;
import com.demo.dao.UserAuthDao;
import com.demo.dao.impl.UserAuthDaoImpl;
import com.demo.domain.UserCredentials;
import com.demo.service.UserAuthService;

public class UserAuthServiceImpl implements UserAuthService{

	private UserAuthDao userAuthDao ;
	
	public UserAuthDao getUserAuthDao() {
		return userAuthDao;
	}

	public void setUserAuthDao(UserAuthDao userAuthDao) {
		this.userAuthDao = userAuthDao;
	}
	
	public UserAuthServiceImpl() {
		userAuthDao = new UserAuthDaoImpl() ;
	}
	
	
	@Override
	public void insertUserCredentials(UserCredentials credentials) {
		
	}


	@Override
	public UserCredentials getUserCredentials(UserCredentials userAuth) {
		
		Connection conn = null;
		try {
			conn = JDBCConnection.getConnection();
			if (conn != null) {
				conn.setAutoCommit(false);
				UserCredentials credentials = getUserAuthDao().getUserCredentials(conn , userAuth.getUserName());
				conn.commit();
				return credentials ;
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean userAuthentication(UserCredentials userAuth) {
		UserCredentials credentials = getUserCredentials(userAuth);
		if( credentials != null && credentials.getUserName().equals(userAuth.getUserName()) && credentials.getPassword().equals(userAuth.getPassword()) ) {
			return true ;	
		}
		return false ;
	}
	

}
