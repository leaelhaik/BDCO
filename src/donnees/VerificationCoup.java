package donnees;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import connection.MultipleQueries;

public class VerificationCoup {
	
	private MultipleQueries queries;
	private boolean isValid = false ;
	private String typePiece;
	
	
	public VerificationCoup(int posY, int oldY, Character posX, Character oldX, int numRencontre, String nomTour,
            String couleur){
		queries = new MultipleQueries();
		ResultSet rsetDerPiece = queries.getResult(" Select posX,posY from historique where idCoup=max(idCoup)");
		ResultSet rsetCoul = null;
		try {
			rsetCoul = queries.getResult(" Select couleur from piece where posX=\'" +rsetDerPiece.getString("posX")+ "\',posY=\'" +rsetDerPiece.getString("posY")+"\'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		typePiece="roi";
		try {
			ResultSet rsetroi = queries.getResult("Select posY,posX from piece where numRencontre=" + numRencontre + "and nomTour=" + nomTour + "and couleur=\'" + rsetCoul.getString("Couleur")+ "\' and typePiece="+typePiece+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ResultSet rsetType = queries.getResult("select typePiece from piece where numRencontre=" + numRencontre +" and nomTour=" + nomTour +" and posY = " + posY + " and posX ="+posX+"");
	
		try {
			typePiece=rsetType.getString("typePiece");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    switch(typePiece){

		        case "tour" : isValid = VerifTour(conn,posY,oldY,posX,oldX,numRencontre,nomTour, couleur).getIsValid();
		        	break;
		
		        case "fou" : isValid = VerifFou(conn,posY,oldY,posX,oldX,numRencontre,nomTour, couleur).getIsValid();
		            break;
		
		        case "roi" : isValid = VerifRoi(conn,posY,oldY,posX,oldX,numRencontre,nomTour, couleur).getIsValid();
		            break;
		
		        case "cavalier" : isValid = VerifCavalier(conn,posY,oldY,posX,oldX,numRencontre,nomTour, couleur).getIsValid();
		            break;
		
		        case "reine" : isValid = VerifReine(conn,posY,oldY,posX,oldX,numRencontre,nomTour, couleur).getIsValid();
		            break;
		
		        case "pion" : isValid = VerifPion(conn,posY,oldY,posX,oldX,numRencontre,nomTour, couleur).getIsValid();
		            break;
	    }
	    
        if(isValid){
    		ResultSet rsetCoul2 = queries.getResult("Select couleur from piece where numRencontre= " + numRencontre + " and nomTour="+nomTour +" and posY = " + posY+" and posX ="+ posX +"");
        
	        if(rsetCoul2.getString("Couleur")==couleur){
	            isValid=false;
	        }	    
	    
        }
        else{
        	startTransact(conn);
        	ResultSet rsetDel = queries.getResult("Delete from piece where numRencontre="+ numRencontre + " and nomTour="+nomTour+" and posY ="+posY+" and posX ="+posX+"");
        }
    	ResultSet rsetUp = queries.getResult("Delete from piece where numRencontre="+ numRencontre + " and nomTour="+nomTour+" and posY ="+posY+" and posX ="+posX+"");


            String STMT3 = "update Piece SET posX=?, posY = ?, oldX=?, oldY=? where posX = ? , posY = ?";
            PreparedStatement nouv = conn.prepareStatement(STMT3);
            nouv.setObject(1,posX,Types.CHAR);
            nouv.setInt(2,posY);
            nouv.setObject(3,oldX,Types.CHAR);
            nouv.setInt(4,oldY);
            nouv.setObject(5,oldX,Types.CHAR);
            nouv.setInt(6,oldY);
            nouv.executeUpdate();
            //commit
            // Execution de la requete
            ResultSet rset3 = nouv.executeQuery(STMT3);
        }
	
	
	
	
	
	/* --------------------------------Verif Cavalier ----------------------------------*/
	public boolean VerifCavalier(int posY, int oldY, String posX, String oldX, int numRencontre, String nomTour, String couleur) {

	    try {
	      byte[] tabOldX = null;
	      byte[] tabPosX = null;
	      int nbLignes = 0;

	      try {
	        tabOldX = oldX.getBytes("UTF-8");
	        tabPosX = posX.getBytes("UTF-8");
	      } catch (IOException ioe) {

	      }

	      if(((Math.abs(posY-oldY)==2) && (Math.abs(tabPosX[0]-tabOldX[0]))==1) || ((Math.abs(tabPosX[0]-tabOldX[0])==2) && (Math.abs(posY-oldY)==1))) {

	        ResultSet rsetCavalier = queries.getResult("select idPiece from Piece where numRencontre = " + numRencontre +" and nomTour = \'"+ nomTour + "\' and couleur = \'"+ couleur +"\' and posX = "+posX+" and posY = "+posY+"");

	        
	        verifNbLignes(rsetCavalier);
	        nbLignes = rsetCavalier.getRow();
	        rsetCavalier.beforeFirst();
	        if(nbLignes != 0)
	          this.isValid = false;
	        else
	          this.isValid = true;

	      }

	    } catch(SQLException e) {
	            System.err.println("failed");
	            e.printStackTrace();
	      }
		return isValid;

	  }



}
