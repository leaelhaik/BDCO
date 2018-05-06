package connection;

import java.sql.Connection;
import java.sql.ResultSet;

public class MultipleQueries {
    private Connect connect;

    public MultipleQueries() {
        connect = new Connect();
    }

    public ResultSet getResult(String query) {
        SimpleQuery sq = new SimpleQuery(query, connect.getConnection());
        System.out.println("Executing query : " + query);
        return sq.getResult();
    }

    public void closeConnection() {
        connect.closeConnection();
    }

    public Connection getConnection() {
    	return connect.getConnection();
    }
}
