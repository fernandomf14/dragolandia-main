package com.example;

import com.example.Controlador.Controlador;
import com.example.Modelo.Bosque;
import com.example.Modelo.ControladorBosque;
import com.example.Modelo.ControladorDragon;
import com.example.Modelo.ControladorMago;
import com.example.Modelo.ControladorMonstruo;
import com.example.Modelo.Dragon;
import com.example.Modelo.Mago;
import com.example.Modelo.Monstruo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class PrincipalManager {

    private final  Controlador controlador = new Controlador();
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dragolandiaServizo");
    public static void main(String[] args) {
        PrincipalManager principal = new PrincipalManager();
        Controlador controlador = principal.controlador;

        try (
            EntityManager em = emf.createEntityManager();
        ) {

        //PRUEBAS CON HIBERNATE CON LA CLASE MAGO
        //Introducir un mago
        Mago mago = controlador.getModelo().getMago();
        ControladorMago.agregarMago(em,mago);
        controlador.getVista().imprimirMensage("EL mago " + mago.toString() + " fue insertado.");

        //Cambiar al mago
        ControladorMago.modificarMagoNombre(em,mago, "Juan el mago");
        controlador.getVista().imprimirMensage("EL mago " + mago.toString() + " fue modificado.");

        ControladorMago.modificarMagoVida(em,mago, 30);
        controlador.getVista().imprimirMensage("EL mago " + mago.toString() + " fue modificado.");

        ControladorMago.modificarMagoNivelMagia(em,mago, 30);
        controlador.getVista().imprimirMensage("EL mago " + mago.toString() + " fue modificado.");

        controlador.getVista().imprimirMensage("Lista de todos los magos:");
        controlador.getVista().imprimirMensage("\n---------------------------------------------------------------------------------------------------------------------------");
        
        //Monstrar todos los magos
        for (Mago m:ControladorMago.obtenerMagos(em)) {
            controlador.getVista().imprimirMensage(m.toString());
        }

        //Borrar al mago
        ControladorMago.borrarMago(em,3);
        controlador.getVista().imprimirMensage("EL mago " + mago.toString() + " fue eliminado");

        //PRUEBAS CON HIBERNATE CON LA CLASE DRAGON
        //Introducir un dragon
        Dragon dragon = controlador.getModelo().getDragon();
        ControladorDragon.agregarDragon(em,dragon);
        controlador.getVista().imprimirMensage("EL dragon " + dragon.toString() + " fue insertado.");

        //Cambiar al dragon
        ControladorDragon.modificarDragonNombre(em,dragon, "El dragon de los cielos");
        controlador.getVista().imprimirMensage("EL dragon " + dragon.toString() + " fue modificado.");

        ControladorDragon.modificarDragonINtensidadFuego(em,dragon, 30);
        controlador.getVista().imprimirMensage("EL dragon " + dragon.toString() + " fue modificado.");

        ControladorDragon.modificarDragonResistencia(em,dragon, 30);
        controlador.getVista().imprimirMensage("EL dragon " + dragon.toString() + " fue modificado.");

        controlador.getVista().imprimirMensage("Lista de todos los dragones:");
        controlador.getVista().imprimirMensage("\n---------------------------------------------------------------------------------------------------------------------------");
        
        //Monstrar todos los dragones
        for (Dragon d:ControladorDragon.obtenerDragones(em)) {
            controlador.getVista().imprimirMensage(d.toString());
        }

        //Borrar al dragon
        ControladorDragon.borrarDragon(em,3);
        controlador.getVista().imprimirMensage("EL dragon " + dragon.toString() + " fue eliminado");

        //PRUEBAS CON HIBERNATE CON LA CLASE MONSTRUO
        //Introducir un monstruo
        Monstruo monstruo = controlador.getModelo().getBosque().getMonstruoJefe();
        ControladorMonstruo.agregarMonstruo(em,monstruo);
        controlador.getVista().imprimirMensage("EL monstruo " + monstruo.toString() + " fue insertado.");

        //Cambiar al monstruo
        ControladorMonstruo.modificarMonstruoNombre(em,monstruo, "El troll oscuro");
        controlador.getVista().imprimirMensage("EL monstruo " + monstruo.toString() + " fue modificado.");

        ControladorMonstruo.modificarMonstruoTipo(em,monstruo, "ogro");
        controlador.getVista().imprimirMensage("EL monstruo " + monstruo.toString() + " fue modificado.");

        ControladorMonstruo.modificarMonstruoVida(em,monstruo, 60);
        controlador.getVista().imprimirMensage("EL monstruo " + monstruo.toString() + " fue modificado.");

        controlador.getVista().imprimirMensage("Lista de todos los monstruos:");
        controlador.getVista().imprimirMensage("\n---Controlador controlador = principal.controlador;------------------------------------------------------------------------------------------------------------------------");
        
        //Monstrar todos los monstruos
        for (Monstruo d:ControladorMonstruo.obtenerMonstruos(em)) {
            controlador.getVista().imprimirMensage(d.toString());
        }

        //Borrar al Monstruo
        ControladorMonstruo.borrarMonstruo(em,3);
        controlador.getVista().imprimirMensage("EL monstruo " + monstruo.toString() + " fue eliminado");

        //PRUEBAS CON HIBERNATE CON LA CLASE BOSQUE
        //Introducir un bosque
        Bosque bosque = controlador.getModelo().getBosque();
        ControladorBosque.agregarBosque(em,bosque);
        controlador.getVista().imprimirMensage("EL bosque " + bosque.toString() + " fue insertado.");

        //Cambiar al bosque
        ControladorBosque.modificarBosqueNombre(em,bosque, "El bosque de los vampiros");
        controlador.getVista().imprimirMensage("EL bosque " + bosque.toString() + " fue modificado.");

        ControladorBosque.modificarBosqueMonstruoJefe(em,bosque, monstruo);
        controlador.getVista().imprimirMensage("EL bosque " + bosque.toString() + " fue modificado.");

        ControladorBosque.modificarBosqueDragon(em,bosque, dragon);
        controlador.getVista().imprimirMensage("EL bosque " + bosque.toString() + " fue modificado.");

        ControladorBosque.modificarBosqueNivelPeligro(em,bosque, 2);
        controlador.getVista().imprimirMensage("EL bosque " + bosque.toString() + " fue modificado.");

        ControladorBosque.modificarBosqueMonstruos(em,bosque, monstruo);
        controlador.getVista().imprimirMensage("EL bosque " + bosque.toString() + " fue modificado.");

        controlador.getVista().imprimirMensage("Lista de todos los bosques:");
        controlador.getVista().imprimirMensage("\n---------------------------------------------------------------------------------------------------------------------------");
        
        //Monstrar todos los bosques
        for (Bosque d:ControladorBosque.obtenerBosques(em)) {
            controlador.getVista().imprimirMensage(d.toString());
        }

        //Borrar al bosque
        ControladorBosque.borrarBosque(em,3);
        controlador.getVista().imprimirMensage("EL bosque " + monstruo.toString() + " fue eliminado");

        } finally {
            emf.close();
        }

        /*try (
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
        }*/
        
        //ACTIVAR EL COMBATE
        //controlador.ComenzarCombate();

    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}
