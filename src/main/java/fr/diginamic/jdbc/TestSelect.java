package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

/**
 * 
 * @author c_and
 *
 */
public class TestSelect {

	public static void main(String[] args) throws SQLException {
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

			//statement
			Statement statement = connexion.createStatement();

			//executer requète
			ResultSet curseur = statement.executeQuery("SELECT * FROM FOURNISSEUR");

			ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
			while (curseur.next()){
				int id = curseur.getInt("ID");
				String nom = curseur.getString("NOM");
				Fournisseur fourn = new Fournisseur(id, nom);
				fournisseurs.add(fourn);
				System.out.println(id+" / "+nom);
				}
			curseur.close();
			statement.close();
			connexion.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

			}


		

	}

}
