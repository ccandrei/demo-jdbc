package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 
 * @author c_and
 *
 */
public class TestInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub.

		ResourceBundle result = ResourceBundle.getBundle("database");
		try {
			Class.forName(result.getString("database.driver"));


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Connection connexion = DriverManager.getConnection(result.getString("database.url"), result.getString("database.user"), result.getString("database.password"));

			//statement
			Statement statement = connexion.createStatement();

			//executer requète
			statement.executeUpdate("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (12,'TEST 2')");
			statement.close();
			connexion.close();
			connexion.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();


		}
		
	}

}
