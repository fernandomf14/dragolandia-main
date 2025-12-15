package com.example.Controlador;

import java.util.Random;

import com.example.Modelo.Bosque;
import com.example.Modelo.Dragon;
import com.example.Modelo.Hechizo.Hechizo;
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
        Dragon dragon = bosque.getDragon();

        vista.imprimirMensage("\n---------------------------------------------------------------------------------------------------------------------------");
        vista.imprimirMensage("Comienza el combate entre el mago " + mago.getNombre() + " en el " + bosque.getNombre() + " contra el monstruo " + monstruo.getNombre());
        vista.imprimirMensage("----------------------------------------------------------------------------------------------------------------------------");

        while (!juegan) {

            //**************************************
            //NOTAS DE COMO VA HA FUNCIONAR EL COMBATE:
            //**************************************
                //El mago ataca a cada monstruo de la lista de monstruos, luego los monstruos atacan a este. 
                // El dragon debe activar su efecto 1 vece (para no saturar), lo hice en turno 3
                //Activar algún hechizo un turno si y otro no

            
            //COMPROBAR QUE EL MAGO GANO, YA QUE SU LISTA DE ENEMIGOS ESTA VACIA
            if (modelo.getBosque().getlistaMonstruos().isEmpty()) {
                vista.imprimirMensage("El mago fue el vencedor del bosque");
                juegan = true;
            }

            vista.imprimirMensage("Turno: " + turno);

            //**************************************
            //ATAQUES DEL MAGO A TODOS LOS MONSTRUOS
            //**************************************
            if (turno%2 == 0) { //TURNO DONDE LANZA UN HECHIZO
                int random = new Random().nextInt(4);
                Hechizo h = modelo.getMago().getConjuros().get(random); 

                for (Monstruo m: bosque.getlistaMonstruos()) {

                    mago.lanzarHechizo(h, m);
                    vista.imprimirMensage("El mago " + mago.getNombre() + " ha lanzado el hechizo " + h.getNombre() + " atacando al monstruo " + m.getNombre());

                    if(m.getVida() <= 0) {
                        bosque.eliminarMonstruo(m);
                    }
                }

            } else { //TURNO NORMAL DONDE NO LANZA UN HECHIZO
                
                for (Monstruo m: bosque.getlistaMonstruos()) {

                    mago.lanzarHechizo(m);
                    vista.imprimirMensage("El mago " + mago.getNombre() + " ha atacado al monstruo " + m.getNombre());

                    if(m.getVida() <= 0) {
                        bosque.eliminarMonstruo(m);
                    }
                }

            }

            //**************************************
            //INTERACCION DEL DRAGON EN EL JUEGO (SOLO UNA VEZ)
            //**************************************

            if (turno == 3) {

                for (Monstruo m: bosque.getlistaMonstruos()) {
                    dragon.exhalar(m);
                    vista.imprimirMensage("El monstruo " + m.getNombre() + " ha sido atacado por el dragon " + dragon.getNombre());
                }

            }

            //**************************************
            //ATAQUES DE LOS MONSTRUOS AL MAGO
            //**************************************

            for (Monstruo m:bosque.getlistaMonstruos()) {
                if (mago.getVida()  <= 0) {
                    vista.imprimirMensage("El mago ha sido derrotado por los monstruos.");
                    juegan = true;
                    break;
                } 
                
                m.atacar(mago);
            }

            //**************************************
            //AUMENTO DE TURNO
            //**************************************

            turno++;

            //**************************************
            //ESTADISTICAS DE ESE TURNO
            //**************************************
            vista.imprimirMensage("La vida del mago es: " + mago.getVida());

            for (Monstruo m:bosque.getlistaMonstruos()) {
                 vista.imprimirMensage("La vida del monstruo es: " + m.getVida());
            }
            vista.imprimirMensage("**********************************");
        }
    }
}
