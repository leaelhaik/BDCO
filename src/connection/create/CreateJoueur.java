package connection.drop;
import java.sql.*;
import connection.MultipleQueries;

public class CreateJoueur{
  private MultipleQueries queries;

  public CreateJoueur() {
    ResultSet rsetCreateJoueur = queries.getResult("CREATE TABLE Joueur(idJoueur integer, nomJoueur character varying(30),prenomJoueur character varying(30),dateNaissance DATE,adresseJoueur character varying(30),PRIMARY KEY(idJoueur))");
  }

  public static void main(String args[]) {
    new CreateJoueur();
  }

}
