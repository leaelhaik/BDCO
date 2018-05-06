package connection.insert;
import connection.MultipleQueries;
import connection.Queries;

import java.sql.*;

import connection.MultipleQueries;

public class InsertionJoueur {
  static final String STMT = "insert into joueur values(?,?,?,?,?)";
  public int id=0;
  static final String STMTVerif = "select idJoueur from joueur where nomJoueur=? and prenomJoueur=? ";
  //private MultipleQueries queries;

  public InsertionJoueur() {
  }

  public boolean verifInsertion(String nom, String prenom) {
      ResultSet rset1 = Queries.queries.getResult("select idJoueur from joueur where nomJoueur= \'" + nom+"\' and prenomJoueur= \'"+prenom+"\'");
      try {
		if(rset1.next()){
		    return false;
		  }
		  else{
		    return true;
		  }
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}

  }

  public boolean insereJoueur(String nom, String prenom, String adresse, String date) {
  	ResultSet rset = Queries.queries.getResult("select count(idJoueur) from joueur");
	  try {
		  while (rset.next())
			  id=rset.getInt(1);
	  } catch (SQLException e) {
		  e.printStackTrace();
		  return true;
	  }
	  id ++;
	  String joueur = "insert into joueur values(" + id + ",\'" +nom+ "\' , \'" +prenom+ "\' , \'" +date+ "\' , \'" +adresse+ "\')";
	  ResultSet rsetInsert = Queries.queries.getResult(joueur);
	  return false;
  }
}
