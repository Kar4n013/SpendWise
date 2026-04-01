package dbInfo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataReader {
	public static String[] dataReader() throws FileNotFoundException {
		FileReader fileReader = new FileReader(
				"C:\\Users\\Karan Giri\\git\\SECUREBANK\\SECUREBANK\\src\\main\\java\\dbInfo\\Info.txt");
		Properties properties = new Properties();
		try {
			properties.load(fileReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new String[] { properties.getProperty("username"), properties.getProperty("password"),
				properties.getProperty("db_name") };

	}

}
