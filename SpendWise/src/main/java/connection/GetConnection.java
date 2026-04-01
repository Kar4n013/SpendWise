package connection;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dbInfo.DataReader;

public class GetConnection {
	public static Connection getConnection() throws FileNotFoundException, ClassNotFoundException {
		
		String[] db_info = DataReader.dataReader();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db_info[2],db_info[0],db_info[1]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}
	
}
