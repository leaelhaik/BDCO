package connection.verification;
import java.sql.*;

public class VerifEchec {
static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
static final String USER = "dhouibd"; // A remplacer pour votre compte
static final String PASSWD = "dhouibd";
static final String STMT = "select idPiece,posX,posY,couleur,typePiece from piece where couleur<>?, numRenconre=?,nomTour=?";
private boolean enEchec = false ;

//si on a les pos du roi
public VerifEchec(Connection conn, int posY, Character posX, int numRenconre, String nomTour, String couleur) {

  try {

    PreparedStatement sel = conn.prepareStatement(STMT);
    sel.setString(1,couleur);
    sel.setInt(2,numRenconre);
    sel.setString(3,nomTour);
    sel.executeUpdate();

    ResultSet rset = stmt.executeQuery(STMT);
    while(rset.next() && !enEchec){
      switch(rset.getString(5)){
        case 'pion' : enEchec = VerifPion(posY,rset.getInt(3),posX,rset.getInt(2)).getIsValid();
        case 'reine' : enEchec = VerifReine(posY,rset.getInt(3),posX,rset.getInt(2)).getIsValid();
        case 'roi' : enEchec = VerifRoi(posY,rset.getInt(3),posX,rset.getInt(2)).getIsValid();
        case 'cavalier' : enEchec = VerifCavalier(posY,rset.getInt(3),posX,rset.getInt(2)).getIsValid();
        case 'tour' : enEchec = VerifTour(posY,rset.getInt(3),posX,rset.getInt(2)).getIsValid();
        case 'fou' : enEchec = VerifFou(posY,rset.getInt(3),posX,rset.getInt(2)).getIsValid();
      }
    }

    // Fermeture
    rset.close();
    stmt.close();
  } catch (SQLException e) {
      System.err.println("failed");
      e.printStackTrace(System.err);
    }
  }

public boolean enEchec(){
  return enEchec ;
}

public static void main(String args[]) {
  try {
    Connect co = new Connect();
    Connection conn = co.getConnection();
    new VerifEchec();
    conn.close();
    co.closeConnection();
  } catch (SQLException e) {
    System.err.println("failed");
    e.printStackTrace(System.err);
    }
}

}
