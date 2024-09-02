package org.example.Derby;

import org.example.ConexionDbSingleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MainDerby {
    public static void main(String[] args) {
        try {
            Connection conexionDB = ConexionDerbySingleton.getInstance();
            DerbyDao personaDao = new DerbyDao(conexionDB);

            // Crear la tabla antes de insertar datos
            personaDao.crearTabla();

            // Crear un nuevo usuario
            Persona p1 = new Persona("Luciano", "Oroquieta", "oroquietaluciano@gmail.com", 1);
            Persona p2 = new Persona("Santiago", "Coria", "coria@gmail.com", 1);
            Persona p3 = new Persona("Matias", "Gatti", "gatti@gmail.com", 1);
            Persona p4 = new Persona("Micaela", "Diaz", "mica@gmail.com", 1);
            personaDao.crearUsuario(p1);
            personaDao.crearUsuario(p2);
            personaDao.crearUsuario(p3);
            personaDao.crearUsuario(p4);

            // Obtener y mostrar los usuarios
            List<Persona> personas = personaDao.obtenerPersonas();
            for (Persona p : personas) {
                System.out.println(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
