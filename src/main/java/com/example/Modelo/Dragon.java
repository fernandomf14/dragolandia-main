package com.example.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Dragon")
public class Dragon {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int intensidadFuego;
    private int resistencia;

    //Constructor vacio
    public Dragon(){}

    public Dragon(int intensidadFuego, String nombre, int resistencia) {
        
        if (intensidadFuego >= 0) {
            this.intensidadFuego = intensidadFuego;
        } else {
            this.intensidadFuego = 0;
        }
        this.nombre = nombre;

        if (resistencia > 0) {
            this.resistencia = resistencia;
        } else {
            this.resistencia = 1;
        }
    
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIntensidadFuego() {
        return intensidadFuego;
    }

    public int getResistencia() {
        return resistencia;
    }

    //SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIntensidadFuego(int intensidadFuego) {
        this.intensidadFuego = intensidadFuego;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dragon{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", intensidadFuego=").append(intensidadFuego);
        sb.append(", resistencia=").append(resistencia);
        sb.append('}');
        return sb.toString();
    }

    //METODOS:

    public void exhalar(Monstruo m) {
        m.setVida(m.getVida()-getIntensidadFuego());
    }

    
}
