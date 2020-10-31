package DataBaseHandler;

import Entity.CastAObce;
import Entity.Obec;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

/**
 * Trida na zpracavani ulozeni daty
 * tady jen priklad nemam vytvorene database
 */
public class DataBaseHandler {
    private static DataBaseHandler instance = null;

    public DataBaseHandler() {
    DataBaseConnector.setUpConnection("url","User","passw");
    }

    public static  DataBaseHandler getInstance(){
        if(instance == null){
            instance = new DataBaseHandler();
        }
        return instance;
    }

   public boolean addObce(Set<Obec> obce){
       try {
           Connection con  = DataBaseConnector.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           for (Obec e: obce){
           rs = stmt.executeQuery("INSERT INTO OBEC (kod,nazev) "
                       +"VALUES ("+e.getKod()+","+e.getNazev()+")" );
           }
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
       return true;
   }
   public boolean addCastObce(Set<CastAObce> castObces){
//      try{
//       Connection con  = DataBaseConnector.getConnection();
//       Statement stmt = con.createStatement();
//       ResultSet rs;
//       for (Obec e: castObces){
//           rs = stmt.executeQuery("INSERT INTO CASTOBEC (kod,nazev) "
//                   +"VALUES ("+e.getKod()+","+e.getNazev()+")" );
//       }
//        } catch (SQLException throwables) {
//        throwables.printStackTrace();
//        }
        return true;
    }
}
