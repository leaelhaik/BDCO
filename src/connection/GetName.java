package connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetName {
  private String nom="";
  private String prenom="";
  private String date = "";
  private String adresse = "";

	public GetName(int id) {
		try {
			ResultSet rset = Queries.queries.getResult("select * from Joueur where idJoueur="+id+"");
      while(rset.next()){
        this.nom = rset.getString(2);
        this.prenom = rset.getString(3);
        this.date = rset.getString(4);
        this.adresse = rset.getString(5);
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

    public String getAdresse() {
        return adresse;
    }

    public String getDate() {
        return date;
    }
}
