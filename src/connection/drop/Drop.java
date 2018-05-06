package connection.drop;
import java.sql.*;
import connection.MultipleQueries;

public class Drop{
  private MultipleQueries queries;

  public Drop() {
    queries = new MultipleQueries();
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
    ResultSet rsetDropRencontre = queries.getResult("Drop TABLE Piece");
  }

  public void dropTour() {
    ResultSet rsetDropTour = queries.getResult("Drop TABLE Tour");
  }

  public void dropRencontre() {
    ResultSet rsetDropRencontre = queries.getResult("Drop TABLE Rencontre");
  }

  public void dropJoueur(){
    ResultSet rsetDropJoueur = queries.getResult("Drop TABLE Joueur");
  }

  public void dropCouleur(){
    ResultSet rsetDropCouleur = queries.getResult("Drop TABLE Couleur");
  }

  public void dropHistorique(){
    ResultSet rsetDropHistorique = queries.getResult("Drop TABLE Historique");
  }

  public void dropAffectationCouleur(){
    ResultSet rsetDropHistorique = queries.getResult("Drop TABLE AffectationCouleur");
  }

}
