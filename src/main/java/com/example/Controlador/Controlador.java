package com.example.Controlador;

import com.example.Modelo.Bosque;
import com.example.Modelo.Mago;
import com.example.Modelo.Modelo;
import com.example.Modelo.Monstruo;
import com.example.Vista.Vista;

public class Controlador {
    private final Modelo modelo;
    private final Vista vista;

    public Controlador() {
        this.modelo = new Modelo();
        this.vista = new Vista();
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Vista getVista() {
        return vista;
    }

    public void ComenzarCombate() {
        int turno = 1;

        @SuppressWarnings("unused")
        Boolean juegan = false;

        Mago mago = modelo.getMago();
        Bosque bosque = modelo.getBosque();
        Monstruo monstruo = bosque.getMonstruoJefe();

        vista.imprimirMensage("\n---------------------------------------------------------------------------------------------------------------------------");
        vista.imprimirMensage("Comienza el combate entre el mago " + mago.getNombre() + " en el " + bosque.getNombre() + " contra el monstruo " + monstruo.getNombre());
        vista.imprimirMensage("----------------------------------------------------------------------------------------------------------------------------");

        while (!juegan) {

            vista.imprimirMensage("Turno: " + turno);

            mago.lanzarHechizo(monstruo);

            if (monstruo.getVida() <= 0) {
                vista.imprimirMensage("El mago es el vencedor en el bosque\n");
                juegan = true;
            } else {
                monstruo.atacar(mago);

                if (mago.getVida() <= 0) {
                    vista.imprimirMensage("El monstruo es el vencedor en el bosque");
                    juegan = true; // también afecta la condición
                }
            }

            turno++;
            vista.imprimirMensage("La vida del mago es: " + mago.getVida());
            vista.imprimirMensage("La vida del monstruo es: " + monstruo.getVida());
            vista.imprimirMensage("**********************************");
        }
    }
}
