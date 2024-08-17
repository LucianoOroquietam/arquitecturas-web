package org.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MySqlConecction {

    public static void main(String[] args) {

        //String prueba = "C:/Users/Luciano/Desktop/Arquitecturas web/config.properties.txt";
        String filePath = "src/main/java/org/example/config.properties.txt";

        Properties props = new Properties(); //es una lista de campos estilo "json"
        try (FileInputStream fis = new FileInputStream(filePath)) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String password = props.getProperty("db.password");

        String jdbcUrl = "jdbc:mysql://localhost:3306/base_lulo";
        String username = "root";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Conexión establecida con éxito!");

            // Crear un objeto Statement para ejecutar comandos SQL
            Statement stmt = conn.createStatement();

            // Insertar un registro en la tabla
            String sql = "INSERT INTO usuarios (nombre, apellido, email, direccion, sexo, nacionalidad, fecha_nacimiento) " +
                    "VALUES ('Agustinadsdasdsa', 'Cuculich', 'agustina@example.com', 'alberdi', 'Femenina', 'Argentina', '2002-01-24')";
            //String sql = "DELETE FROM usuarios WHERE id=4";
            //String sql = "UPDATE usuarios SET nombre = 'Simon el trolon' WHERE id=2 ";
            stmt.executeUpdate(sql);
            System.out.println("Registro insertado con éxito!");

        } catch (SQLException e) {
            System.err.println("Error al conectarse a la base de datos:");
            e.printStackTrace();
        }
    }

}
