package com.example.Modelo.Hechizo;

import java.util.List;

import com.example.Modelo.Monstruo;

public class Rayo extends Hechizo {

    public Rayo() {
        this.nombre = "Rayo";
    }

    @Override
    public void Efecto(List<Monstruo> lista){
        for (Monstruo m:lista) {
            m.setVida(m.getVida() - 3);
        }
    }

}
