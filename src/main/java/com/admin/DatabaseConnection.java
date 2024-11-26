package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/payment";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "damith";

	private static Connection connection = null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("MySQL JDBC Driver not found.");
			e.printStackTrace();
		}
	}

	private DatabaseConnection() {
	}

	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			synchronized (DatabaseConnection.class) {
				if (connection == null || connection.isClosed()) {
					connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				}
			}
		}
		return connection;
	}
}
