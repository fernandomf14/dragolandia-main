package com.example.Modelo.Hechizo;

import com.example.Modelo.Monstruo;

public class Rayo extends Hechizo {

    public Rayo() {
        this.nombre = "Rayo";
    }

    @Override
    public void Efecto(Monstruo m){
        m.setVida(m.getVida() - 3);
    }

}
