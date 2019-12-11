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
public class TestDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ResourceBundle result = ResourceBundle.getBundle("database");
		try {
			Class.forName(result.getString("database.driver"));
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Connection connexion = null;
		
		try {
			connexion = DriverManager.getConnection(result.getString("database.url"), result.getString("database.user"), result.getString("database.password"));
			 
			/*Connectez vous à la base de données compta puis réalisez une requête qui 
			  * permet de supprimer le fournisseur « La Maison des Peintures. ».*/
			
			//statement
			Statement statement = connexion.createStatement();

			//réalisez requète
			statement.executeUpdate("DELETE FROM FOURNISSEUR WHERE ID=4 ");

			statement.close();
			connexion.commit();
			connexion.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				connexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();

			}
	}

}
