package org.example;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            //conexion a la db levantada en docker
            Connection conexionDB = ConexionDB.getInstance();

            //instancia DAO
            MySqlUsuarioDao usuarioDao = new MySqlUsuarioDao(conexionDB);

            Usuario nuevoUsuario = new Usuario(1, "Franco", "Stramana", "Franco.stramana@gmail.com", "Movediza 123", "Masculino", "Argentina", java.sql.Date.valueOf("1990-01-01"));

            usuarioDao.crearUsuario(nuevoUsuario);
            System.out.println("Usuario creado con exito");

            // Prueba obtener todos los usuarios
            List<Usuario> usuarios = usuarioDao.obtenerPersonas();
            for (Usuario user : usuarios) {
                System.out.println(user);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}