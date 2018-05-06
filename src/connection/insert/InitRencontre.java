package connection.insert;
import connection.MultipleQueries;
import connection.Queries;
import java.sql.*;

public class InitRencontre {

  public InitRencontre() {
    ResultSet rset1 = Queries.queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values(1,'demiFinale', null)");
    ResultSet rset2 = Queries.queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values(2,'demiFinale', null)");
    ResultSet rset3 = Queries.queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values(1,'quartFinale', null)");
    ResultSet rset4 = Queries.queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values(2,'quartFinale', null)");
    ResultSet rset5 = Queries.queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values(3,'quartFinale', null)");
    ResultSet rset6 = Queries.queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values(4,'quartFinale', null)");
    ResultSet rset8 = Queries.queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values(1,'finale', null)");

  }

}
