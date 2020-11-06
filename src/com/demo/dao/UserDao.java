package com.demo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.demo.domain.User;

public interface UserDao {

	User insertUser(Connection conn , User p) throws SQLException;
	List<User> retriveUsers(Connection conn ) throws SQLException;
	User retriveUser(Connection conn , long id) throws SQLException;
	void updateUserFirstName(Connection conn , User User) throws SQLException;
	void deleteAllRecords(Connection conn ) throws SQLException;
	void deleteUser(Connection conn , int id) throws SQLException;

}
