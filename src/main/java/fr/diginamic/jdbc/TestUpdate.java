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
public class TestUpdate {

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
			
			/*o Connectez vous à la base de données compta puis réalisez une requête 
			 * qui permet de modifier le nom du fournisseur en « La Maison des Peintures ».
			 */
			//statement
			Statement statement = connexion.createStatement();

			//réalisez requète
			statement.executeUpdate("UPDATE FOURNISSEUR SET NOM='La Maison des peintures' WHERE ID=4 ");

			statement.close();
			connexion.commit();
			connexion.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				connexion.rollback();
			} catch (SQLException e1) {
			
				e1.printStackTrace();
			}
			e.printStackTrace();

			}

	}

}
