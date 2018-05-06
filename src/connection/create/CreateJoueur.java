package connection.create;
import java.sql.*;
import connection.MultipleQueries;

public class CreateJoueur {
  private MultipleQueries queries;

/*
    try {
      // Execution de la requete
    } catch (SQLException e) {
      System.err.println("failed");
      e.printStackTrace(System.err);
    }
*/
  public CreateJoueur() {
    ResultSet rsetCreateJoueur = queries.getResult("CREATE TABLE Joueur(idJoueur integer, nomJoueur character varying(30),prenomJoueur character varying(30),dateNaissance DATE,adresseJoueur character varying(30),PRIMARY KEY(idJoueur))");
  }
}
