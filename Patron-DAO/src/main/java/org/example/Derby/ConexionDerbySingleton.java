package org.example.Derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDerbySingleton {
    private static final String Url = "jdbc:derby:memory:myDB;create=true";
    private static Connection conexionDbDerby;

    public static Connection getInstance() throws SQLException{
        if (conexionDbDerby == null){
            return DriverManager.getConnection(Url);
        }
        return conexionDbDerby;
    }
}
