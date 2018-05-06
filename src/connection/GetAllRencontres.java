package connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetAllRencontres {

    static final String STMT = "SELECT rencontres.numRencontre FROM JournalCoups WHERE Rencontre.Joue.idJoueur=?";

    private ArrayList<Integer> listeRencontres;

    public GetAllRencontres(int idJoueur, Connection conn) {
        try {
            ResultSet rset = Queries.queries.getResult("SELECT rencontres.numRencontre FROM JournalCoups WHERE Rencontre.Joue.idJoueur="+idJoueur+"");
            
            listeRencontres = new ArrayList<>();
            while(!(rset.isLast())){
                listeRencontres.add(rset.getInt(1));
                rset.next();
            }

            // Fermeture
            rset.close();

        }
        catch (SQLException e) {
            System.err.println("failed");
            e.printStackTrace(System.err);
        }
    }


    public ArrayList<Integer> getListeRencontres(){
        return this.listeRencontres;
    }

}
