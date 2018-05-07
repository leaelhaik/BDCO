package connection;
import java.sql.*;
import connection.MultipleQueries;
//permet de retourner la couleur d'un joueur. utilisée par le controlleur GetCouleur
//marche sous reserve que connection marche bien

public class GetCouleur {

	private String couleur;
	private MultipleQueries queries;

	public GetCouleur(int idJoueur) {
		ResultSet rset = queries.getResult("select couleur from joueur where idJoueur=" + idJoueur + "");
		try {
			rset.next();
			this.couleur = rset.getString(1);
		} catch (SQLException e) {
			System.err.println("failed au niveau de GetCouleur");
			e.printStackTrace(System.err);
		}
	}

	public String getCouleur(){
		return this.couleur;
	}
}
//		try {
//			// Enregistrement du driver Oracle
//			  // System.out.print("Loading Oracle driver... ");
//			  // DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//			  // System.out.println("loaded");
//			  // // Etablissement de la connection
//			  // System.out.print("Connecting to the database... ");
//			  // Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
//			  // System.out.println("connected");
//			  // Creation de la requete
//			  // Statement stmt = conn.createStatement();
//
//			  PreparedStatement sel = conn.prepareStatement(STMT);
//			  sel.setInt(1,idJoueur);
//			  sel.executeUpdate();
//
//			  ResultSet rset = sel.executeQuery(STMT);
//			  conn.commit();
//
//			  this.couleur = rset.getString(1);
//
//			  // Affichage du resultat
//			  //dumpResultSet(rset);
//			  // Fermeture
//			  rset.close();
//			  sel.close();
//			  conn.close();
//
//		}
//		catch (SQLException e) {
//			    System.err.println("failed");
//			    e.printStackTrace(System.err);
//		  }
//	}
//
//	private void dumpResultSet(ResultSet rset) throws SQLException {
//	  ResultSetMetaData rsetmd = rset.getMetaData();
//	  int i = rsetmd.getColumnCount();
//	  // for (int k=1;k<=i;k++)
//	  //   System.out.print(rsetmd.getColumnName(k) + "\t");
//	  // System.out.println();
//	  while (rset.next()) {
//		for (int j = 1; j <= i; j++) {
//		  System.out.print(rset.getString(j) + "\t");
//		}
//		System.out.println();
//	  }
//	}
//	public String getCouleur(){
//		return this.couleur;
//	}
//}
