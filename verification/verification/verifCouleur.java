import java.sql.*;

import connection.Queries;

public class verifCouleur {

  public verifCouleur() {
	    ResultSet rset = Queries.queries.getResult("select * from Couleur");
  }

  public void afficheCouleur() throws SQLException {

    // Parcours de la TABLE
    System.out.println("*************************");
    System.out.println("Données contenues dans la table Couleur : ");

    dumpResultSet(rset);
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
    new verifCouleur();
  }
}
