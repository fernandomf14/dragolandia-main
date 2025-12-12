package com.example.Modelo.Hechizo;

import java.util.List;

import com.example.Modelo.Monstruo;

public class DarkBean extends Hechizo {

    public DarkBean() {
        this.nombre = "DarkBean";
    }

    @Override
    public void Efecto(List<Monstruo> lista){
        for (Monstruo m:lista) {
            m.setVida(m.getVida() - 5000);
        }
    }

}
