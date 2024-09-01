package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3308/base_lulo";
    private static final String USER = "root";
    private static final String PASSWORD = "lulox123";
    private static  Connection conexionDb;

    public static Connection getInstance() throws SQLException{
        if (conexionDb == null){
            conexionDb = DriverManager.getConnection(URL,USER,PASSWORD);
        }
        return conexionDb;
    }



}
