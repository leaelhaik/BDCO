package connection;
import java.sql.*
import java.util.ArrayList;
import java.util.List;

public class GetAllRencontres {
    static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
    static final String USER = "dhouibd"; // A remplacer pour votre compte
    static final String PASSWD = "dhouibd";
    static final String STMT = "SELECT rencontres.numRencontre FROM JournalCoups WHERE Rencontre.Joue.Joueur.idJoueur" +
            " =?";

    private ArrayList<> listeRencontres;

    public GetAllRencontres(int idJoueur, Connection conn) {
        try {
            // Enregistrement du driver Oracle
            // System.out.print("Loading Oracle driver... ");
            // DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // System.out.println("loaded");
            // // Etablissement de la connection
            // System.out.print("Connecting to the database... ");
            // Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
            // System.out.println("connected");
            // Creation de la requete
            // Statement stmt = conn.createStatement();

            PreparedStatement sel = conn.prepareStatement(STMT);
            sel.setInt(1,idJoueur);
            sel.executeUpdate();

            ResultSet rset = sel.executeQuery(STMT);
            conn.commit();
            listeRencontres = new ArrayList<>();
            while(!(rset.isLast())){
                listeRencontres.add(rset.getInt(1));
                rset.next();
            }

            // Affichage du resultat
            //dumpResultSet(rset);
            // Fermeture
            rset.close();
            sel.close();
            conn.close();

        }
        catch (SQLException e) {
            System.err.println("failed");
            e.printStackTrace(System.err);
        }
    }

    private void dumpResultSet(ResultSet rset) throws SQLException {
        ResultSetMetaData rsetmd = rset.getMetaData();
        int i = rsetmd.getColumnCount();
        // for (int k=1;k<=i;k++)
        //   System.out.print(rsetmd.getColumnName(k) + "\t");
        // System.out.println();
        while (rset.next()) {
            for (int j = 1; j <= i; j++) {
                System.out.print(rset.getString(j) + "\t");
            }
            System.out.println();
        }
    }

    public ArrayList<int> getListeRencontres(){
        return this.listeRencontres;
    }

}
