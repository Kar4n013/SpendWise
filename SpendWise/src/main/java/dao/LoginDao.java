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
		System.out.println("Verifying");
		try {
			PreparedStatement statement = GetConnection.getConnection()
					.prepareStatement("select name from customer_details where customer_id = ? and password = SHA2(?,256)");
			System.out.println(loginPojo.getId());
			System.out.println(loginPojo.getPassword());
			
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
		System.out.println("Wrong");
		return false;
	}
//rahul123
}
