package com.example.Modelo.Monstruo;

import com.example.Modelo.Mago.Mago;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Monstruos")

public class Monstruo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int vida;
    private enum Tipo { ogro, troll, espectro }
    private Tipo tipo;
    private int fuerza;

    public Monstruo(){}

    public Monstruo(String nombre, int vida ,String tipo, int fuerza) {
        this.nombre = nombre;

        if (vida > 0) this.vida = vida;
        else throw new IllegalArgumentException("La vida debe ser mayor a 0");

        try {
            this.tipo = Tipo.valueOf(tipo.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de monstruo inválido: " + tipo);
        }

        this.fuerza = fuerza;
    }


    //GETTERS

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public int getVida() {
        return vida;
    }
    public int getFuerza() {
        return fuerza;
    }

    public String getTipo() {
        return tipo.name();
    }

    //SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setTipo(String tipo) {

        try {
            this.tipo = Tipo.valueOf(tipo.toLowerCase());
        } catch(IllegalStateException e) {
            System.out.println("Error en el tipo de monstruo" + e.getMessage());
        }

    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    //Métodos

    public void atacar(Mago mago) {
        mago.setVida(mago.getVida()-fuerza);
    }

    //ToString
    @Override
    public String toString() {
        return "Monstruo [id=" + id + ", nombre=" + nombre + ", vida=" + vida + ", tipo=" + tipo + ", fuerza=" + fuerza
                + "]";
    }

}
