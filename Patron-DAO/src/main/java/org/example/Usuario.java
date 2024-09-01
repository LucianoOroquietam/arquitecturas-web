package org.example;

import java.sql.Date;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String direccion;
    private String sexo;
    private String nacionalidad;
    private Date fecha_nacimiento;

    public Usuario(int id, String nombre, String apellido, String email, String direccion, String sexo, String nacionalidad, Date fecha_nacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.direccion = direccion;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getId() {
        return id;
    }



    public String getNombre() {
        return nombre;
    }



    public String getApellido() {
        return apellido;
    }



    public String getEmail(){
        return email;
    }


    public String getDireccion(){
        return direccion;
    }

    public String getSexo() {
        return sexo;
    }



    public String getNacionalidad() {
        return nacionalidad;
    }



    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", sexo='" + sexo + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                '}';
    }
}
