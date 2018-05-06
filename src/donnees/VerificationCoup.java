package donnees;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.MultipleQueries;
import connection.Queries;

public class VerificationCoup {

	private boolean isValid = false ;
	private String typePiece;


	public VerificationCoup(int posY, int oldY, Character posX, Character oldX, int numRencontre, String nomTour,
			String couleur){
		ResultSet rsetDerPiece = Queries.queries.getResult(" Select posX,posY from historique where idCoup=max(idCoup)");
		ResultSet rsetCoul = null;
		try {
			rsetCoul = Queries.queries.getResult(" Select couleur from piece where posX=\'" +rsetDerPiece.getString("posX")+ "\',posY=\'" +rsetDerPiece.getString("posY")+"\'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		typePiece="roi";
		try {
			ResultSet rsetroi = Queries.queries.getResult("Select posY,posX from piece where numRencontre=" + numRencontre + "and nomTour= \'" + nomTour + "\' and couleur=\'" + rsetCoul.getString("Couleur")+ "\' and typePiece=\'"+typePiece+"\'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		ResultSet rsetType = Queries.queries.getResult("select typePiece from piece where numRencontre=" + numRencontre +" and nomTour=\'" + nomTour +" \' and posY = " + posY + " and posX =\'" + posX + "\'");

		try {
			typePiece=rsetType.getString("typePiece");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch(typePiece){

		case "tour" : isValid = VerifTour(posY,oldY,posX,oldX,numRencontre,nomTour, couleur);
		break;

		case "fou" : isValid = VerifFou(posY,oldY,posX,oldX,numRencontre,nomTour, couleur);
		break;

		case "roi" : isValid = VerifRoi(posY,oldY,posX,oldX,numRencontre,nomTour, couleur);
		break;

		case "cavalier" : isValid = VerifCavalier(posY,oldY,posX,oldX,numRencontre,nomTour, couleur);
		break;

		case "reine" : isValid = VerifReine(posY,oldY,posX,oldX,numRencontre,nomTour, couleur);
		break;

		case "pion" : isValid = VerifPion(posY,oldY,posX,oldX,numRencontre,nomTour, couleur);
		break;
		}

		if(isValid){
			ResultSet rsetCoul2 = Queries.queries.getResult("Select couleur from piece where numRencontre= " + numRencontre + " and nomTour= \'"+nomTour +"\' and posY = " + posY + " and posX =\'" + posX + "\'");

			try {
				if(rsetCoul2.getString("Couleur")==couleur){
					isValid=false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	    

		}
		else{
			startTransact(Queries.queries.getConnection());
			ResultSet rsetDel = Queries.queries.getResult("Delete from piece where numRencontre="+ numRencontre + " and nomTour= \' "+nomTour+"\' and posY =" + posY + " and posX =\'" + posX + "\'");
		}
		ResultSet rsetUp = Queries.queries.getResult("Delete from piece where numRencontre="+ numRencontre + " and nomTour=\'"+nomTour+"\' and posY =" + posY + " and posX =\'" + posX + "\'");


		ResultSet rsetUpdate = Queries.queries.getResult("update Piece SET posX=\'" +posX+ "\', posY = " + posY + ", oldX=\'" +oldX+ "\', oldY= " + oldY + " where posX = \'" +oldX+ "\' , posY = " + oldY +"");
		
	}





	/* --------------------------------Verif Cavalier ----------------------------------*/
	public boolean VerifCavalier(int posY, int oldY, Character posX, Character oldX, int numRencontre, String nomTour, String couleur) {
		boolean bool=false;
		try {
			byte[] tabOldX = null;
			byte[] tabPosX = null;

			try {
				tabOldX = oldX.toString().getBytes("UTF-8");
				tabPosX = posX.toString().getBytes("UTF-8");
			} catch (IOException ioe) {

			}
			ResultSet rsetCavalier = null;
			if(((Math.abs(posY-oldY)==2) && (Math.abs(tabPosX[0]-tabOldX[0]))==1) || ((Math.abs(tabPosX[0]-tabOldX[0])==2) && (Math.abs(posY-oldY)==1))) {

				rsetCavalier = Queries.queries.getResult("select idPiece from Piece where numRencontre = " + numRencontre +" and nomTour = \'"+ nomTour + "\' and couleur = \'"+ couleur +"\' and posX = \'" + posX + "\' and posY = " + posY + "");

			}
			bool=!(rsetCavalier.next());

		} catch(SQLException e) {
			System.err.println("failed");
			e.printStackTrace();
		}
		return bool;

	}



	/* ---------------------------------Verif Fou ----------------------------------------*/
	public boolean VerifFou(int posY, int oldY, Character posX, Character oldX, int numRencontre, String nomTour,String couleur) {
		boolean bool = false;
		try {
			byte[] tabOldX = null;
			byte[] tabPosX = null;

			try {
				tabOldX = oldX.toString().getBytes("UTF-8");
				tabPosX = posX.toString().getBytes("UTF-8");
			} catch (IOException ioe) {

			}

			if(Math.abs(tabOldX[0]-tabPosX[0])==Math.abs(oldY-posY)) {

				ResultSet rsetFou;
				if (tabPosX[0] < tabOldX[0]) {
					if (posY < oldY) {
						rsetFou = Queries.queries.getResult("select idPiece from piece where numRencontre=" + numRencontre + "and nomTour= \'" + nomTour + "\' and abs(ascii(posX)- \'" + tabOldX[0] + "\')=abs(posY-" + oldY + ") and posX between \'" + posX + "\' and \'" + oldX + "\' and posY between " + posY + " and " + oldY + "");
					} else {
						rsetFou = Queries.queries.getResult("select idPiece from piece where numRencontre=" + numRencontre + "and nomTour= \'" + nomTour + "\' and abs(ascii(posX)- \'" + tabOldX[0] + "\' )=abs(posY-" + oldY + ") and posX between \'" + posX + "\' and \'" + oldX + "\' and posY between " + oldY + " and " + posY + "");
					}
				} else {
					if (posY < oldY) {
						rsetFou = Queries.queries.getResult("select idPiece from piece where numRencontre=" + numRencontre + "and nomTour= \'" + nomTour + "\' and abs(ascii(posX)-\'" + tabOldX[0] + "\')=abs(posY-" + oldY + ") and posX between \'" + oldX + "\' and \'" + posX + "\' and posY between " + posY + " and " + oldY + "");
					} else {
						rsetFou = Queries.queries.getResult("select idPiece from piece where numRencontre=" + numRencontre + "and nomTour= \'" + nomTour + "\' and abs(ascii(posX)-\'" + tabOldX[0] + "\')=abs(posY-" + oldY + ") and posX between \'" + oldX + "\' and \'" + posX + "\' and posY between " + oldY + " and " + posY + "");
					}

				}

				bool=!(rsetFou.next());
			}

		} catch(SQLException e) {
			System.err.println("failed");
			e.printStackTrace();
		}
		return bool;

	}

	/* -------------------------------- Verif Pion ------------------------------ */
	public boolean VerifPion(int posY, int oldY, Character posX, Character oldX, int numRencontre, String nomTour, String couleur) {
		boolean bool= false;
		try {
			byte[] tabOldX = null;
			byte[] tabPosX = null;

			try {
				tabOldX = oldX.toString().getBytes("UTF-8");
				tabPosX = posX.toString().getBytes("UTF-8");
			} catch (IOException ioe) {

			}

			ResultSet rsetPion1, rsetPion2;

			if(((posY-oldY)==1 && "blanc".equals(couleur)) || ((oldY-posY)==1 && "noir".equals(couleur))) {
				if((tabOldX[0]-tabPosX[0])==1)  {// Veut manger à gauche
			  		rsetPion1 = Queries.queries.getResult("select idPiece, couleur, posX, posY from Piece where numRencontre = " + numRencontre + " and nomTour = \' " + nomTour + "\' and couleur<>\' " + couleur + "\' and posX = \'" + posX + "\' and posY = " + posY +"");
					bool=!(rsetPion1.next());
				} else {
					rsetPion2 = Queries.queries.getResult("select idPiece, posX, posY from Piece where numRencontre = " + numRencontre + " and nomTour = \' " + nomTour + "\' and couleur<>\' " + couleur + "\' and posX = \'" + posX + "\' and posY = " + posY +"");
					bool=!(rsetPion2.next());
				}
			}


		} catch(SQLException e) {
			System.err.println("failed");
			e.printStackTrace();
		}
		return bool;

	}



	/* ----------------------------------- Verif Reine ----------------------------- */

	public boolean VerifReine(int posY, int oldY, Character posX, Character oldX, int numRencontre, String nomTour,String couleur) {
		boolean bool;

		byte[] tabOldX = null;
		byte[] tabPosX = null;

		try {
			tabOldX = oldX.toString().getBytes("UTF-8");
			tabPosX = posX.toString().getBytes("UTF-8");
		} catch (IOException ioe) {

		}

		if((tabPosX[0]==tabOldX[0])||(posY==oldY)) {
			bool=VerifTour(posY,oldY,posX,oldX,numRencontre,nomTour, couleur);
		} else {
			bool=VerifFou(posY,oldY,posX,oldX,numRencontre,nomTour, couleur);
		}
		return bool;
	}


	/* ----------------------------------- Verif Roi ----------------------------- */

	public boolean VerifRoi(int posY, int oldY, Character posX, Character oldX, int numRencontre, String nomTour,String couleur) {
		boolean bool = false;


		try {
			byte[] tabOldX = null;
			byte[] tabPosX = null;

			try {
				tabOldX = oldX.toString().getBytes("UTF-8");
				tabPosX = posX.toString().getBytes("UTF-8");
			} catch (IOException ioe) {

			}

			ResultSet rsetRoi = null;

			if((Math.abs(posY-oldY)==1) || (Math.abs(tabPosX[0]-tabOldX[0]))==1 || ((Math.abs(tabPosX[0]-tabOldX[0])==1) && (Math.abs(posY-oldY)==1))) {
				rsetRoi = Queries.queries.getResult("select idPiece from Piece where numRencontre = " + numRencontre + " and nomTour = \' " + nomTour + " \' and couleur = \' " + couleur + " \' and posX = \'" + posX + "\' and posY = " + posY + "");
			}
			bool=!(rsetRoi.next());

		} catch(SQLException e) {
			System.err.println("failed");
			e.printStackTrace();
		}


		return bool;

	}
	
	/* ----------------------------------- Verif Tour ----------------------------- */
		
	public boolean VerifTour(int posY, int oldY, Character posX, Character oldX, int numRencontre, String nomTour,String couleur) {
		boolean bool = false;
	    try {
	      byte[] tabOldX = null;
	      byte[] tabPosX = null;

	      try {
	        tabOldX = oldX.toString().getBytes("UTF-8");
	        tabPosX = posX.toString().getBytes("UTF-8");
	      } catch (IOException ioe) {

	      }

	      ResultSet rsetTour1, rsetTour2;
	      if((tabPosX[0]==tabOldX[0]) || (posY==oldY)) {
	        if(posY==oldY) {
	        	if(tabPosX[0] < tabOldX[0]) {
	        		rsetTour1 = Queries.queries.getResult("select idPiece from Piece where numRencontre=" + numRencontre + " and nomTour=\' " + nomTour + " \'  and posX between \'" + posX + "\' and  \'" + oldX + "\' and posY =" + posY + " ");
	        	} else {
	        		rsetTour1 = Queries.queries.getResult("select idPiece from Piece where numRencontre=" + numRencontre + " and nomTour=\' " + nomTour + " \'  and posX between \'" + oldX + "\' and \'" + posX + "\' and posY = " + posY + "");
	        	}
	        	bool=!(rsetTour1.next());
	        } else {
	        	if(tabPosX[0] < tabOldX[0]) {
	  	          rsetTour2 = Queries.queries.getResult("select idPiece from Piece where numRencontre=" + numRencontre + " and nomTour=\' " + nomTour + " \'  and posX = \'" + posX + "\' and posY between " + posY + " and " + oldY + "");
	        	} else {
	  	          rsetTour2 = Queries.queries.getResult("select idPiece from Piece where numRencontre=" + numRencontre + " and nomTour=\' " + nomTour + " \'  and posX = \'" + posX + "\' and posY between " + oldY + " and " + posY + "");
	        	}
	        	bool=!(rsetTour2.next());
	        }

	      }

	    } catch(SQLException e) {
	            System.err.println("failed");
	            e.printStackTrace();
	      }
	    
		return bool;

	  }
	
	
	 /* --------------------- Situation de mise en échec -------------------------*/
	  public void startTransact(Connection conn){
	      ResultSet rset = Queries.queries.getResult("Start Transaction;");
	  }

	  public ResultSet setFunction(int idPiece,Character posX, int posY, Connection conn){
	    ResultSet rsetSel = Queries.queries.getResult("update piece set posX=\' " + posX + " \' ,posY= " + posY + " where idPiece=" + idPiece + "");
	    return rsetSel;
	  }

	  public void rollFunction(Connection conn){
	    ResultSet rset = Queries.queries.getResult("Rollback;");
	    Queries.queries.closeConnection();
	  }

	  public void commit(Connection conn){
		    ResultSet rset = Queries.queries.getResult("Commit;");
		    Queries.queries.closeConnection();
	  }

}
