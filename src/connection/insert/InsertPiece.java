package connection.insert;
import java.sql.*;
import connection.MultipleQueries;

public class InsertPiece {
  private MultipleQueries queries;

  public InsertPiece(int numRenconre, String nomTour) {
          ResultSet rsetMaxId = queries.getResult("Select idPiece from piece where idPiece=max(idPiece)");
          int n = rsetMaxId.getInt(1);

          ResultSet rset1 = queries.getResult("Insert into Piece Values("+ int.toString(n+1) +",'tour','A','1','A','1','blanc',"+nomTour+", "numRenconre")";);
          ResultSet rset2 = queries.getResult("Insert into Piece Values("+ int.toString(n+2) +",'tour','H','1','H','1','blanc',"+nomTour+", "numRenconre")";);
          ResultSet rset3 = queries.getResult("Insert into Piece Values("+ int.toString(n+3) +",'cavalier','B','1','B','1','blanc',"+nomTour+", "numRenconre")";);
          ResultSet rset4 = queries.getResult("Insert into Piece Values("+ int.toString(n+4) +",'cavalier','G','1','G','1','blanc',"+nomTour+", "numRenconre")";);
          ResultSet rset5 = queries.getResult("Insert into Piece Values("+ int.toString(n+5) +",'fou','C','1','C','1','blanc',"+nomTour+", "numRenconre")";);
          ResultSet rset6 = queries.getResult("Insert into Piece Values("+ int.toString(n+6) +",'fou','F','1','F','1','blanc',"+nomTour+", "numRenconre")";);
          ResultSet rset7 = queries.getResult("Insert into Piece Values("+ int.toString(n+7) +",'roi','E','1','E','1','blanc',"+nomTour+", "numRenconre")";);
          ResultSet rset8 = queries.getResult("Insert into Piece Values("+ int.toString(n+8) +",'reine','D','1','D','1','blanc',"+nomTour+", "numRenconre")";);
          ResultSet rset9 = queries.getResult("Insert into Piece Values("+ int.toString(n+9) +",'pion','A','2','A','2','blanc',"+nomTour+", "numRenconre")";);
          ResultSet rset10 = queries.getResult("Insert into Piece Values("+ int.toString(n+10) +",'pion','H','2','H','2','blanc',"+nomTour+", "numRenconre")";);
          ResultSet rset11 = queries.getResult("Insert into Piece Values("+ int.toString(n+11) +",'pion','B','2','B','2','blanc',"+nomTour+", "numRenconre")";);
          ResultSet rset12 = queries.getResult("Insert into Piece Values("+ int.toString(n+12) +",'pion','G','2','G','2','blanc',"+nomTour+", "numRenconre")";);
          ResultSet rset13 = queries.getResult("Insert into Piece Values("+ int.toString(n+13)+",'pion','C','2','C','2','blanc',"+nomTour+", "numRenconre")";);
          ResultSet rset14 = queries.getResult("Insert into Piece Values("+ int.toString(n+14) +",'pion','F','2','F','2','blanc',"+nomTour+", "numRenconre")";);
          ResultSet rset15 = queries.getResult("Insert into Piece Values("+ int.toString(n+15)+",'pion','D','2','D','2','blanc',"+nomTour+", "numRenconre")";);
          ResultSet rset16 = queries.getResult("Insert into Piece Values("+ int.toString(n+16) +",'pion','E','2','E','2','blanc',"+nomTour+", "numRenconre")";);
          ResultSet rset17 = queries.getResult("Insert into Piece Values("+ int.toString(n+17) +",'tour','A','8','A','8','noir',"+nomTour+", "numRenconre")";);
          ResultSet rset18 = queries.getResult("Insert into Piece Values("+ int.toString(n+18) +",'tour','H','8','H','8','noir',"+nomTour+", "numRenconre")";);
          ResultSet rset19 = queries.getResult("Insert into Piece Values("+ int.toString(n+19) +",'cavalier','B','8','B','8','noir',"+nomTour+", "numRenconre")";);
          ResultSet rset20 = queries.getResult("Insert into Piece Values("+ int.toString(n+20) +",'cavalier','G','8','G','8','noir',"+nomTour+", "numRenconre")";);
          ResultSet rset21 = queries.getResult("Insert into Piece Values("+ int.toString(n+21) +",'fou','C','8','C','8','noir',"+nomTour+", "numRenconre")";);
          ResultSet rset22 = queries.getResult("Insert into Piece Values("+ int.toString(n+22) +",'fou','F','8','F','8','noir',"+nomTour+", "numRenconre")";);
          ResultSet rset23 = queries.getResult("Insert into Piece Values("+ int.toString(n+23) +",'roi','E','8','E','8','noir',"+nomTour+", "numRenconre")";);
          ResultSet rset24 = queries.getResult("Insert into Piece Values("+ int.toString(n+24) +",'reine','D','8','D','8','noir',"+nomTour+", "numRenconre")";);
          ResultSet rset25 = queries.getResult("Insert into Piece Values("+ int.toString(n+25) +",'pion','A','7','A','7','noir',"+nomTour+", "numRenconre")";);
          ResultSet rset26 = queries.getResult("Insert into Piece Values("+ int.toString(n+26) +",'pion','H','7','H','7','noir',"+nomTour+", "numRenconre")";);
          ResultSet rset27 = queries.getResult("Insert into Piece Values("+ int.toString(n+27) +",'pion','B','7','B','7','noir',"+nomTour+", "numRenconre")";);
          ResultSet rset28 = queries.getResult("Insert into Piece Values("+ int.toString(n+28) +",'pion','G','7','G','7','noir',"+nomTour+", "numRenconre")";);
          ResultSet rset29 = queries.getResult("Insert into Piece Values("+ int.toString(n+29) +",'pion','C','7','C','7','noir',"+nomTour+", "numRenconre")";);
          ResultSet rset30 = queries.getResult("Insert into Piece Values("+ int.toString(n+30) +",'pion','F','7','F','7','noir',"+nomTour+", "numRenconre")";);
          ResultSet rset31 = queries.getResult("Insert into Piece Values("+ int.toString(n+31) +",'pion','D','7','D','7','noir',"+nomTour+", "numRenconre")";);
          ResultSet rset32 = queries.getResult("Insert into Piece Values("+ int.toString(n+32) +",'pion','E','7','E','7','noir',"+nomTour+", "numRenconre")";);


      }
  }

}
