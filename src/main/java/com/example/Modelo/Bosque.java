package com.example.Modelo;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bosques")

public class Bosque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int nivelPeligro;
    
    @OneToOne(cascade = CascadeType.ALL) // Relación uno a uno
    private Monstruo monstruoJefe;

    @OneToMany(cascade = CascadeType.ALL )
    private List<Monstruo> listaMonstruo;

    @OneToOne( cascade = CascadeType.ALL )
    private Dragon dragon;
    
    //CONSTRUCTOR

    public Bosque(){}

    public Bosque(String nombre, int nivelPeligro, Monstruo monstruoJefe, Dragon dragon) {
        this.nombre = nombre;
        this.nivelPeligro = nivelPeligro;
        this.monstruoJefe = monstruoJefe;
        this.dragon = dragon;
        this.listaMonstruo = new ArrayList<>();
    }

    //GETTERS

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelPeligro() {
        return nivelPeligro;
    }

    public Monstruo getMonstruoJefe() {
        return monstruoJefe;
    }

    public List<Monstruo> getlistaMonstruos() {
        return listaMonstruo;
    }

    public Dragon getDragon() {
        return dragon;
    }

    //SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivelPeligro(int nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }

    public void setMonstruoJefe(Monstruo monstruoJefe) {
        this.monstruoJefe = monstruoJefe;
    }

    public void setDragon(Dragon d) {
        this.dragon = d;
    }

    @Override
    public String toString() {
        return "Bosque [id=" + id + ", nombre=" + nombre + ", nivelPeligro=" + nivelPeligro + ", monstruoJefe="
                + monstruoJefe + "]";
    }

    //METODOS:

    public String mostrarJefe() {
        return "El jefe del bosque es " + monstruoJefe.getNombre() + " y su vida es " + monstruoJefe.getVida();
    }

    public void cambiarJefe(Monstruo monstruo) {
        setMonstruoJefe(monstruo);
    }

    public void addMonstruos(Monstruo monstruo) {
        listaMonstruo.add(monstruo);
    }
    
    public void eliminarMonstruo(Monstruo m) {
        listaMonstruo.remove(m);
    }

    public void cambiarDragon(Dragon dragon) {
        this.dragon = dragon;
    }
    
}
