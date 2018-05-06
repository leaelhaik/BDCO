package connection.create;
import java.sql.*;
import connection.MultipleQueries;

public class CreateRencontre{
  private MultipleQueries queries;

  public CreateRencontre() {
	  queries = new MultipleQueries();
    ResultSet rsetCreateRencontre = queries.getResult("CREATE TABLE Rencontre(numRencontre integer not null ,nomTour varchar(20) NOT NULL,idJoueur integer NOT NULL,PRIMARY KEY(numRencontre, nomTour),FOREIGN KEY(nomTour) REFERENCES Tour(nomTour),FOREIGN KEY(idJoueur) REFERENCES Joueur(idJoueur))");
  }


}
