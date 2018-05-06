import java.sql.ResultSet;
import java.sql.SQLException;

import connection.MultipleQueries;


public class TestVerif {

	private static MultipleQueries queries;
	
	
	
	public static void main(String args[]) {
		
		queries = new MultipleQueries();
		int id = 1;
		String str = "do";
		
		ResultSet rs = queries.getResult("select * from Piece");
		try {
			while (rs.next()) {
				System.out.println(rs.getString("typePiece"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Coucou");
			e.printStackTrace();
		}
	}
}
