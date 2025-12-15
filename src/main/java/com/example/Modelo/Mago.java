package com.example.Modelo;

import java.util.ArrayList;
import java.util.List;

import com.example.Modelo.Hechizo.Hechizo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Magos")

public class Mago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private  String nombre;
    private  int vida;
    private  int nivelMagia;
    private final List<Hechizo> conjuros = new ArrayList<>();

    //Constructor

    public Mago(){}

    public Mago(String nombre, int vida, int nivelMagia) {
        this.nombre = nombre;

        //La vida no puede tomar valores menores o igual a 0, ya que sino ya no tiene.
        if (vida <= 0) {
            this.vida = 1;
        } else this.vida = vida;

        this.nivelMagia = nivelMagia;
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
    public int getNivelMagia() {
        return nivelMagia;
    }

    public List<Hechizo> getConjuros() {
        return conjuros;
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
    public void setNivelMagia(int nivelMagia) {
        this.nivelMagia = nivelMagia;
    }
    
    //Métodos:
    public void lanzarHechizo(Monstruo monstruo) {
        monstruo.setVida(monstruo.getVida()-nivelMagia);
    }

    public void aprenderHechizo(Hechizo hechizo) {
        conjuros.add(hechizo);
    }

    public Boolean comprobarHechizo(Hechizo hechizo) {
        return conjuros.contains(hechizo);
    }

    public void lanzarHechizo(Hechizo hechizo, Monstruo m) {

        if (comprobarHechizo(hechizo)) {
            hechizo.Efecto(m);
        } else {
            setVida(getVida() - 1);
        }
    }

    @Override
    public String toString() {
        return "Mago [id=" + id + ", nombre=" + nombre + ", vida=" + vida + ", nivelMagia=" + nivelMagia + "]";
    }
}
