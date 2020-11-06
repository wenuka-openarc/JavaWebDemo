package com.demo.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection {

	private static final String DRIVER_NAME =  "com.mysql.cj.jdbc.Driver" ; // "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/javatraining?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "wenuka123";

	private static Connection connection;

	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not found");
		}
	}

	public static Connection getConnection() throws SQLException {
		connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		return connection;
	}

	public static void closeConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}

	public static void closePrepaerdStatement(PreparedStatement stmt) throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
	}

	public static void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}

}
