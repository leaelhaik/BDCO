import java.sql.ResultSet;
import java.sql.SQLException;

import connection.insert.InsertionJoueur;
import connection.MultipleQueries;
import connection.Queries;


public class TestVerif {

	private static MultipleQueries queries;
	
	
	
	public static void main(String args[]) {
		
		Queries.queries = new MultipleQueries();
		
		InsertionJoueur ij = new InsertionJoueur();
		ij.insereJoueur("azert","do","rue de lensimag "+ (char)(int)(70+1) +"", "01011991");
		/*ResultSet rs = queries.getResult("select * from Joueur ");
		try {
			while (rs.next()) {
				System.out.println(rs.getString("prenomJoueur"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Coucou");
			e.printStackTrace();
		}*/
		
		Queries.queries.closeConnection();
	}
}
