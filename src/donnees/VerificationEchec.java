package donnees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import donnees.VerificationCoup;

import connection.MultipleQueries;

public class VerificationEchec {

	private MultipleQueries queries;

	//static final  STMT = "select idPiece,posX,posY,couleur,typePiece from piece where couleur<>?, numRencontre=?,nomTour=?";
	private boolean enEchec = false ;

	//si on a les pos du roi
	public VerificationEchec(int posY, Character posX, int numRencontre, String nomTour, String couleur) {

		try {

			ResultSet rset = queries.getResult("select idPiece,posX,posY,couleur,typePiece from piece where couleur<> \' " + couleur + "\', numRencontre= " + numRencontre + ",nomTour= \' " + nomTour + "\'");
			VerificationCoup verif = new VerificationCoup(posY,rset.getInt(posY),posX,rset.getString("posX").charAt(0), numRencontre, nomTour, couleur);
			while(rset.next() && !enEchec){
				switch(rset.getString("typePiece")){
				case "pion" : enEchec = verif.VerifPion(posY,rset.getInt(posY),posX,rset.getString("posX").charAt(0), numRencontre, nomTour, couleur);
				case "reine" : enEchec = verif.VerifReine(posY,rset.getInt(posY),posX,rset.getString("posX").charAt(0), numRencontre, nomTour, couleur);
				case "roi" : enEchec = verif.VerifRoi(posY,rset.getInt(posY),posX,rset.getString("posX").charAt(0), numRencontre, nomTour, couleur);
				case "cavalier" : enEchec = verif.VerifCavalier(posY,rset.getInt(3),posX,rset.getString("posX").charAt(0), numRencontre, nomTour, couleur);
				case "tour" : enEchec = verif.VerifTour(posY,rset.getInt(3),posX,rset.getString("posX").charAt(0), numRencontre, nomTour, couleur);
				case "fou" : enEchec = verif.VerifFou(posY,rset.getInt(3),posX,rset.getString("posX").charAt(0), numRencontre, nomTour, couleur);
				}
			}

				// Fermeture
				rset.close();
			} catch (SQLException e) {
				System.err.println("failed");
				e.printStackTrace(System.err);
			}
		}

	
	public boolean enEchec(){
		return this.enEchec ;
	}



}
