package connection.verification;
import java.sql.*;
boolean blanc = true ;

public class verificationCoup {

    public boolean isValid = false ;

    public verificationCoup(int posY, int oldY, Character posX, Character oldX, int numRencontre, String nomTour,
                            String couleur, Connection conn){



    String STMT = "Select posY,posX from piece where numRencontre=? and nomTour=? and couleur=? and typePiece='roi'";
    PreparedStatement roi = conn.prepareStatement(STMT);
    roi.setInt(1,numRencontre);
    roi.setString(2,nomTour);
    roi.setString(3,couleur);
    roi.executeUpdate();
    ResultSet rsetRoi = stmt.executeQuery(STMT);


    //verification si obstacle en vue : invalide
    static final String STMTType = "select typePiece from piece where numRencontre=? and nomTour=? and posY = ? and posX = ? ";

    PreparedStatement hav = conn.prepareStatement(STMTType);
    hav.setInt(1,numRencontre);
    hav.setString(2,nomTour);
    hav.setInt(3,posY);
    hav.setInt(4,posX);
    hav.executeUpdate();
    //commit
    // Execution de la requete
    ResultSet type = stmt.executeQuery(STMT);  //Piece dans l'entourage puis selon type de la piece on change

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
        String STMT = "Select couleur from piece where numRencontre=? and nomTour= ? and posY = ? and posX = ?;";
        PreparedStatement sel = conn.prepareStatement(STMT);
        sel.setInt(1,numRencontre);
        sel.setString(2,nomTour);
        sel.setInt(3,posY);
        sel.setObject(4,posX,Type.CHAR);
        roi.executeUpdate();
        ResultSet rsetSel = stmt.executeQuery(STMT);
        if(rsetSel.getString(1)==couleur){
            isValid=false;
        }
        else{
            String STMT1 = "Delete from piece where numRencontre=? and nomTour=? and posY = ? and posX = ?;";
            PreparedStatement del = conn.prepareStatement(STMT1);
            del.setInt(1,numRencontre);
            del.setString(2,nomTour);
            del.setInt(3,posY);
            del.setObject(4,posX,Type.CHAR);
            del.executeUpdate();
            // Execution de la requete
            startTransact(conn);
            ResultSet rset = stmt.executeQuery(STMT1);

            String STMT3 = "update Piece SET posX=?, posY = ?, oldX=?, oldY=? where posX = ? , posY = ?";
            PreparedStatement nouv = conn.prepareStatement(STMT3);
            nouv.setInt(1,null);
            nouv.setInt(2,null);
            nouv.setObject(3,posX),Type.CHAR;
            nouv.setInt(4,posY);
            nouv.setObject(5,oldX,Type.CHAR);
            nouv.setInt(6,oldY);
            inse.executeUpdate();
            //commit
            // Execution de la requete
            ResultSet rset3 = stmt.executeQuery(STMT3);

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
                ResultSet rset2 = stmt.executeQuery(STMTHIST);
                commit();
            }
        }
    }


    // Fermeture
    type.close();
    rsetRoi.close();
    rsetSel.close();
    rset.close();
    rset2.close();
    rset3.close();
    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
    }

    public boolean isValid(){
        return isValid;
    }

    public static void main(String args[]) {
        new VerificationCoup(posY,oldY, posX, oldX, numRencontre, nomTour, couleur,conn);
    }

}
