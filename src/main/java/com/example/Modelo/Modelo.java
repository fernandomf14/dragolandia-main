package com.example.Modelo;

import com.example.Modelo.Hechizo.BolaDeFuego;
import com.example.Modelo.Hechizo.BolaDeNieve;
import com.example.Modelo.Hechizo.DarkBean;
import com.example.Modelo.Hechizo.Hechizo;
import com.example.Modelo.Hechizo.Rayo;

public class Modelo {
    
    private static Modelo instancia;

    private  Mago mago;
    private  Bosque bosque;
    private Dragon dragon;

    public Modelo() {
        inicializarJuego();
    }
    
    //SINGLETON
    public static Modelo getInstancia() {
        if (instancia == null) {
            synchronized (Modelo.class) {
                instancia = new Modelo();
            }
        }
        return instancia;
    }

    //CAMBIAR FUNCIÓN PARA COLOCAR LISTA DE MONSTRUOS

    public final void inicializarJuego() {
        //Creamos los monstruos del bosque
        Monstruo monstruo1 = new Monstruo("Troll Gigante", 100, "ogro", 30);
        Monstruo monstruo2 = new Monstruo("Caballero oscuro", 50, "ogro", 10);

        //Creamos el bosque
        bosque = new Bosque(1, "Bosque encantado", 1, monstruo1, dragon);

        //Agregamos los monstruos al bosque
        bosque.addMonstruos(monstruo1);
        bosque.addMonstruos(monstruo2);

         //Creamos el mago
        mago = new Mago("Merlín", 600, 20);

        //Creamos los hechizos que aprende el mago y los agregamos:
        Hechizo hechizo1 = new BolaDeFuego();
        mago.aprenderHechizo(hechizo1);

        Hechizo hechizo2 = new BolaDeNieve();
        mago.aprenderHechizo(hechizo2);

        Hechizo hechizo3 = new Rayo();
        mago.aprenderHechizo(hechizo3);

        Hechizo hechizo4 = new DarkBean();
        mago.aprenderHechizo(hechizo4);

        //Creamos el dragón
        dragon = new Dragon(1, 10, "Draenor", 10);
    }

    //GETTERS

    public Mago getMago() {
        return mago;
    }

    public Bosque getBosque() {
        return bosque;
    }

    public Dragon getDragon() {
        return dragon;
    }

}
