package connection;
import java.sql.*;

public class InsertionJoueur {
  static final String STMT = "insert into joueur values(?,?,?,?,?)";
  public int id = 0;
  static final String STMTVerif = "select idJoueur from joueur where nomJoueur=? and prenomJoueur=? ";
  private MultipleQueries queries;

  public InsertionJoueur() {
    ResultSet rsetSel = queries.getResult("select idJoueur from joueur where idJoueur=max(idJoueur)");
    id=rsetSel.getString("idJoueur");
  }

  public boolean verifInsertion(String nom, String prenom) {
      ResultSet rset1 = queries.getResult("select idJoueur from joueur where nomJoueur= " + nomJoueur+"and prenomJoueur="+prenomJoueur+"");
      if(rset.next()){
        return false;
      }
      else{
        return true;
      }
  }

  public boolean insereJoueur(String nom, String prenom, String adresse, Date date) {
    ResultSet rsetInsert = queries.getResult("insert into joueur values("+id+","+nomJoueur+","+prenomJoueur+","+date+","+adresse+")");
  }

}
