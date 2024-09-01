package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlUsuarioDao implements UsuarioIntefaceDAO{

    private final Connection conexion;

    public MySqlUsuarioDao(Connection conect){
        try {
            this.conexion = ConexionDbSingleton.getInstance();  // conexión desde el Singleton
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión", e);
        }
    }

    @Override
    public void crearUsuario(Usuario user) {
        String insertSQL = "INSERT INTO usuarios (nombre,apellido,email,direccion, sexo,nacionalidad,fecha_nacimiento) VALUES (?,?,?,?,?,?,?)";
        try(PreparedStatement statement = conexion.prepareStatement(insertSQL)){
            statement.setString(1, user.getNombre());
            statement.setString(2, user.getApellido());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getDireccion());
            statement.setString(5, user.getSexo());
            statement.setString(6,user.getNacionalidad());
            statement.setDate(7,user.getFecha_nacimiento());
            statement.executeUpdate();
            System.out.println("El usuario " + user + " fue creado con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> obtenerPersonas() throws SQLException {
        List<Usuario> listaPersonas = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try(PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet rs = statement.executeQuery()){

            while (rs.next()){
                Usuario usuario = mapResultSetToUsuario(rs);
                listaPersonas.add(usuario);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaPersonas;
    }

    @Override
    public Usuario obtenerUsuario(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            //sino lo encierro en un try tendria que cerrarlo manualmente .close()
            try(ResultSet rs = statement.executeQuery()){
                if (rs.next()) {
                    return mapResultSetToUsuario(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener el usuario", e);
        }
        return null;
    }

    @Override
    public void modificarUsuario(Usuario user) {
        String updateSql = "UPDATE usuarios SET nombre = ?, apellido = ?, email = ?, direccion = ?, sexo = ?, nacionalidad = ?, fecha_nacimiento = ? WHERE id =?";
        try (PreparedStatement statement = this.conexion.prepareStatement(updateSql)){
            statement.setString(1, user.getNombre());
            statement.setString(2, user.getApellido());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getDireccion());
            statement.setString(5, user.getSexo());
            statement.setString(6,user.getNacionalidad());
            statement.setDate(7,user.getFecha_nacimiento());
            statement.setInt(8,user.getId());
            statement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminarUsuario(int id) {
        String deleteSql = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement statement = this.conexion.prepareStatement(deleteSql)){
            statement.setInt(1,id);
            statement.executeUpdate();
            System.out.println("Usuario eliminado con exito");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Método auxiliar para mapear el ResultSet a un objeto Usuario
    private Usuario mapResultSetToUsuario(ResultSet rs) throws SQLException {
        return new Usuario(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("email"),
                rs.getString("direccion"),
                rs.getString("sexo"),
                rs.getString("nacionalidad"),
                rs.getDate("fecha_nacimiento")
        );
    }

    /*este metodo me ahorra que en cada metodo haga esto*/
     /*  Usuario usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("direccion"),
                        rs.getString("sexo"),
                        rs.getString("nacionalidad"),
                        rs.getDate("fecha_nacimiento")
                );

        convierte un ResultSet en un objeto Usuario.
        Evitando la repetición de código en los métodos obtenerPersonas y obtenerUsuario.
      */


}
