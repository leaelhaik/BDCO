//package connection.verification.verificationTable;
import java.sql.*;

/**
 *  Requete simple sans parametres
 */
public class SimpleQuery {

    private String query;
    private Connection connection;
    private ResultSet rs;

    /**
     * Constructeur
     * @param query requete a executer
     */
    public SimpleQuery(String query, Connection connection){
        this.query = query;
        this.connection = connection;

        try {
            Statement stmt = connection.createStatement();
            this.rs = stmt.executeQuery(this.query);
            connection.commit();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     *  @return le resultat de la requete
     */
    public ResultSet getResult(){
        return this.rs;
    }


}
