  package connection.create;
  import java.sql.*;
  import connection.MultipleQueries;

  public class CreateAffectationCouleur{
    private MultipleQueries queries;

    public CreateAffectationCouleur() {
      ResultSet rsetCreateAffectationCouleur = queries.getResult("CREATE TABLE AffectationCouleur(idJoueur integer NOT NULL,nomCouleur character varying(5),nomTour varchar(20) NOT NULL,numRencontre integer not null,primary key(idJoueur,nomTour,numRencontre,nomCouleur),foreign key(nomCouleur) REFERENCES Couleur(nomCouleur),foreign key(numRencontre,nomTour) REFERENCES Rencontre(numRencontre,nomTour),foreign key(idJoueur) REFERENCES Joueur(idJoueur))");
    }

    public static void main(String args[]) {
      new CreateAffectationCouleur();
    }

  }
