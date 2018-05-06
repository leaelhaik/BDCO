package connection.drop;
import java.sql.*;
import connection.MultipleQueries;

public class DropJoueur{
  private MultipleQueries queries;

  public DropJoueur() {
    ResultSet rsetDropJoueur = queries.getResult("Drop TABLE Joueur");
  }

  public static void main(String args[]) {
    new DropJoueur();
  }

}
