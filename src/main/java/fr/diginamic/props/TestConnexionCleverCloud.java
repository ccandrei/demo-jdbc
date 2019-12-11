package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnexionCleverCloud {

	public static void main(String[] args) {

		ResourceBundle connectionCloud = ResourceBundle.getBundle("dataBaseCloud");
		
		String url = connectionCloud.getString("url");
		String userName = connectionCloud.getString("user");
		String passWord = connectionCloud.getString("password");
		
		try {
			Connection maConnection = DriverManager.getConnection(url, userName, passWord);
			System.out.println("Connexion établie");
			maConnection.close();
		} catch (SQLException e) {

			System.out.println("Impossible à établir une connexion");
		}
	}
}
