import java.sql.ResultSet;
import java.sql.SQLException;

import connection.insert.InsertionJoueur;
import connection.MultipleQueries;


public class TestVerif {

	private static MultipleQueries queries;
	
	
	
	public static void main(String args[]) {
		
		queries = new MultipleQueries();
		
		InsertionJoueur ij = new InsertionJoueur("azert","do","rue de lensimag", "01011991", queries);
		InsertionJoueur ik = new InsertionJoueur("zkjb","lj","rue de phelma", "010119912", queries);
		InsertionJoueur il = new InsertionJoueur("ajhds","klw","rue de la chmie", "01011993", queries);
		ResultSet rs = queries.getResult("select * from Joueur ");
		try {
			while (rs.next()) {
				System.out.println(rs.getString("prenomJoueur"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Coucou");
			e.printStackTrace();
		}
		
		queries.closeConnection();
	}
}
