
import connection.MultipleQueries;
import connection.Queries;
import ig_echiquier.*;



public class TestIGEchiquier {
	
	private static ExecutablePartie exe1;


	public static void main(String args[]) {
		Queries.queries= new MultipleQueries();
		exe1 = new ExecutablePartie("Echiquier", 700, 700);
		Queries.queries.closeConnection();
		
	}

}