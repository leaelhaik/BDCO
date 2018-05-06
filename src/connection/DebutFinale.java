package connection;
import java.sql.*;
import connection.MultipleQueries;

public class DebutFinale {
    private int[] tabClassement = new int[8];

    static final String STMT ="Select idJoueur from Rencontre where nomTour='demFinale'";
    public DebutFinale() {
        int i = 0;
        ResultSet rsetFin = Queries.queries.getResult("Select idJoueur from Rencontre where nomTour='demFinale'");
        try {
            while (rsetFin.next()) {
                tabClassement[i] = rsetFin.getInt(1);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int[] getClassement() {
        return tabClassement;
    }
}
