package org.example;
import java.sql.*;

public class BaseDeDatos {
    private static final String url = "jdbc:derby:memory:myDB;create=true";
    public static void main(String[] args) {

        try (Connection conexionDB = DriverManager.getConnection(url)){
            Statement stm = conexionDB.createStatement();
            String creacionTablaPersona = "CREATE TABLE persona (" +
                    "ID INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, " +
                    "NOMBRE VARCHAR(100), " +
                    "APELLIDO VARCHAR(100), " +
                    "EMAIL VARCHAR(100)" +
                    ")";
            stm.executeUpdate(creacionTablaPersona);

            addPerson(conexionDB,"dasdasd","Cuculadasdasich","aguadasdash@gmail.com");
            //deletePerson(conexionDB,ID);

           updatePerson(conexionDB,1,"Luciano","Oroquieta Merlino","loroquietamerlino@alumnos.exa.unicen.edu.ar");
           printPersons(conexionDB);

           //al ser embebido el update funciona en tiempo de compilacion


        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addPerson(Connection conexionDB, String nombre, String apellido, String email) throws SQLException {
        String insert = "INSERT INTO persona (NOMBRE, APELLIDO, EMAIL) VALUES (?,?,?)";
        PreparedStatement ps = conexionDB.prepareStatement(insert);
        ps.setString(1,nombre);
        ps.setString(2,apellido);
        ps.setString(3,email);
        ps.executeUpdate();

        System.out.println("La Persona " + nombre + " " +apellido + " fue agregado con exito");

    }

    private static void deletePerson(Connection conexionDB, int id) throws SQLException {
        String delete = "DELETE FROM person WHERE ID = ?";
        PreparedStatement ps = conexionDB.prepareStatement(delete);
        ps.setInt(1,id);
        ps.executeUpdate();

        System.out.println("La Persona con el id: " + id + " fue eliminada con exito");

    }

    private static void updatePerson(Connection conexionDB,int id, String nombre, String apellido, String email) throws SQLException {
        String update = "UPDATE persona SET nombre = ?, apellido=?, email=? WHERE id = ?";
        PreparedStatement ps = conexionDB.prepareStatement(update);
        ps.setString(1,nombre);
        ps.setString(2,apellido);
        ps.setString(3,email);
        ps.setInt(4,id);
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("La Persona con el ID: " + id + " fue modificada con éxito.");
        } else {
            System.out.println("No se encontró ninguna persona con el ID: " + id + ".");
        }

    }

    private static void printPersons(Connection conexionDB) throws SQLException {
        String query = "SELECT * FROM persona";
        Statement stmt = conexionDB.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                String apellido = rs.getString("APELLIDO");
                String email = rs.getString("EMAIL");
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Email: " + email);
            }

    }
}