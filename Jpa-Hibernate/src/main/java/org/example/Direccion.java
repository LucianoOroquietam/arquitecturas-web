package org.example;

import javax.persistence.*;

@Entity
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String ciudad;
    @Column
    private String calle;

    public Direccion() {
    }

    public Direccion(String calle, String ciudad) {
        this.calle = calle;
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", ciudad='" + ciudad + '\'' +
                ", calle='" + calle + '\'' ;
    }
}
