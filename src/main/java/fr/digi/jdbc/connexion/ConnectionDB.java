package fr.digi.jdbc.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionDB {
    private static ConnectionDB single;

    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    private Connection connection;
    static {
        ResourceBundle bundle = ResourceBundle.getBundle( "database" );
        DB_URL = bundle.getString( "db.url" );
        DB_USER = bundle.getString( "db.user" );
        DB_PWD = bundle.getString( "db.password" );
    }

    private ConnectionDB() throws SQLException {
        connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
    }

    public static ConnectionDB getSingle() throws SQLException {
        if (null == single) {
            single = new ConnectionDB();
        }
        return single;
    }

    public Connection getConnection() {
        return connection;
    }
}
