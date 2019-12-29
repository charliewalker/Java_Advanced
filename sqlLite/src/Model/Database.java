package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final String path ="Student.db";
    final String url = "jdbc:sqlite:" + path;
    private Connection connection;

    {
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  Database(){

    }

    public Connection getConnection() {
        return connection;
    }
    public void CloseConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
