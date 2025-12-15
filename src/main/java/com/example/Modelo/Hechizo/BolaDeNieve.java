package com.example.Modelo.Hechizo;

import com.example.Modelo.Monstruo;

public class BolaDeNieve extends Hechizo {

    public BolaDeNieve() {
        this.nombre = "Bola de Nieve";
    }

    @Override
    public void Efecto(Monstruo m){
        m.setVida(m.getVida() - m.getVida());
    }

}
