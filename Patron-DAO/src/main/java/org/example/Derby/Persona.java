package org.example.Derby;

public class Persona {
    private int id ;
    private String nombre;
    private String apellido;
    private String email;

    public Persona(String nombre, String apellido, String email, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
