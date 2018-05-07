package connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetAllRencontres {

    private ArrayList<Integer> listeRencontres;

    public GetAllRencontres(int idJoueur, String nomTour) {
        try {
            //la clé c'est nomTour et numRencontre, pas juste numRencontre
            ResultSet rset = Queries.queries.getResult("SELECT numRencontre FROM AffectationCouleur where idJoueur="+idJoueur+", nomTour=\'"+nomTour+"\'");

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
