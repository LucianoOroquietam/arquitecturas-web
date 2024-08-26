package org.example;

import java.sql.*;
import java.text.ParseException;


public class MySqlConnection {

    public static void main(String[] args) {
        // URL de conexión JDBC actualizado para Docker
        String jdbcUrl = "jdbc:mysql://localhost:3308/base_lulo";
        String username = "root";
        String password = "lulox123";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Conexión establecida con éxito!");


            addUser(conn, "Tomasito", "Tourn", "tomytourn@gmail.com", "Alsina 1250", "Masculino", "Argentino", Date.valueOf("2005-02-01"));

        } catch (SQLException e) {
            System.err.println("Error al conectarse a la base de datos:");
            e.printStackTrace();
        }
    }


    private static void addUser(Connection connection, String nombre,String apellido, String email, String direccion, String sexo, String nacionalidad, Date fecha_nacimiento) throws SQLException  {
        String insert = "INSERT INTO usuarios (nombre, apellido, email, direccion, sexo, nacionalidad, fecha_nacimiento) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(insert);
        statement.setString(1,nombre);
        statement.setString(2,apellido);
        statement.setString(3,email);
        statement.setString(4,direccion);
        statement.setString(5,sexo);
        statement.setString(6,nacionalidad);
        statement.setDate(7,fecha_nacimiento);
        statement.executeUpdate();

        System.out.println("La Persona " + nombre + " " +apellido + " fue agregado/a con exito");


    }
}
