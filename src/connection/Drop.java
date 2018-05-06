package connection.drop;
import java.sql.*;
import connection.MultipleQueries;

public class Drop{

  public Drop() {
      
  }

  public void DropTables(){
    this.dropHistorique();
    this.dropPiece();
    this.dropAffectationCouleur();
    this.dropRencontre();
    this.dropTour();
    this.dropJoueur();
    this.dropCouleur();
  }

  public void dropPiece() {
    ResultSet rsetDropRencontre = Queries.queries.getResult("Drop TABLE Piece");
  }

  public void dropTour() {
    ResultSet rsetDropTour = Queries.queries.getResult("Drop TABLE Tour");
  }

  public void dropRencontre() {
    ResultSet rsetDropRencontre = Queries.queries.getResult("Drop TABLE Rencontre");
  }

  public void dropJoueur(){
    ResultSet rsetDropJoueur = Queries.queries.getResult("Drop TABLE Joueur");
  }

  public void dropCouleur(){
    ResultSet rsetDropCouleur = Queries.queries.getResult("Drop TABLE Couleur");
  }

  public void dropHistorique(){
    ResultSet rsetDropHistorique = Queries.queries.getResult("Drop TABLE Historique");
  }

  public void dropAffectationCouleur(){
    ResultSet rsetDropHistorique = Queries.queries.getResult("Drop TABLE AffectationCouleur");
  }

}
