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

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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
