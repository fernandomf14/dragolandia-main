package com.example.Controlador;

import java.util.ArrayList;
import java.util.Random;

import com.example.Modelo.Bosque.Bosque;
import com.example.Modelo.Dragon.Dragon;
import com.example.Modelo.Hechizo.Hechizo;
import com.example.Modelo.Mago.Mago;
import com.example.Modelo.Modelo;
import com.example.Modelo.Monstruo.Monstruo;
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
        boolean juegoTerminado = false;

        Mago mago = modelo.getMago();
        Bosque bosque = modelo.getBosque();
        Dragon dragon = bosque.getDragon();

        vista.imprimirMensage("\n---------------------------------------------------------------------------------------------------------------------------");
        vista.imprimirMensage("Comienza el combate entre el mago " + mago.getNombre() + " en el " + bosque.getNombre()
            + " contra el monstruo jefe " + bosque.getMonstruoJefe().getNombre());
        vista.imprimirMensage("----------------------------------------------------------------------------------------------------------------------------");

        while (!juegoTerminado) {
            vista.imprimirMensage("\nTurno: " + turno);
            vista.imprimirMensage("Vida del mago: " + mago.getVida());

            // Mostrar vida de todos los monstruos
            for (Monstruo m : bosque.getlistaMonstruos()) {
                vista.imprimirMensage("Vida del monstruo " + m.getNombre() + ": " + m.getVida());
            }
            vista.imprimirMensage("**********************************");

            // Comprobar si el mago ya ganó
            if (bosque.getlistaMonstruos().isEmpty()) {
                vista.imprimirMensage("El mago fue el vencedor del bosque");
                break;
            }

            // ATAQUE DEL MAGO
            if (turno % 2 == 0 && !mago.getConjuros().isEmpty()) { // turno de hechizo
                int random = new Random().nextInt(mago.getConjuros().size());
                Hechizo h = mago.getConjuros().get(random);

                for (Monstruo m : new ArrayList<>(bosque.getlistaMonstruos())) {
                    mago.lanzarHechizo(h, m);
                    vista.imprimirMensage("El mago " + mago.getNombre() + " ha lanzado el hechizo " + h.getNombre()
                        + " al monstruo " + m.getNombre() + " (vida: " + m.getVida() + ")");

                    if (m.getVida() <= 0) {
                        bosque.eliminarMonstruo(m);
                        vista.imprimirMensage("El monstruo " + m.getNombre() + " ha sido derrotado");
                    }
                }

            } else { // turno normal
                for (Monstruo m : new ArrayList<>(bosque.getlistaMonstruos())) {
                    mago.lanzarHechizo(m); // ataque normal
                    vista.imprimirMensage("El mago " + mago.getNombre() + " ha atacado al monstruo " + m.getNombre()
                        + " (vida: " + m.getVida() + ")");

                    if (m.getVida() <= 0) {
                        bosque.eliminarMonstruo(m);
                        vista.imprimirMensage("El monstruo " + m.getNombre() + " ha sido derrotado");
                    }
                }
            }

            // ATAQUE DEL DRAGÓN (solo una vez, turno 3 y si hay monstruos)
            if (turno == 3 && !bosque.getlistaMonstruos().isEmpty()) {
                for (Monstruo m : new ArrayList<>(bosque.getlistaMonstruos())) {
                    dragon.exhalar(m);
                    vista.imprimirMensage("El dragón " + dragon.getNombre() + " ha atacado al monstruo " + m.getNombre()
                        + " (vida: " + m.getVida() + ")");

                    if (m.getVida() <= 0) {
                        bosque.eliminarMonstruo(m);
                        vista.imprimirMensage("El monstruo " + m.getNombre() + " ha sido derrotado por el dragón");
                    }
                }
            }

            // ATAQUE DE LOS MONSTRUOS AL MAGO
            for (Monstruo m : bosque.getlistaMonstruos()) {
                m.atacar(mago);
                vista.imprimirMensage("El monstruo " + m.getNombre() + " ha atacado al mago " + mago.getNombre()
                    + " (vida del mago: " + mago.getVida() + ")");

                if (mago.getVida() <= 0) {
                    vista.imprimirMensage("El mago ha sido derrotado por los monstruos.");
                    juegoTerminado = true;
                    break;
                }
            }

            // Comprobar si ya no quedan monstruos después de todo
            if (bosque.getlistaMonstruos().isEmpty()) {
                vista.imprimirMensage("El mago ha vencido a todos los monstruos del bosque.");
                juegoTerminado = true;
            }

            turno++;
        }
    }

}
