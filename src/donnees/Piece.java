package donnees;

import java.sql.*;

public class Piece {

	static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
	static final String USER = "dhouibd"; // A remplacer pour votre compte
	static final String PASSWD = "dhouibd";
	
	static final String STMT = "SELECT typePiece, couleur FROM Piece WHERE posX = ?, posY = ?, numRencontre = ?, nomTour = ?;";

	private Couleur couleur;
	private String nomPiece;

	public Piece(Couleur coul, String str) {
		this.couleur=coul;
		this.nomPiece=str;
	}

	public Piece(String posX, int posY, int numRencontre, String nomTour) {

		try {
			// Enregistrement du driver Oracle
			System.out.print("Loading Oracle driver... ");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("loaded");
			// Etablissement de la connection
			System.out.print("Connecting to the database... ");
			Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
			System.out.println("connected");
			conn.setAutoCommit(false);
			
			PreparedStatement piec = conn.prepareStatement(STMT);
			piec.setString(1,posX);
			piec.setInt(2,posY);
			piec.setInt(3,numRencontre);
			piec.setString(4,nomTour);
			
			piec.executeUpdate();
			
			ResultSet rset = piec.executeQuery();
			
			conn.commit();

			// Parcours de la TABLE
			System.out.println("*************************");

			dumpResultSet(rset);

			this.nomPiece = rset.getString(1);
			
			Couleur couleur;
			if (rset.getString(2) == "blanc"){
				this.couleur = Couleur.blanc;
			}
			else {
				this.couleur = Couleur.noir;
			}

			// Fermeture
			rset.close();
			piec.close();
			conn.close();
		}

		catch (SQLException e) {
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

	public String getNomPiece() {
		return this.nomPiece;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}
}

/*
  public static String getPiece(String posX, int posY, int numRencontre, String nomTour) {

    try {
      // Enregistrement du driver Oracle
      System.out.print("Loading Oracle driver... ");
      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      System.out.println("loaded");
      // Etablissement de la connection
      System.out.print("Connecting to the database... ");
      Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
      System.out.println("connected");
      conn.setAutoCommit(false);
      String STMT = "select typePiece from Piece where posX = " + posX + ", posY = " + posY + ", numRencontre = " + numRencontre + ", nomTour = " + nomTour + "";
      Statement preparedStatement = conn.preparedStatement(STMT);
      // Creation de la requete
      Statement stmt = conn.createStatement();
      // Execution de la requete
      ResultSet rset = stmt.executeQuery(STMT);
      conn.commit();

      // Parcours de la TABLE
      System.out.println("*************************");
      System.out.println("Piece : ");

      dumpResultSet(rset);

      String idPiece = rset.getString(1);

      // Fermeture
      rset.close();
      stmt.close();
      conn.close();

      return idPiece;

    } catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
      }
  }

  public Couleur getCouleur(String posX, int posY, int numRencontre, String nomTour) {

    try {
      // Enregistrement du driver Oracle
      System.out.print("Loading Oracle driver... ");
      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      System.out.println("loaded");
      // Etablissement de la connection
      System.out.print("Connecting to the database... ");
      Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
      System.out.println("connected");
      conn.setAutoCommit(false);
      String STMT = "select Couleur from Piece where posX = " + posX + ", posY = " + posY + ", numRencontre = " + numRencontre + ", nomTour = " + nomTour + "";
      Statement preparedStatement = conn.preparedStatement(STMT);
      // Creation de la requete
      Statement stmt = conn.createStatement();
      // Execution de la requete
      ResultSet rset = stmt.executeQuery(STMT);
      conn.commit();

      // Parcours de la TABLE
      System.out.println("*************************");
      System.out.println("Couleur : ");

      dumpResultSet(rset);

      Couleur couleur;
      if (rset.getString(1) == "blanc"){
        couleur = Couleur.blanc;
      }
      else {
        couleur = Couleur.noir;
      }

      // Fermeture
      rset.close();
      stmt.close();
      conn.close();

      return couleur;
    }
    catch (SQLException e) {
        System.err.println("failed");
        e.printStackTrace(System.err);
    }
  }


}
 */
