//package connection.verification.verificationCoup;

//import connection.verification.verificationTable.Connect;
import java.sql.*;
import java.lang.Character;
import java.io.*;

public class VerifPion {

  private boolean isValid = false;
  private String STMTPion1 = "";
  private String STMTPion2 = "";
  private String STMTPion3 = "";


  public VerifPion(Connection conn, int posY, int oldY, String posX, String oldX, int numRencontre, String nomTour, String couleur) {

    try {
      byte[] tabOldX = null;
      byte[] tabPosX = null;
      int nbLignes = 0;

      try {
        tabOldX = oldX.getBytes("UTF-8");
        tabPosX = posX.getBytes("UTF-8");
      } catch (IOException ioe) {

      }

      if(((posY-oldY)==1 && "blanc".equals(couleur)) || ((oldY-posY)==1 && "noir".equals(couleur))) {
        if((tabOldX[0]-tabPosX[0])==1) // Veut manger à gauche
          STMTPion1 = "select idPiece, couleur, posX, posY from Piece where numRencontre = ? and nomTour = ? and couleur<>? and posX = ? and posY = ?";
        else if ((tabPosX[0]-tabOldX[0])==1) // Veut manger à droite
          STMTPion2 = "select idPiece, couleur, posX, posY from Piece where numRencontre = ? and nomTour = ? and couleur<>? and posX = ? and posY = ?";
        else
          STMTPion3 = "select idPiece, posX, posY from Piece where numRencontre = ? and nomTour = ? and posX = ? and posY = ?";

        int type = ResultSet.TYPE_SCROLL_INSENSITIVE;
        int mode = ResultSet.CONCUR_UPDATABLE;
        boolean isLast;

        ResultSet rset=null;

        if("".equals(STMTPion2) && "".equals(STMTPion3)){
          //System.out.println("Comportement d'une tour avec deplacement horizontal");
          PreparedStatement statement = conn.prepareStatement(STMTPion1, type, mode);
          statement.setInt(1, numRencontre);
          statement.setObject(2, nomTour, Types.VARCHAR);
          statement.setString(3, couleur);
          statement.setObject(4, posX, Types.CHAR);
          statement.setInt(5, posY);
          statement.executeUpdate();
          rset = statement.executeQuery(STMTPion1);
          isLast = rset.last();
          nbLignes = rset.getRow();
          rset.beforeFirst();
          if(nbLignes != 0)
            this.isValid = true;
          else
            this.isValid = false;
        }
        else if("".equals(STMTPion1) && "".equals(STMTPion3)) {
          PreparedStatement statement = conn.prepareStatement(STMTPion2, type, mode);
          statement.setInt(1, numRencontre);
          statement.setObject(2, nomTour, Types.VARCHAR);
          statement.setString(3, couleur);
          statement.setObject(4, posX, Types.CHAR);
          statement.setInt(5, posY);
          statement.executeUpdate();
          rset = statement.executeQuery(STMTPion2);
          isLast = rset.last();
          nbLignes = rset.getRow();
          rset.beforeFirst();
          if(nbLignes != 0)
            this.isValid = true;
          else
            this.isValid = false;
          }
        else if ("".equals(STMTPion1) && "".equals(STMTPion2)){
          PreparedStatement statement = conn.prepareStatement(STMTPion3, type, mode);
          statement.setInt(1, numRencontre);
          statement.setObject(2, nomTour, Types.VARCHAR);
          statement.setObject(3, posX, Types.CHAR);
          statement.setInt(4, posY);
          statement.executeUpdate();
          rset = statement.executeQuery(STMTPion3);
          isLast = rset.last();
          nbLignes = rset.getRow();
          rset.beforeFirst();
          if(nbLignes != 0)
            this.isValid = false;
          else
            this.isValid = true;
        }
        // System.out.println(nbLignes);
        rset.close();
        // System.out.println(this.isValid);

      }

    } catch(SQLException e) {
            System.err.println("failed");
            e.printStackTrace();
      }

  }

  public boolean getIsValid() {
    return this.isValid;
  }

  private void dumpResultSet(ResultSet rset) throws SQLException {
    ResultSetMetaData rsetmd = rset.getMetaData();
    int i = rsetmd.getColumnCount();
    for (int k=1;k<=i;k++)
      System.out.print(rsetmd.getColumnName(k) + "\t");
    System.out.println();
    while (rset.next()) {
      for (int j = 1; j <= i; j++) {
        System.out.print(rset.getString(j) + "\t");
      }
      System.out.println();
    }
  }


  public static void main(String args[]) {
    Connect co = new Connect();
    Connection conn = co.getConnection();
    int posY = 2;
    int oldY = 1;
    String posX = "B";
    String oldX = "A";
    int numRencontre = 1;
    String nomTour = "qualifications";
    String couleur = "blanc";
    new VerifPion(conn, posY, oldY, posX, oldX, numRencontre, nomTour, couleur);
    co.closeConnection();
  }
}
