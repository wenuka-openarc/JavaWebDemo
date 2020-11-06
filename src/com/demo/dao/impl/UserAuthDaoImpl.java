package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.dao.UserAuthDao;
import com.demo.domain.User;
import com.demo.domain.UserCredentials;

public class UserAuthDaoImpl implements UserAuthDao {

	private final String USER_CREDENTIALS_INSERT_SQL_QUERY = "INSERT INTO user_credentials(USER_ID,USERNAME,PASSWORD) VALUES(?,?,?)"; 
	private final String USER_CREDENTIALS_SELECT_SQL = "SELECT UCID,USER_ID,USERNAME,PASSWORD FROM User WHERE USER_ID=?" ;
	
	@Override
	public void insertUserCredentials(Connection conn , UserCredentials credentials , long userId ) throws SQLException {
		PreparedStatement ps = null;
		ps = conn.prepareStatement(USER_CREDENTIALS_INSERT_SQL_QUERY);
		ps.setLong(1, userId);
		ps.setString(2, credentials.getUserName());
		ps.setString(3, credentials.getPassword());
		ps.execute();
		System.out.println("insertUser => " + ps.toString());
	}

	@Override
	public UserCredentials getUserCredentials(Connection conn) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
	
		ps = conn.prepareStatement(USER_CREDENTIALS_SELECT_SQL);
		rs = ps.executeQuery();
		System.out.println("retriveUsers => " + ps.toString());
		
		UserCredentials credentials = new UserCredentials();
		
		while (rs.next()) {
			credentials.setCredentialId(rs.getLong("UCID") );
			credentials.setUserId(rs.getLong("USER_ID"));
			credentials.setPassword(rs.getString("PASSWORD"));
			credentials.setUserName(rs.getString("USERNAME"));
		}

		return credentials;

	}

}
