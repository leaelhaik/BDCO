package donnees;

import java.sql.*;

import connection.MultipleQueries;
import connection.Queries;

public class Piece {
		
	private Couleur couleur;
	private String nomPiece;

	public Piece(Couleur coul, String str) {
		this.couleur=coul;
		this.nomPiece=str;
	}

	public Piece(String posX, int posY, int numRencontre, String nomTour) {

		try {
				
			ResultSet rset = Queries.queries.getResult("SELECT typePiece, couleur FROM Piece WHERE posX = \' " + posX + " \' AND posY = "+ posY + " AND numRencontre = " + numRencontre + " AND nomTour = \' " + nomTour + "\' ");
			
			String nomCouleur;
			
			if (rset != null) {
				while(rset.next()) {
					this.nomPiece = rset.getString(1);
					
					nomCouleur = rset.getString(2);
					if ( nomCouleur.equals("blanc") ){
						this.couleur = Couleur.blanc;
					}
					else {
						this.couleur = Couleur.noir;
					}
				}

			}

			// Fermeture
			rset.close();
		}

		catch (SQLException e) {
			System.err.println("failed");
			e.printStackTrace(System.err);
		}
		
	}
	


	public String getNomPiece() {
		return this.nomPiece;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}
}


 
