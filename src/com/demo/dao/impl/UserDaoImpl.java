package com.demo.dao.impl;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.dao.UserDao;
import com.demo.domain.User;


/**
 * SQL: create table User (ID bigint not null, EMAIL varchar(255), FIRST_NAME
 * varchar(255), JOINED_DATE date, LAST_NAME varchar(255), primary key (id))
 * This class is used to test CRUD operations on DB.
 * 
 * @author wenuka
 */


public class UserDaoImpl implements UserDao {
	
	public static final String INSERT_SQL_QUERY = "INSERT INTO User(FIRST_NAME,LAST_NAME,EMAIL,DATE_OF_BIRTH,USER_TYPE) VALUES(?,?,?,?,?)";
	public static final String UPDATE_SQL_QUERY = "UPDATE User SET FIRST_NAME=? WHERE ID=?";
	public static final String SELECT_SQL_QUERY = "SELECT ID,FIRST_NAME,LAST_NAME,EMAIL,DATE_OF_BIRTH,USER_TYPE FROM User WHERE ID=?";
	public static final String SELECT_ALL_SQL_QUERY = "SELECT ID,FIRST_NAME,LAST_NAME,EMAIL,DATE_OF_BIRTH,USER_TYPE FROM User";
	public static final String DELETE_SQL_QUERY = "DELETE FROM User WHERE ID=?";
	public static final String DELETE_ALL_SQL_QUERY = "DELETE FROM User";

	@Override
	public User insertUser(Connection conn,User user) throws SQLException {
		PreparedStatement ps = null;
		ps = conn.prepareStatement(INSERT_SQL_QUERY, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, user.getfName());
		ps.setString(2, user.getlName());
		ps.setString(3, user.getEmail());
		ps.setDate(4,  new Date( user.getDob().getTime() )   );
		ps.setString(5, user.getUserType());
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			user.setId(rs.getLong(1));
		}
		
		System.out.println("insertUser => " + ps.toString());
		
		return user ;
		
	}
	
	@Override
	public List<User> retriveUsers(Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> Users = new ArrayList<User>();
	
		ps = conn.prepareStatement(SELECT_ALL_SQL_QUERY);
		rs = ps.executeQuery();
		System.out.println("retriveUsers => " + ps.toString());
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getLong("ID"));
			user.setfName(rs.getString("FIRST_NAME"));
			user.setlName(rs.getString("LAST_NAME"));
			user.setEmail(rs.getString("EMAIL")); 
			user.setDob(rs.getDate("DATE_OF_BIRTH"));
			user.setEmail(rs.getString("USER_TYPE")); 
			Users.add(user);
		}

		return Users;
	}
	
	@Override
	public User retriveUser(Connection conn , long id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		User User = new User();
			ps = conn.prepareStatement(SELECT_SQL_QUERY);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			System.out.println("retriveUser => " + ps.toString());
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("ID"));
				user.setfName(rs.getString("FIRST_NAME"));
				user.setlName(rs.getString("LAST_NAME"));
				user.setEmail(rs.getString("EMAIL")); 
				user.setDob(rs.getDate("DATE_OF_BIRTH"));
				user.setEmail(rs.getString("USER_TYPE")); 
			}
		return User;
	}

	@Override
	public void updateUserFirstName(Connection conn, User User) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllRecords(Connection conn) throws SQLException {
		
		
	}

	@Override
	public void deleteUser(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}


}
