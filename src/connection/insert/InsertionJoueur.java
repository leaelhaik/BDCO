package connection.insert;
import java.sql.*;

import connection.MultipleQueries;

public class InsertionJoueur {
  static final String STMT = "insert into joueur values(?,?,?,?,?)";
  public int id=0;
  static final String STMTVerif = "select idJoueur from joueur where nomJoueur=? and prenomJoueur=? ";
  //private MultipleQueries queries;

  public InsertionJoueur(String nom, String prenom, String adresse, String date, MultipleQueries queries) {
      ResultSet rset = queries.getResult("select count(idJoueur) from joueur");
      try {
    	  while (rset.next())
    		  id=rset.getInt(1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  String joueur = "insert into joueur values(" + id + ",\'" +nom+ "\' , \'" +prenom+ "\' , \'" +date+ "\' , \'" +adresse+ "\')";
	  ResultSet rsetInsert = queries.getResult(joueur);
  }

  public boolean verifInsertion(String nom, String prenom, MultipleQueries queries) {
      ResultSet rset1 = queries.getResult("select idJoueur from joueur where nomJoueur= \'" + nom+"\' and prenomJoueur= \'"+prenom+"\'");
      try {
		if(rset1.next()){
		    return false;
		  }
		  else{
		    return true;
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;

  }

 
    

}
