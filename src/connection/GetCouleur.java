package connection;
import java.sql.*;

//permet de retourner la couleur d'un joueur. utilisée par le controlleur GetCouleur
//marche sous reserve que connection marche bien

public class GetCouleur {
	
	
	private String couleur;
	
	public GetCouleur(int idJoueur, Connection conn) {
		try {
			// Enregistrement du driver Oracle
			  // System.out.print("Loading Oracle driver... ");
			  // DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			  // System.out.println("loaded");
			  // // Etablissement de la connection
			  // System.out.print("Connecting to the database... ");
			  // Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
			  // System.out.println("connected");
			  // Creation de la requete
			  // Statement stmt = conn.createStatement();
			
			  PreparedStatement sel = conn.prepareStatement(STMT);
			  sel.setInt(1,idJoueur);
			  sel.executeUpdate();
			
			  ResultSet rset = Queries.queries.getResult("select couleur from joueur where joueur.idjoueur="+idJoueur+ "");
			  
			  this.couleur = rset.getString(1);
			
			  // Fermeture
			  rset.close();
		  
		} 
		catch (SQLException e) {
			    System.err.println("failed");
			    e.printStackTrace(System.err);
		  }
	}


	public String getCouleur(){
		return this.couleur;
	}
}
