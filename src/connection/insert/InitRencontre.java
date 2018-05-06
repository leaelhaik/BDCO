package connection.insert;
import java.sql.*;

public class InitRencontre {
  private MultipleQueries queries;

  static final String STMT2 = "insert into Rencontre(numRencontre, nomTour, idJoueur) Values(1,'demiFinale', null)";
  static final String STMT3 = "insert into Rencontre(numRencontre, nomTour, idJoueur) Values(2,'demiFinale', null)";
  static final String STMT4 = "insert into Rencontre(numRencontre, nomTour, idJoueur) Values(1,'quartFinale', null)";
  static final String STMT5 = "insert into Rencontre(numRencontre, nomTour, idJoueur) Values(2,'quartFinale', null)";
  static final String STMT6 = "insert into Rencontre(numRencontre, nomTour, idJoueur) Values(3,'quartFinale', null)";
  static final String STMT7 = "insert into Rencontre(numRencontre, nomTour, idJoueur) Values(4,'quartFinale', null)";
  static final String STMTQualif = "insert into Rencontre(numRencontre, nomTour, idJoueur) Values(?,'qualifications', null)";

  public InitRencontre() {
    ResultSet rset1 = queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values(1,'demiFinale', null)");
    ResultSet rset2 = queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values(2,'demiFinale', null)");
    ResultSet rset3 = queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values(1,'quartFinale', null)");
    ResultSet rset4 = queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values(2,'quartFinale', null)");
    ResultSet rset5 = queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values(3,'quartFinale', null)");
    ResultSet rset6 = queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values(4,'quartFinale', null)");
    ResultSet rset8 = queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values(1,'finale', null)");

  }

}
