package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestConnexionJdbc {

	public static void main(String[] args) {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			System.out.println("Driver non trouve!");
		}
			
		try {
			Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "");
			
			System.out.println(connection.getClass());
			//System.out.println(connection.getCatalog());
			
			connection.close();
		}catch (SQLException e) {
			System.out.println("Connexion impossible à établir.");
		}
			
			
	
		
	}

}
