package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnexionJdbcV2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ResourceBundle connDataBase = ResourceBundle.getBundle("database");
			String url 	= connDataBase.getString("database.url");
			String user = connDataBase.getString("database.user");
			String password = connDataBase.getString("database.password");

			DriverManager.registerDriver( new org.mariadb.jdbc.Driver());
			Connection	connection = DriverManager.getConnection( url, user, password);

			System.out.println("connection " + connection.toString());
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
