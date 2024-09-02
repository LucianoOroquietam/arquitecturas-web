package org.example;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioIntefaceDAO {
    //implementamos la interfaz para operaciones CRUD

    //crear usuario
    void crearUsuario(Usuario user) throws SQLException;
    //obtener todos los usuarios
    List<Usuario> obtenerPersonas() throws SQLException;
    //obtener un usuario en especifico (por id)
    Usuario obtenerUsuario(int id);
    //modificar usuario
    void modificarUsuario(Usuario user) throws SQLException;
    //eliminar usuario
    void eliminarUsuario(int id);


}
