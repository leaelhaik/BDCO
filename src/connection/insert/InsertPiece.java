package connection.insert;
import java.sql.*;
import connection.MultipleQueries;
import connection.Queries;

public class InsertPiece {

  public InsertPiece(int numRencontre, String nomTour) {
          ResultSet rsetMaxId = Queries.queries.getResult("Select max(idPiece) from piece");
          try {
                rsetMaxId.next();
                int n = rsetMaxId.getInt(1);
                System.out.println(n);

                ResultSet rset1 = Queries.queries.getResult("Insert into Piece Values("+ (n+1) +",'tour','A','1','A','1','blanc',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset2 = Queries.queries.getResult("Insert into Piece Values("+ (n+2) +",'tour','H','1','H','1','blanc',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset3 = Queries.queries.getResult("Insert into Piece Values("+ (n+3) +",'cavalier','B','1','B','1','blanc',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset4 = Queries.queries.getResult("Insert into Piece Values("+ (n+4) +",'cavalier','G','1','G','1','blanc',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset5 = Queries.queries.getResult("Insert into Piece Values("+ (n+5) +",'fou','C','1','C','1','blanc',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset6 = Queries.queries.getResult("Insert into Piece Values("+ (n+6) +",'fou','F','1','F','1','blanc',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset7 = Queries.queries.getResult("Insert into Piece Values("+ (n+7) +",'roi','E','1','E','1','blanc',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset8 = Queries.queries.getResult("Insert into Piece Values("+ (n+8) +",'reine','D','1','D','1','blanc',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset9 = Queries.queries.getResult("Insert into Piece Values("+ (n+9) +",'pion','A','2','A','2','blanc',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset10 = Queries.queries.getResult("Insert into Piece Values("+ (n+10) +",'pion','H','2','H','2','blanc',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset11 = Queries.queries.getResult("Insert into Piece Values("+ (n+11) +",'pion','B','2','B','2','blanc',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset12 = Queries.queries.getResult("Insert into Piece Values("+ (n+12) +",'pion','G','2','G','2','blanc',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset13 = Queries.queries.getResult("Insert into Piece Values("+ (n+13)+",'pion','C','2','C','2','blanc',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset14 = Queries.queries.getResult("Insert into Piece Values("+ (n+14) +",'pion','F','2','F','2','blanc',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset15 = Queries.queries.getResult("Insert into Piece Values("+ (n+15)+",'pion','D','2','D','2','blanc',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset16 = Queries.queries.getResult("Insert into Piece Values("+ (n+16) +",'pion','E','2','E','2','blanc',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset17 = Queries.queries.getResult("Insert into Piece Values("+ (n+17) +",'tour','A','8','A','8','noir',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset18 = Queries.queries.getResult("Insert into Piece Values("+ (n+18) +",'tour','H','8','H','8','noir',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset19 = Queries.queries.getResult("Insert into Piece Values("+ (n+19) +",'cavalier','B','8','B','8','noir',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset20 = Queries.queries.getResult("Insert into Piece Values("+ (n+20) +",'cavalier','G','8','G','8','noir',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset21 = Queries.queries.getResult("Insert into Piece Values("+ (n+21) +",'fou','C','8','C','8','noir',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset22 = Queries.queries.getResult("Insert into Piece Values("+ (n+22) +",'fou','F','8','F','8','noir',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset23 = Queries.queries.getResult("Insert into Piece Values("+ (n+23) +",'roi','E','8','E','8','noir',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset24 = Queries.queries.getResult("Insert into Piece Values("+ (n+24) +",'reine','D','8','D','8','noir',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset25 = Queries.queries.getResult("Insert into Piece Values("+ (n+25) +",'pion','A','7','A','7','noir',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset26 = Queries.queries.getResult("Insert into Piece Values("+ (n+26) +",'pion','H','7','H','7','noir',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset27 = Queries.queries.getResult("Insert into Piece Values("+ (n+27) +",'pion','B','7','B','7','noir',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset28 = Queries.queries.getResult("Insert into Piece Values("+ (n+28) +",'pion','G','7','G','7','noir',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset29 = Queries.queries.getResult("Insert into Piece Values("+ (n+29) +",'pion','C','7','C','7','noir',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset30 = Queries.queries.getResult("Insert into Piece Values("+ (n+30) +",'pion','F','7','F','7','noir',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset31 = Queries.queries.getResult("Insert into Piece Values("+ (n+31) +",'pion','D','7','D','7','noir',"+ numRencontre + ",\'" + nomTour + "\')");
                ResultSet rset32 = Queries.queries.getResult("Insert into Piece Values("+ (n+32) +",'pion','E','7','E','7','noir',"+ numRencontre + ",\'" + nomTour + "\')");
          } catch (SQLException e) {
              System.err.println("Pawn insertion failed");
                e.printStackTrace();
      }
  }

}
