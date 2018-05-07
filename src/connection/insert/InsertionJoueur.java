package connection.insert;
import connection.MultipleQueries;
import connection.Queries;

import java.sql.*;

import connection.MultipleQueries;

public class InsertionJoueur {
  public int id=0;

  public InsertionJoueur() {
  }

  public boolean verifInsertion(String nom, String prenom) {
      ResultSet rset1 = Queries.queries.getResult("select idJoueur from joueur where nomJoueur= \'" + nom+"\' and prenomJoueur= \'"+prenom+"\'");
      
      
      try {
		rset1.next();
		return true;
	} catch (SQLException e) {
		//e.printStackTrace();
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
