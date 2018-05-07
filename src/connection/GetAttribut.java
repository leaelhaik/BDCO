package connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetAttribut {
  private ArrayList<Integer> listeId;

	public GetAttribut() {
		try {

			ResultSet rset = Queries.queries.getResult("select idJoueur from Joueur");
      while(rset.next()){
          listeId.add(rset.getInt(1));
      }

			// Fermeture
			rset.close();
		} catch (SQLException e) {
			System.err.println("failed");
			e.printStackTrace(System.err);
		}
	}

  public ArrayList<Integer> getListeId(){
      return this.listeId;
  }

}
