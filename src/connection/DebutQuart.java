package connection;
import java.sql.*;

public class DebutQuart {
  private int[] tabClassement = new int[8];
  public DebutQuart() {
    int i=0;
    ResultSet rsetQuart = Queries.queries.getResult("Select idJoueur,count(nomTour) from Rencontre where nomTour='qualifications' group by(idJoueur) ORDER by count(nomTour) ASC"); //limit 8
    try {
      while (rsetQuart.next()) {
        tabClassement[i] = rsetQuart.getInt(1);
        i++;
      }
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }

  public int[] getClassement(){
    return this.tabClassement ;
  }

}
