import java.sql.*;
public class CreateRencontre {
static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
static final String USER = "dhouibd"; // A remplacer pour votre compte
static final String PASSWD = "dhouibd";
static final String STMT1 = "insert into Rencontre(nomTour,numRencontre) Values('finale',1)";
static final String STMT2 = "insert into Rencontre(nomTour,numRencontre) Values('demiFinale',1)";
static final String STMT3 = "insert into Rencontre(nomTour,numRencontre) Values('demiFinale',2)";
static final String STMT4 = "insert into Rencontre(nomTour,numRencontre) Values('quartFinale',1)";
static final String STMT5 = "insert into Rencontre(nomTour,numRencontre) Values('quartFinale',2)";
static final String STMT6 = "insert into Rencontre(nomTour,numRencontre) Values('quartFinale',3)";
static final String STMT7 = "insert into Rencontre(nomTour,numRencontre) Values('quartFinale',4)";
static final String STMT8 = "insert into Rencontre(nomTour,numRencontre) Values('qualifications',1)";
static final String STMT9 = "select count(idJoueur) from Joueur";

public CreateRencontre() {
try {
// Enregistrement du driver Oracle
  System.out.print("Loading Oracle driver... ");
  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
  System.out.println("loaded");
  // Etablissement de la connection
  System.out.print("Connecting to the database... ");
  Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
  System.out.println("connected");
  // Creation de la requete
  Statement stmt = conn.createStatement();
  // Execution de la requete
  ResultSet rset1 = stmt.executeQuery(STMT1);
  ResultSet rset2 = stmt.executeQuery(STMT2);
  ResultSet rset3 = stmt.executeQuery(STMT3);
  ResultSet rset4 = stmt.executeQuery(STMT4);
  ResultSet n = stmt.executeQuery(STMT9); //le nombre de joueurs, faire une boucle pour les qualifs

  stmt.close();
  conn.close();
} catch (SQLException e) {
    System.err.println("failed");
    e.printStackTrace(System.err);
  }
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
    new SimpleQuery();
  }
}
