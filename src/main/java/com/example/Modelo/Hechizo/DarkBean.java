package com.example.Modelo.Hechizo;

import com.example.Modelo.Monstruo;

public class DarkBean extends Hechizo {

    public DarkBean() {
        this.nombre = "DarkBean";
    }

    @Override
    public void Efecto(Monstruo m){
        m.setVida(m.getVida() - 5000);
    }

}
