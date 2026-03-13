package dao;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.GetConnection;
import pojo.LoginPojo;

public class LoginDao {
	LoginPojo loginPojo;

	public LoginDao(LoginPojo loginPojo) {
		super();
		this.loginPojo = loginPojo;
	}

	public boolean verifyLogin() {
		try {
			PreparedStatement statement = GetConnection.getConnection()
					.prepareStatement("select customer_name where customer_id = ? and password = SHA(?,256)");
			statement.setInt(1, loginPojo.getId());
			statement.setString(2, loginPojo.getPassword());

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				System.out.println("Success");
				return true;
			}

		} catch (FileNotFoundException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
