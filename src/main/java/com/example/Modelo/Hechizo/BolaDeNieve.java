package com.example.Modelo.Hechizo;

import com.example.Modelo.Monstruo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Hechizo_nieve")
public class BolaDeNieve extends Hechizo {

    public BolaDeNieve() {
        this.nombre = "Bola de Nieve";
    }

    @Override
    public void Efecto(Monstruo m){
        m.setVida(0);
    }

}
