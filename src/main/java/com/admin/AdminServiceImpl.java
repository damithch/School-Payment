package com.admin;

import com.admin.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {

	@Override
	public boolean validateAdmin(Admin admin) {
		boolean isValid = false;
		String query = "SELECT * FROM admin_data WHERE username = ? AND password = ?";

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, admin.getUsername());
			statement.setString(2, admin.getPassword());

			try (ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					isValid = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isValid;
	}
}
