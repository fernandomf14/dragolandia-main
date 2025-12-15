package com.example.Modelo.Hechizo;

import com.example.Modelo.Monstruo;

public class Hechizo {
    protected String nombre;
    public void Efecto(Monstruo monstruo){}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hechizo{");
        sb.append("nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
