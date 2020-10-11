package DataBaseHandler;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Tato trida slouzi k pripojeny
 *
 */
public class DataBaseConnector {

    private static Connection connection = null;

    public static Connection getConnection()throws SQLException {
        if(DataBaseConnector.connection == null){
            throw  new SQLException("Session is not established");
        }
        return DataBaseConnector.connection;
    }
    public static void setUpConnection(String url,String user,String passw){
        try {
            connection = DriverManager.getConnection(url,user,passw);
            connection.setAutoCommit(true);
            System.out.println("Connection done");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void closeConnect() throws SQLException {
        if(DataBaseConnector.connection!=null){
                DataBaseConnector.connection.commit();
        }
        DataBaseConnector.connection.close();
        connection = null;
        System.out.println("Connection closed!");
    }
}
