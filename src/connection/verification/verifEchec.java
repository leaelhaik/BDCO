package connection.verification;
import java.sql.*;

public class VerifEchec {

  static final String STMT = "select idPiece,posX,posY,couleur,typePiece from piece where couleur<>?, numRencontre=?,nomTour=?";
  private boolean enEchec = false ;

//si on a les pos du roi
  public VerifEchec(Connection conn, int posY, Character posX, int numRencontre, String nomTour, String couleur) {
  try {

    PreparedStatement sel = conn.prepareStatement(STMT);
    sel.setString(1,couleur);
    sel.setInt(2,numRencontre);
    sel.setString(3,nomTour);
    sel.executeUpdate();

    ResultSet rset = sel.executeQuery(STMT);
    while(rset.next() && !enEchec){
      switch(rset.getString(5)){
        case 'pion' : enEchec = VerifPion(conn,posY,rset.getInt(3),posX,rset.getInt(2), numRencontre, nomTour, couleur).getIsValid();
        case 'reine' : enEchec = VerifReine(conn,posY,rset.getInt(3),posX,rset.getInt(2), numRencontre, nomTour, couleur).getIsValid();
        case 'roi' : enEchec = VerifRoi(conn,posY,rset.getInt(3),posX,rset.getInt(2), numRencontre, nomTour, couleur).getIsValid();
        case 'cavalier' : enEchec = VerifCavalier(conn,posY,rset.getInt(3),posX,rset.getInt(2), numRencontre, nomTour, couleur).getIsValid();
        case 'tour' : enEchec = VerifTour(conn,posY,rset.getInt(3),posX,rset.getInt(2), numRencontre, nomTour, couleur).getIsValid();
        case 'fou' : enEchec = VerifFou(conn,posY,rset.getInt(3),posX,rset.getInt(2), numRencontre, nomTour, couleur).getIsValid();
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
    return this.enEchec ;
  }

  public static void main(String args[]) {
    try {
      Connect co = new Connect();
      Connection conn = co.getConnection();
      /*
        Mettre des arguments dans le constructeur dans le main pour les tests
      */
      new VerifEchec();
      conn.close();
      co.closeConnection();
    } catch (SQLException e) {
      System.err.println("failed");
      e.printStackTrace(System.err);
      }
  }

}
