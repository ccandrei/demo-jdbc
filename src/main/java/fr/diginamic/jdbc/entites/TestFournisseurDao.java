package fr.diginamic.jdbc.entites;

import java.util.List;
import fr.diginamic.jdbc.dao.*;


public class TestFournisseurDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Fournisseur> listFournisseur;
		FournisseurDaoJdbc temps = new FournisseurDaoJdbc();
		listFournisseur=temps.extraire();
		System.out.println(listFournisseur);
		
		//Insert
		/*Fournisseur test= new Fournisseur(5,"La Maison XXL");
		 
		temps.insert(test);
		
		listFournisseur=temps.extraire();*/
		
		//Update
	
		temps.update("La Maison XXL", "La Maison XXL 33");
		
		listFournisseur=temps.extraire();
		
		//delete
		/*Fournisseur test= new Fournisseur(5 ," ");
		temps.delete(test);
		
		listFournisseur=temps.extraire();*/
		
	}

}
