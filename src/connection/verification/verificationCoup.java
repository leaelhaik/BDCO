package connection.verification;
import java.sql.*;

//boolean blanc = true ;

public class verificationCoup {

    public boolean isValid = false ;

    public verificationCoup(int posY, int oldY, Character posX, Character oldX, int numRencontre, String nomTour,
                            String couleur, Connection conn){

    String STMTC = " Select posX,posY from historique where idCoup=max(idCoup)";
    Statement stmtc = conn.createStatement();
    ResultSet rsetc = stmtc.executeQuery(STMTC);

    String STMTCouleur = " Select couleur from piece where posX="+rsetc.getString(arg0)+",posY="+posY;
    PreparedStatement stmtcouleur = conn.prepareStatement(STMTCouleur);
    stmtcouleur.setObject(1,rsetc.getString(1),Types.CHAR);
    stmtcouleur.setInt(2,posY);
    ResultSet rsetcoul = stmtcouleur.executeQuery(STMTCouleur);


    String STMT = "Select posY,posX from piece where numRencontre=? and nomTour=? and couleur=? and typePiece='roi'";
    PreparedStatement roi = conn.prepareStatement(STMT);
    roi.setInt(1,numRencontre);
    roi.setString(2,nomTour);
    roi.setString(3,couleur);
    roi.executeUpdate();
    ResultSet rsetRoi = roi.executeQuery(STMT);


    //verification si obstacle en vue : invalide
    String STMTType = "select typePiece from piece where numRencontre=? and nomTour=? and posY = ? and posX = ? ";

    PreparedStatement hav = conn.prepareStatement(STMTType);
    hav.setInt(1,numRencontre);
    hav.setString(2,nomTour);
    hav.setInt(3,posY);
    hav.setInt(4,posX);
    hav.executeUpdate();
    //commit
    // Execution de la requete
    ResultSet type = hav.executeQuery(STMT);  //Piece dans l'entourage puis selon type de la piece on change

    switch(type.getString(1)){

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
        	
        String STMT2 = "Select couleur from piece where numRencontre=? and nomTour= ? and posY = ? and posX = ?;";
        PreparedStatement sel = conn.prepareStatement(STMT);
        sel.setInt(1,numRencontre);
        sel.setString(2,nomTour);
        sel.setInt(3,posY);
        sel.setObject(4,posX,Types.CHAR);
        sel.executeUpdate();
        ResultSet rsetSel = sel.executeQuery(STMT2);
        if(rsetSel.getString(1)==couleur){

            isValid=false;
        }
        else{
            String STMT1 = "Delete from piece where numRencontre=? and nomTour=? and posY = ? and posX = ?;";
            PreparedStatement del = conn.prepareStatement(STMT1);
            del.setInt(1,numRencontre);
            del.setString(2,nomTour);
            del.setInt(3,posY);
            del.setObject(4,posX,Types.CHAR);
            del.executeUpdate();
            // Execution de la requete
            startTransact(conn);
            ResultSet rset = del.executeQuery(STMT1);

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

            if(VerifEchec(rsetRoi.getInt(1),rsetRoi.getInt(2),numRencontre,nomTour,couleur).enEchec()){
                rollFunction(conn);
                isValid=false;
            }
            else{
                String STMTHIST = "Insert into historique(nomTour,numRencontre,posY,posX,oldY,oldX) VALUES(?,?,?,?,?,?);";
                PreparedStatement inse = conn.prepareStatement(STMTHIST);
                inse.setString(1,nomTour);
                inse.setInt(2,numRencontre);
                inse.setInt(3,posY);
                inse.setInt(4,posX);
                inse.setInt(5,oldY);
                inse.setInt(6,oldX);
                inse.executeUpdate();
                //commit
                // Execution de la requete
                ResultSet rset2 = inse.executeQuery(STMTHIST);
                commit();
                rset2.close();
                inse.close();
            }
            rset.close();
            rset3.close();
            del.close();
            nouv.close();
        }
        // Fermeture
        type.close();
        rsetc.close();
        stmtc.close();
        rsetRoi.close();
        rsetSel.close();
        sel.close();
    }



 

    public boolean isValid(){
        return isValid;
    }

    public static void main(String args[]) {
       // new VerificationCoup(posY,oldY, posX, oldX, numRencontre, nomTour, couleur,conn);
    }

}
