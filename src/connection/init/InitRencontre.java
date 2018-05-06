package connection.init;
import java.sql.*;
import connection.MultipleQueries;

public class InitRencontre {

  public InitRencontre() {
    ResultSet rsetInitCouleur1 = Queries.queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values('1', 'finale', '0')");
    ResultSet rsetInitCouleur2 = Queries.queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values('1','demiFinale', '0')");
    ResultSet rsetInitCouleur1 = Queries.queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values('2','demiFinale', '0')");
    ResultSet rsetInitCouleur2 = Queries.queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values('1','quartFinale', '0')");
    ResultSet rsetInitCouleur2 = Queries.queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values('2','quartFinale', '0')");
    ResultSet rsetInitCouleur2 = Queries.queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values('3','quartFinale', '0')");
    ResultSet rsetInitCouleur2 = Queries.queries.getResult("insert into Rencontre(numRencontre, nomTour, idJoueur) Values('4','quartFinale', '0')");
  }
}
