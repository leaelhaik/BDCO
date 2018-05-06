package donnees;

import java.sql.*;
import verificationCoup;
import connection.MultipleQueries;

public class VerificationEchecEtMat {

	boolean isVerified = false;

	public VerificationEchecEtMat(int numRencontre, String nomTour, int idJoueur, String couleur){

		try {
			ResultSet rsetRoi = Queries.queries.getResult("select idPiece,posX,posY,couleur from piece where typePiece='roi', couleur= \' " + couleur + "\' , numRencontre= " + numRencontre + ",nomTour=\' " + nomTour + "\'");

			int i,j = 0;
			char k= (char) (rsetRoi.getInt("posX")+j);

			VerificationEchec verifEchec= new VerificationEchec(rsetRoi.getInt("posY")+i,k,numRencontre,nomTour,couleur);

			//verification etat echec
			if(verifEchec.enEchec()){
				//verification etat mat : verification des déplacements possibles du roi
				for(i=-1;i<2;i++){
					for(j=-1;j<2;j++){
						if(!(i==0 && j==0)){

							if(!verifEchec.enEchec())
								isVerified=true;
							break;
						}

					}
				}

				if(!isVerified){
					//verification etat mat : verification de prise de la piece qui nous met en échec

					// on selectionne la piece qui nous met en échec(son id et sa position)
					ResultSet rsetPic = Queries.queries.getResult("select idPiece,posX,posY from historique where idCoup=count(idCoup), numRencontre= " + numrencontre + ",nomTour=\' " + nomTour + "\'");


					//on selectionne toutes les pièces de la couleur qu'on veut qui puissent prendre la piece
					ResultSet rset2 = Queries.queries.getResult("select idPiece,posX,posY,typePiece from piece where couleur=\'" + couleur + "\', numRencontre= " + numrencontre + ",nomTour=\' " + nomTour + "\'");
					while(rset2.next()&&!isVerified){
						switch(rset2.getString(4)){

						//verification Tour :
						case "tour" : isVerified = new verificationCoup.VerifTour(rsetPic.getInt(3),rset2.getInt(3),rsetPic.getInt(2),rset2.getInt(2),couleur);
						break;
						//verification Fou:
						case "fou" : isVerified = new VerificationCoup.VerifFou(rsetPic.getInt(3),rset2.getInt(3),rsetPic.getInt(2),rset2.getInt(2),couleur);
						break;
						//verification Roi:
						case "roi" : isVerified= new VerificationCoup.VerifRoi(rsetPic.getInt(3),rset2.getInt(3),rsetPic.getInt(2),rset2.getInt(2),couleur);
						break;
						//verification cavalier:
						case "cavalier" : isVerified= new VerificationCoup.VerifCavalier(rsetPic.getInt(3),rset2.getInt(3),rsetPic.getInt(2),rset2.getInt(2),couleur);
						break;
						//verification reine:
						case "reine" : isVerified=new VerificationCoup.VerifReine(rsetPic.getInt(3),rset2.getInt(3),rsetPic.getInt(2),rset2.getInt(2),couleur);
						break;
						//verification pion
						case "pion" : isVerified= new VerificationCoup.VerifPion(rsetPic.getInt(3),rset2.getInt(3),rsetPic.getInt(2),rset2.getInt(2),couleur);
						break;
						}
						if(isVerified){
							startTransact();
							setFunction(rset2.getInt(1),rsetPic.getInt(2),rsetPic.getInt(3));
							if(VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRencontre,nomTour,couleur).enEchec()){
								rollFunction();
								rset2.next();
							}
							else{
								break;
							}
						}
						else{
							rset2.next(); // essayer toutes les positions possibles
						}

					}
					// Faire un rollFunction()

					//verification etat mat : verification de déplacement de piece pour ne plus être en échec

					ResultatSet rset = Queries.queries.getResult("select idPiece,posX,posY,typePiece from piece where couleur=\'" + couleur + "\', numRencontre= " + numrencontre + ",nomTour=\' " + nomTour + "\'");

					while(rset.next()&&!isVerified){

						switch(rset.getString(4)){
						//verification Tour :
						case "tour" : for(int i=1;i<9;i++){
							for(char j='A';j<'I';j++){
								if(VerifTour(i,rset.getInt(3),j,rset.getString(2)).getIsValid()){
									startTransact(conn);
									setFunction(rset.getInt(1),j,i,conn);
									if(VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRencontre,nomTour,couleur).enEchec()){
										rollFunction(conn);
									}
									else{
										break;
									}
								}
							}
						}
						break;

						//verification Fou:
						case "fou" : for(int i=1;i<9;i++){
							for(char j='A';j<'I';j++){
								if(VerifFou(i,rset.getInt(3),j,rset.getString(2)).getIsValid()){
									startTransact(conn);
									setFunction(rset.getInt(1),j,i,conn);
									if(VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRencontre,nomTour,couleur).enEchec()){
										rollFunction(conn);
									}
									else{
										break;
									}
								}
							}
						}
						break;
						//verification Roi:
						case "roi" : for(int i=1;i<9;i++){
							for(char j='A';j<'I';j++){
								if(VerifRoi(i,rset.getInt(3),j,rset.getString(2)).getIsValid()){
									startTransact(conn);
									setFunction(rset.getInt(1),j,i,conn);
									if(VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRencontre,nomTour,couleur).enEchec()){
										rollFunction(conn);
									}
									else{
										break;
									}
								}
							}
						}
						break;
						//verification cavalier:
						case "cavalier" : for(int i=1;i<9;i++){
							for(char j='A';j<'I';j++){
								if(VerifCavalier(i,rset.getInt(3),j,rset.getString(2)).getIsValid()){
									startTransact(conn);
									setFunction(rset.getInt(1),j,i,conn);
									if(VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRencontre,nomTour,couleur).enEchec()){
										rollFunction(conn);
									}
									else{
										break;
									}
								}
							}
						}
						break;
						//verification reine:
						case "reine" : for(int i=1;i<9;i++){
							for(char j='A';j<'I';j++){
								if(VerifReine(i,rset.getInt(3),j,rset.getString(2)).getIsValid()){
									startTransact(conn);
									setFunction(rset.getInt(1),j,i,conn);
									if(VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRencontre,nomTour,couleur).enEchec()){
										rollFunction(conn);
									}
									else{
										break;
									}
								}
							}
						}
						break;
						//verification pion
						case "pion" : for(int i=1;i<9;i++){
							for(char j='A';j<'I';j++){
								if(VerifPion(i,rset.getInt(3),j,rset.getString(2)).getIsValid()){
									startTransact(conn);
									setFunction(rset.getInt(1),j,i,conn);
									if(VerifEchec(rsetRoi.getInt(3),rsetRoi.getInt(2),numRencontre,nomTour,couleur).enEchec()){
										rollFunction(conn);
									}
									else{
										break;
									}
								}
							}
						}
						break;
						}
						rset.next(); // essayer toutes les positions possibles
					}
				}

				if(!isVerified){

					ResultSet rsetC = Queries.queries.getResult("select idJoueur from AffectationCouleur where nomTour=\' " + nomTour + "\',numRencontre = " + numrencontre + ",couleur=\'"+couleur+"");

					ResultSet rsetV = Queries.queries.getResult("update rencontre set idJoueur="+ rsetC.getInt(1)+" where nomTour=\' " + nomTour + "\', numRencontre=",+numRencontre+"");

				}
			}
		} catch (SQLException e) {
			System.err.println("failed");
			e.printStackTrace(System.err);
		}
	}

}
