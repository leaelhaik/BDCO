package connection.init;
import java.sql.*;
import connection.MultipleQueries;
public class InitAffectationCouleur {

  public InitAffectationCouleur(MultipleQueries queries,String couleur,int id,String nomTour,int numRencontre){
    ResultSet rsetDropRencontre = queries.getResult("insert into AffectationCouleur values(" + id + ",\'" +couleur+ "\' , \'" +nomTour+ "\' , \'" +numRencontre+ "\')");
  }
}
