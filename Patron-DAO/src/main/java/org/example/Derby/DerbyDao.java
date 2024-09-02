package org.example.Derby;

import org.example.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DerbyDao implements intefaceDerby {
    private final Connection conexion;

    public DerbyDao(Connection conexion) throws SQLException {
        try {
            this.conexion = ConexionDerbySingleton.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión", e);
        }
    }

    public void crearTabla(){
                 String crearTablaSQL = "CREATE TABLE persona (" +
                "ID INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, " +
                "Nombre VARCHAR(100), " +
                "Apellido VARCHAR(100), " +
                "Email VARCHAR(100))";
            try (PreparedStatement stmt = this.conexion.prepareStatement(crearTablaSQL)) {
                stmt.executeUpdate();
                System.out.println("Tabla 'persona' creada exitosamente.");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    public void crearUsuario(Persona user) throws SQLException {
        String insert = "INSERT INTO persona (Nombre,Apellido,Email) VALUES (?,?,?)";
        PreparedStatement stm = this.conexion.prepareStatement(insert);
        stm.setString(1,user.getNombre());
        stm.setString(2,user.getApellido());
        stm.setString(3,user.getEmail());
        stm.executeUpdate();
        System.out.println("persona creado con exito");
    }

    public List<Persona> obtenerPersonas() throws SQLException {
        List<Persona> personas = new ArrayList<>();
        String obtenerPersonas = "SELECT * FROM persona"; // No se requiere parámetro

        try (PreparedStatement stm = this.conexion.prepareStatement(obtenerPersonas);
             ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                Persona p = new Persona(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getInt("id")
                );
                personas.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener personas", e);
        }
        return personas;
    }
    //obtener un usuario en especifico (por id)
    public int obtenerUsuario(int id){
        return 1;
    }
    //modificar usuario
    public void modificarUsuario(Usuario user){

    }
    //eliminar usuario
    public void eliminarUsuario(int id){

    }








}


