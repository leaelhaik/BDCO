import java.sql.*;

public class verificationTour{

  public void VerifDemi{

    static final String STMT = "select Count(DISTINCT numRencontre),nomTour from Rencontre where nomTour="demiFinale";";
    //verifier qu'il s'agit bien de 2 rencontres

    static final String STMT = "select Count(DISTINCT idJoueur),nomTour,numRencontre from Rencontre where nomTour="demiFinale" group by numRencontre;";
    //verifier qu'il s'agit de 2 à chaque fois

    //verification que le joueur ne joue qu'une seule rencontre par tour autre que les qualifications
    static final String STMT = "select Count(DISTINCT numRencontre),nomTour,idJoueur from Rencontre where nomTour="demiFinale" group by idJoueur;";
    // rest.getInt(1)==1
  }

  public void VerifQuart{

    static final String STMT = "select Count(DISTINCT numRencontre),nomTour from Rencontre where nomTour="quartFinale";";
        //verifier qu'il s'agit bien de 4 rencontres

    static final String STMT = "select Count(DISTINCT idJoueur),nomTour,numRencontre from Rencontre where nomTour="quartFinale" group by numRencontre;";
    //verifier qu'il s'agit de 2 à chaque fois

    //verification que le joueur ne joue qu'une seule rencontre par tour autre que les qualifications
    static final String STMT = "select Count(DISTINCT numRencontre),nomTour,idJoueur from Rencontre where nomTour="quartFinale" group by idJoueur;";
    // rest.getInt(1)==1
  }

  public void VerifFinale{

    static final String STMT = "select Count(DISTINCT numRencontre),nomTour from Rencontre where nomTour="finale";";
        //verifier qu'il s'agit bien d'une rencontre

    static final String STMT = "select Count(DISTINCT idJoueur),nomTour,numRencontre from Rencontre where nomTour="finale" group by numRencontre;";
    //verifier qu'il s'agit de 2 à chaque fois

    //verification que le joueur ne joue qu'une seule rencontre par tour autre que les qualifications
    static final String STMT = "select Count(DISTINCT numRencontre),nomTour,idJoueur from Rencontre where nomTour="finale" group by idJoueur;";
    // rest.getInt(1)==1
  }

  public void VerifQualif{
    static final String STMT = "select Count(idJoueur) from Joueur;";
    // rset.getInt(1) - 1 == nombre de parties jouées pour les qualifications
    Statement stmt = conn.createStatement();
    ResultSet rset = stmt.executeQuery(STMT);

    int m = somme(rset.getInt(1)-1);

    static final String STMT = "select Count(DISTINCT numRencontre),nomTour from Rencontre where nomTour="qualifications";";
    //verifier qu'il s'agit bien d'une rencontre

    static final String STMT = "select Count(DISTINCT idJoueur),nomTour,numRencontre from Rencontre where nomTour="qualifications" group by numRencontre;";
    //verifier qu'il s'agit de 2 à chaque fois

    //verification que le joueur joue rset.getInt(1) - 1
    static final String STMT = "select Count(DISTINCT numRencontre),nomTour,idJoueur from Rencontre where nomTour="qualifications" group by idJoueur;";
    // rest.getInt(1)== rset.getInt(1) - 1

  }


}
