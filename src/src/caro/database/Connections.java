package caro.database;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connections {
    static String userName = "sa";
    static String passWord = "12345678";
    static String dbUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=caro";

    public static Connection Newconnect() {
        Connection con = null;
        try {
        
            String url = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(url);
            con = DriverManager.getConnection(dbUrl,userName,passWord);
        } catch (Exception ex) {
            System.out.println("Conection fail!");
        }
        return con;
    }
}
