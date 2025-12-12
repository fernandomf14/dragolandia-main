package com.example.Modelo.Hechizo;

import java.util.List;

import com.example.Modelo.Monstruo;

public class BolaDeNieve extends Hechizo {

    public BolaDeNieve() {
        this.nombre = "Bola de Nieve";
    }

    @Override
    public void Efecto(List<Monstruo> lista){
        for (Monstruo m:lista) {
            m.setVida(m.getVida() - m.getVida());
        }
    }

}
