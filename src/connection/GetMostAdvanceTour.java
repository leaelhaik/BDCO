package connection;
import java.sql.*;

public class GetMostAdvanceTour {


	private String nomTour;

	public GetMostAdvanceTour(Connection conn) {
		try {
			  ResultSet rset = Queries.queries.getResult("select count(distinct nomTour) from Historique");
			  int nbNomTour = Integer.parseInt(rset.getString(1));

			  switch(nbNomTour){
			  	case 1 : this.nomTour = "qualifications";
			  	break;
			  	case 2 : this.nomTour = "quartFinale";
			  	break;
			  	case 3 : this.nomTour = "demiFinale";
		  		break;
			  	case 4 : this.nomTour = "finale";
		  		break;
		  		default : this.nomTour = "erreur";
			  }


			  // Fermeture
			  rset.close();

		}
		catch (SQLException e) {
			    System.err.println("failed");
			    e.printStackTrace(System.err);
		  }
	}



	public String getNomTour() {
		return this.nomTour;
	}
}
