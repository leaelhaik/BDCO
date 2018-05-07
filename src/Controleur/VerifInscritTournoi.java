package Controleur;

import connection.Queries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class VerifInscritTournoi {
	List<String> nomPrenom = new ArrayList<String>();
	public VerifInscritTournoi(String nom, String prenom){
		ResultSet rsetJoueur = Queries.queries.getResult("Select * From joueurs where nom=\'"+nom+"\', " +
				"prenom=\'"+prenom+"\'");
		try{
			while(rsetJoueur.next()){
				nomPrenom.add(rsetJoueur.getString(1));
			}
		} catch	(SQLException e){
			e.printStackTrace();
		}
	}

	/**
	 * Verifie si un joueur est bien inscrit
	 * @return true si joueur bien inscrit, false sinon
	 */
	public boolean getInscritTournoi(){
		if (!this.nomPrenom.equals("") || !this.nomPrenom.equals("erreur")){
			return true;
		}
		return false;
	}
}
