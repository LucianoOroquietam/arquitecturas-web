package org.example.Derby;

import org.example.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface intefaceDerby {
    void crearUsuario(Persona user) throws SQLException;

    public interface UsuarioIntefaceDAO {


        void crearUsuario(Persona user);

        List<Persona> obtenerPersonas() throws SQLException;

        int obtenerUsuario(int id);

        void modificarUsuario(Persona user) throws SQLException;

        void eliminarUsuario(int id);


    }

}
