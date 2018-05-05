package connection;
import java.sql.*;




//selection de l'id joueur qui apparait le plus dans la table rencontre
public class verificationTournoi{
    //sélection des 8 meilleurs pour les quarts de finale
    static final String STMT ="Select idJoueur,nomTour,count(numRencontre) from Rencontre group by(idJoueur) LIMIT 0,8 ORDER by count(numRencontre) ASC;";

    //selection des meilleurs pour les demi et la finale
    static final String STMT ="Select idJoueur,nomTour,count(numRencontre) from Rencontre group by(idJoueur);";
}
