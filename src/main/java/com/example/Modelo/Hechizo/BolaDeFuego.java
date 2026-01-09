package com.example.Modelo.Hechizo;

import com.example.Modelo.Monstruo.Monstruo;

import jakarta.persistence.Entity;

@Entity
public class BolaDeFuego extends Hechizo {

    public BolaDeFuego() {
        this.nombre = "Bola de fuego";
    }

    @Override
    public void Efecto(Monstruo m){
        m.setVida(m.getVida() - 5);
    }

}
