package org.example;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            //conexion a la db levantada en docker
            Connection conexionDB = ConexionDbSingleton.getInstance();

            //instancia DAO
            MySqlUsuarioDao usuarioDao = new MySqlUsuarioDao(conexionDB);


           Usuario nuevoUsuario = new Usuario(1, "Santiago", "Coria", "Santicoria@gmail.com", "algun lugar 123", "Masculino", "Argentina", java.sql.Date.valueOf("1997-01-01"));
           usuarioDao.crearUsuario(nuevoUsuario);


            // Prueba obtener todos los usuarios
            List<Usuario> usuarios = usuarioDao.obtenerPersonas();
            //usuarios.forEach(System.out::println);
            for (Usuario user : usuarios) {
                System.out.println(user);
            }



            //usuarioDao.eliminarUsuario(7);




            // Obtener un usuario por su ID
            int usuarioId = 2;
            Usuario usuario = usuarioDao.obtenerUsuario(usuarioId);

            System.out.println("se seleccion el usuario con el id " + usuarioId);

            // Verificar si el usuario fue encontrado y mostrar información
            if (usuario != null) {
                System.out.println("Usuario encontrado:");
                System.out.println("ID: " + usuario.getId());
                System.out.println("Nombre: " + usuario.getNombre());
                System.out.println("Apellido: " + usuario.getApellido());
                System.out.println("Email: " + usuario.getEmail());
                System.out.println("Dirección: " + usuario.getDireccion());
                System.out.println("Sexo: " + usuario.getSexo());
                System.out.println("Nacionalidad: " + usuario.getNacionalidad());
                System.out.println("Fecha de nacimiento: " + usuario.getFecha_nacimiento());
            } else {
                System.out.println("Usuario con ID " + usuarioId + " no encontrado.");
            }


            System.out.println("------obtener todos los usuarios----------");
            // Prueba obtener todos los usuarios
            List<Usuario> usuarioss = usuarioDao.obtenerPersonas();
            for (Usuario user : usuarioss) {
                System.out.println(user);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}