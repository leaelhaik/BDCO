package connection;
import java.sql.*;

public class SimpleQuery {
	private Connection connection;
	private String query;
	private ResultSet rs;
	static final String STMT = "select * from emp";


	public SimpleQuery(String query, Connection connection){
		this.query = query;
		this.connection = connection;

		try {
			Statement stmt = connection.createStatement();
			this.rs = stmt.executeQuery(this.query);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public ResultSet getResult() {
		return this.rs;
	}

}