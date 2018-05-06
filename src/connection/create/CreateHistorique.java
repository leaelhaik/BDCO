package connection.create;
import java.sql.*;
import connection.MultipleQueries;

public class CreateHistorique{
  private MultipleQueries queries;

  public CreateHistorique() {
	  queries = new MultipleQueries();
    ResultSet rsetCreateHistorique = queries.getResult("CREATE TABLE Historique(idCoup integer not null,nomTour varchar(20) NOT NULL,numRencontre integer not null,posX character check(posX in ('A','B','C','D','E','F','G','H')),posY integer check(posY<9),oldX character check(oldX in ('A','B','C','D','E','F','G','H')), oldY integer check(oldY<9),primary key(idCoup),foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour))");
  }

 

}
