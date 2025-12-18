package com.example.Modelo.Hechizo;

import com.example.Modelo.Monstruo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Hechizo_fuego")
public class BolaDeFuego extends Hechizo {

    public BolaDeFuego() {
        this.nombre = "Bola de fuego";
    }

    @Override
    public void Efecto(Monstruo m){
        m.setVida(m.getVida() - 5);
    }

}
