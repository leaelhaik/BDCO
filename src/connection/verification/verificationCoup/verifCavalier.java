//package connection.verification.verificationCoup;

//import connection.verification.verificationTable.Connect;
import java.sql.*;
import java.lang.Character;
import java.io.*;

public class VerifCavalier {

  private boolean isValid = false;
  private String STMTCavalier = "";

  public VerifCavalier(Connection conn, int posY, int oldY, String posX, String oldX, int numRencontre, String nomTour, String couleur) {

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

        STMTCavalier = "select idPiece from Piece where numRencontre = ? and nomTour = ? and couleur = ? and posX = ? and posY = ?";

        int type = ResultSet.TYPE_SCROLL_INSENSITIVE;
        int mode = ResultSet.CONCUR_UPDATABLE;
        boolean isLast;

        ResultSet rset=null;

        PreparedStatement statement = conn.prepareStatement(STMTCavalier, type, mode);
        statement.setInt(1, numRencontre);
        statement.setObject(2, nomTour, Types.VARCHAR);
        statement.setString(3, couleur);
        statement.setObject(4, posX, Types.CHAR);
        statement.setInt(5, posY);
        statement.executeUpdate();
        rset = statement.executeQuery(STMTCavalier);
        isLast = rset.last();
        nbLignes = rset.getRow();
        rset.beforeFirst();
        if(nbLignes != 0)
          this.isValid = false;
        else
          this.isValid = true;

        System.out.println(nbLignes);
        rset.close();
        System.out.println(this.isValid);

      }

    } catch(SQLException e) {
            System.err.println("failed");
            e.printStackTrace();
      }
      System.out.println(this.isValid);

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
    String posX = "A";
    String oldX = "C";
    int numRencontre = 1;
    String nomTour = "qualifications";
    String couleur = "blanc";
    new VerifCavalier(conn, posY, oldY, posX, oldX, numRencontre, nomTour, couleur);
    co.closeConnection();
  }
}
