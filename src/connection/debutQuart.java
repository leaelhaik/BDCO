package connection;
import java.sql.*;

public class DebutQuart {
  private int[] tabClassement = new int[8];
  public DebutQuart(Connection conn) {
    int i=0;
    ResultSet rsetQuart = Queries.queries.getResult("Select idJoueur,count(nomTour) from Rencontre where nomTour='qualifications' group by(idJoueur) LIMIT 0,8 ORDER by count(nomTour) ASC");
    while(rsetQuart.next()){
      tabClassement[i]=rset.getInt(1);
      i++;
    }
  }

  public int[] getClassement(){
    return this.tabClassement ;
  }

}
