9package connection;
import java.sql.*;
import connection.MultipleQueries;

public class DebutDemi {
    private int[] tabClassement = new int[8];

    public DebutDemi() {
        int i =0;
        ResultSet rsetDemi = Queries.queries.getResult("select idJoueur from Rencontre where nomTour='quartFinale'");
        try {
        while (rsetDemi.next()) {
        tabClassement[i] = rsetDemi.getInt(1);
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
