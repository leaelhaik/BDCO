package connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetName {
  private String nom="";
  private String prenom="";

	public GetName(int id) {
		try {
			ResultSet rset = Queries.queries.getResult("select nomJoueur,prenomJoueur from Joueur where idJoueur="+id+"");
      while(rset.next()){
        this.nom = rset.getString(1);
        this.prenom = rset.getString(2);
      }
      }
		} catch (SQLException e) {
			System.err.println("failed");
			e.printStackTrace(System.err);
		}
	}

  public String getNom(){
      return this.nom;
  }

  public String getPrenom(){
    return this.prenom;
  }

}
