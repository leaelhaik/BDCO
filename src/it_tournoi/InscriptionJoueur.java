package it_tournoi;

import java.util.Scanner;
import java.sql.Connection;

import connection.MultipleQueries;
import connection.insert;
import connection.verification.verificationTable;

public class InscriptionJoueur {

  private String nom;
  private String prenom;
  private String adresse;
  private String date;
  private MultipleQueries queries;

  public InscriptionJoueur() {

    Scanner sc = new Scanner(System.in);
    this.queries = new MultipleQueries();
    this.getNom(sc);
    this.getPrenom(sc);
    this.getAdresse(sc);
    this.getDate(sc);
    InsertionJoueur insert = new InsertionJoueur(nom, prenom, adresse, date, queries);

    Connection conn = queries.getConnection();
    new VerifJoueur(conn);
    queries.closeConnection();
  }

  public void getNom(Scanner sc) {
    System.out.println("Veuillez saisir votre nom : ");
    String str = sc.nextLine();
    this.setNom(str);
  }

  public void getPrenom(Scanner sc) {
    System.out.println("Veuillez saisir votre prenom : ");
    String str = sc.nextLine();
    this.setPrenom(str);
  }

  public void getAdresse(Scanner sc) {
    System.out.println("Veuillez saisir votre adresse : ");
    String str = sc.nextLine();
    this.setAdresse(str);
  }

  public void getDate(Scanner sc) {
    System.out.println("Veuillez saisir votre date de naissance (AAAA-MM-JJ) : ");
    String str = sc.nextLine();
    this.setDate(str);
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String setDate(String date) {
    this.date = date;
  }


}
