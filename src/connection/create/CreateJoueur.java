package connection.create;
import java.sql.*;
import connection.MultipleQueries;

public class CreateJoueur{
  private MultipleQueries queries;

  public CreateJoueur() {
	  queries = new MultipleQueries();
    ResultSet rsetCreateJoueur = queries.getResult("CREATE TABLE Joueur(idJoueur integer, nomJoueur character varying(30),prenomJoueur character varying(30),dateNaissance character varying(30),adresseJoueur character varying(30),PRIMARY KEY(idJoueur))");
  }

 

}
