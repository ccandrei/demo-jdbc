package fr.diginamic.props;

import java.util.ResourceBundle;

public class TestConfiguration {

	public static void main(String[] args) {
		
		ResourceBundle demojdbc = ResourceBundle.getBundle("demojdbc");
		String valeur = demojdbc.getString("connection");
		String valeur1 = demojdbc.getString("user");
		System.out.println(valeur);
		System.out.println(valeur1);
	}

}
