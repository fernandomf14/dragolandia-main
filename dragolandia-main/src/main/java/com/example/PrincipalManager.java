package com.example;

import com.example.Controlador.Controlador;
import com.example.Modelo.Bosque;
import com.example.Modelo.Dragon;
import com.example.Modelo.Mago;
import com.example.Modelo.Monstruo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class PrincipalManager {
    private final  Controlador controlador = new Controlador();

    public static void main(String[] args) {
        PrincipalManager principal = new PrincipalManager();
        Controlador controlador = principal.controlador;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dragolandiaServizo");

        try (
            EntityManager em = emf.createEntityManager();
        ) {
            em.getTransaction().begin();

            //Metemos el mago:
            Mago mago = controlador.getModelo().getMago();
            em.merge(mago);

            //Metemos el bosque:
            Bosque bosque = controlador.getModelo().getBosque();
            em.merge(bosque);

            //Metemos los monstruos:
            for (Monstruo m:controlador.getModelo().getBosque().getlistaMonstruos()) {
                em.merge(m);
            }

            //Metemos el dragon:
            Dragon dragon = controlador.getModelo().getDragon();
            em.merge(dragon);

            em.getTransaction().commit();

            //Avisos:
            controlador.getVista().imprimirMensage("EL mago " + mago.toString() + " fue insertado.");
            controlador.getVista().imprimirMensage("EL bosque " + bosque.toString() + " fue insertado.");
            for (Monstruo m:controlador.getModelo().getBosque().getlistaMonstruos()) {
                controlador.getVista().imprimirMensage("El monstruo " + m.toString() + " fue insertado");
            }

            controlador.getVista().imprimirMensage("EL dragon " + dragon.toString() + " fue insertado.");

            em.getTransaction().begin();

            //CAMBIAR DATOS DE UN MAGO:
            //Modificar algún objeto de la tabla
            Mago m = em.find(Mago.class, 3);
            m.setNombre("Alberto el mago");

            //AVISOS 
            controlador.getVista().imprimirMensage("Se ha modificado el mago " + m.toString());
            
            em.getTransaction().commit();

        } finally {
            emf.close();
        }
        
        //ACTIVAR EL COMBATE
        controlador.ComenzarCombate();
    }
}
