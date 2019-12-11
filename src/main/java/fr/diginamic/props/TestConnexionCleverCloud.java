package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnexionCleverCloud {

	public static void main(String[] args) {

		try {
			ResourceBundle connectionCloud = ResourceBundle.getBundle("dataBaseCloud");
			String url 	= connectionCloud.getString("url");
			String user = connectionCloud.getString("user");
			String password = connectionCloud.getString("password");

			DriverManager.registerDriver( new org.mariadb.jdbc.Driver());
			Connection	connection = DriverManager.getConnection( url, user, password);

			System.out.println("connection " + connection.toString());
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
