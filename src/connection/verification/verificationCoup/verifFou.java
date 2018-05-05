//package connection.verification.verificationCoup;

//import connection.verification.verificationTable.Connect;
import java.sql.*;
import java.lang.Character;
import java.io.*;

public class VerifFou {

  private boolean isValid = false;
  private String STMTFou = "";

  public VerifFou(Connection conn, int posY, int oldY, String posX, String oldX, int numRencontre, String nomTour) {

    try {
      byte[] tabOldX = null;
      byte[] tabPosX = null;
      int nbLignes = 0;

      try {
        tabOldX = oldX.getBytes("UTF-8");
        tabPosX = posX.getBytes("UTF-8");
      } catch (IOException ioe) {

      }

      if(Math.abs(tabOldX[0]-tabPosX[0])==Math.abs(oldY-posY)) {

        STMTFou = "select idPiece from piece where numRencontre=? and nomTour=? and abs(ascii(posX)-?)=abs(posY-?) and posX between ? and ? and posY between ? and ?";

        int type = ResultSet.TYPE_SCROLL_INSENSITIVE;
        int mode = ResultSet.CONCUR_UPDATABLE;
        boolean isLast;

        ResultSet rset;

        PreparedStatement statement = conn.prepareStatement(STMTFou,type,mode);
        statement.setInt(1, numRencontre);
        statement.setObject(2, nomTour, Types.VARCHAR);
        statement.setInt(3, tabOldX[0]);
        statement.setInt(4, oldY);
        if(tabPosX[0] < tabOldX[0]) {
          statement.setObject(5, posX, Types.CHAR);
          statement.setObject(6, oldX, Types.CHAR);
        }
        else {
          statement.setObject(5, oldX, Types.CHAR);
          statement.setObject(6, posX, Types.CHAR);
        }
        if(posY < oldY) {
          statement.setInt(7, posY);
          statement.setInt(8, oldY);
        }
        else {
          statement.setInt(7, oldY);
          statement.setInt(8, posY);
        }
        statement.executeUpdate();
        rset = statement.executeQuery(STMTFou);
        isLast = rset.last();
        nbLignes = rset.getRow();
        rset.beforeFirst();

        System.out.println(nbLignes);
        if(nbLignes != 0)
          this.isValid = false;
        else
          this.isValid = true;
        rset.close();
        System.out.println(this.isValid);
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
    int posY = 1;
    int oldY = 8;
    String posX = "A";
    String oldX = "H";
    int numRencontre = 1;
    String nomTour = "qualifications";
    new VerifFou(conn, posY, oldY, posX, oldX, numRencontre, nomTour);
    co.closeConnection();
  }
}
