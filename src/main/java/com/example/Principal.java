package com.example;

import com.example.Modelo.Bosque.ControladorBosque;
import com.example.Modelo.Dragon.ControladorDragon;
import com.example.Modelo.Mago.ControladorMago;
import com.example.Modelo.Monstruo.ControladorMonstruo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Controlador.Controlador;
import com.example.Modelo.Bosque.Bosque;
import com.example.Modelo.Dragon.Dragon;
import com.example.Modelo.Mago.Mago;
import com.example.Modelo.Monstruo.Monstruo;

public final class Principal {
    final Controlador controlador = new Controlador();

    public static void main(String[] args) {
        Principal principal = new Principal();
        Controlador controlador = principal.controlador;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {

            Session session = factory.getCurrentSession();

            // ===========================
            // MAGOS
            // ===========================
            try {
                Mago mago = controlador.getModelo().getMago();
                ControladorMago.agregarMago(session, mago);
                controlador.getVista().imprimirMensage("Se ha insertado el mago: " + mago);
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al insertar mago: " + e.getMessage());
            }

            try {
                ControladorMago.modificarMagoNombre(session, 1, "Juan el mago");
                controlador.getVista().imprimirMensage("Se ha modificado el nombre del mago 1 a Juan el mago");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar nombre del mago: " + e.getMessage());
            }

            try {
                ControladorMago.modificarMagoVida(session, 1, 40);
                controlador.getVista().imprimirMensage("Se ha modificado la vida del mago 1 a 40");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar la vida del mago: " + e.getMessage());
            }

            try {
                ControladorMago.modificarMagoNivelMagia(session, 1, 40);
                controlador.getVista().imprimirMensage("Se ha modificado el nivel de magia del mago 1 a 40");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar el nivel de magia del mago: " + e.getMessage());
            }

            controlador.getVista().imprimirMensage("Lista de magos:");
            controlador.getVista().imprimirMensage("-----------------------------");
            for (Mago m:ControladorMago.obtenerMagos(session)) {
                controlador.getVista().imprimirMensage(m.toString());
            }

            try {
                ControladorMago.borrarMago(session, 1);
                controlador.getVista().imprimirMensage("Se ha eliminado el mago 1");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al borrar mago: " + e.getMessage());
            }

            // ===========================
            // DRAGONES
            // ===========================
            try {
                Dragon dragon = controlador.getModelo().getDragon();
                ControladorDragon.agregarDragon(session, dragon);
                controlador.getVista().imprimirMensage("Se ha insertado el dragon: " + dragon);
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al insertar dragon: " + e.getMessage());
            }

            try {
                ControladorDragon.modificarDragonNombre(session, 1, "El dragon de los cielos");
                controlador.getVista().imprimirMensage("Se ha modificado el nombre del dragon 1");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar nombre del dragon: " + e.getMessage());
            }

            try {
                ControladorDragon.modificarDragonIntensidadFuego(session, 1,30);
                controlador.getVista().imprimirMensage("Se ha modificado la intensidad de fuego del dragon 1");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al borrar dragon: " + e.getMessage());
            }

            try {
                ControladorDragon.modificarDragonResistencia(session, 1,30);
                controlador.getVista().imprimirMensage("Se ha modificado la resistencia del dragon 1");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar la resistencia del dragon: " + e.getMessage());
            }

            try {
                controlador.getVista().imprimirMensage("Lista de dragones:");
                controlador.getVista().imprimirMensage("-----------------------------");
                for (Dragon d:ControladorDragon.obtenerDragones(session)) {
                    controlador.getVista().imprimirMensage(d.toString());
                }
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al imprimir la lista de dragones: " + e.getMessage());
            }

            try {
                ControladorDragon.borrarDragon(session, 1);
                controlador.getVista().imprimirMensage("Se ha eliminado el dragon 1");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al borrar dragon: " + e.getMessage());
            }

            // ===========================
            // MONSTRUOS
            // ===========================
            try {
                Monstruo monstruo = controlador.getModelo().getBosque().getMonstruoJefe();
                ControladorMonstruo.agregarMonstruo(session, monstruo);
                controlador.getVista().imprimirMensage("Se ha insertado el monstruo: " + monstruo);
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al insertar monstruo: " + e.getMessage());
            }

            try {
                ControladorMonstruo.modificarMonstruoNombre(session, 1, "El troll oscuro");
                controlador.getVista().imprimirMensage("Se ha modificado el nombre del monstruo 1");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar nombre del monstruo: " + e.getMessage());
            }

            try {
                ControladorMonstruo.modificarMonstruoTipo(session, 1, "troll");
                controlador.getVista().imprimirMensage("Se ha modificado el tipo del monstruo 1");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar el tipo del monstruo: " + e.getMessage());
            }

            try {
                ControladorMonstruo.modificarMonstruoVida(session, 1, 50);
                controlador.getVista().imprimirMensage("Se ha modificado la vida del monstruo 1");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar la vida del monstruo: " + e.getMessage());
            }

            try {
                controlador.getVista().imprimirMensage("Lista de Monstruos:");
                controlador.getVista().imprimirMensage("-----------------------------");
                for (Monstruo m:ControladorMonstruo.obtenerMonstruos(session)) {
                    controlador.getVista().imprimirMensage(m.toString());
                }
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al obtener la lista de monstruos: " + e.getMessage());
            }

            try {
                ControladorMonstruo.borrarMonstruo(session, 1);
                controlador.getVista().imprimirMensage("Se ha eliminado el monstruo 1");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al borrar monstruo: " + e.getMessage());
            }

            // ===========================
            // BOSQUES
            // ===========================
            try {
                Bosque bosque = controlador.getModelo().getBosque();
                ControladorBosque.agregarBosque(session, bosque);
                controlador.getVista().imprimirMensage("Se ha insertado el bosque: " + bosque);
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al insertar bosque: " + e.getMessage());
            }

            try {
                ControladorBosque.modificarBosqueNombre(session, 1, "El bosque de los vampiros");
                controlador.getVista().imprimirMensage("Se ha modificado el nombre del bosque 1");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar nombre del bosque: " + e.getMessage());
            }

            try {
                ControladorBosque.modificarBosqueNivelPeligro(session, 1, 3);
                controlador.getVista().imprimirMensage("Se ha modificado el nivel de peligro del bosque 1");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar nombre del bosque: " + e.getMessage());
            }

            try {
                ControladorBosque.modificarBosqueMonstruoJefe(session, 1, new Monstruo("Troll oscuro",10,"troll",40));
                controlador.getVista().imprimirMensage("Se ha modificado el monstruo jefe del bosque 1");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar nombre del bosque: " + e.getMessage());
            }

            try {
                ControladorBosque.modificarBosqueDragon(session, 1, new Dragon(10,"Dragon de luz",20));
                controlador.getVista().imprimirMensage("Se ha modificado el dragon del bosque 1");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar nombre del bosque: " + e.getMessage());
            }

            try {
                ControladorBosque.modificarBosqueMonstruos(session, 1, new Monstruo("orco de las profundidades",50,"orco",40));
                controlador.getVista().imprimirMensage("Se ha agregado el monstruo al bosque 1");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar nombre del bosque: " + e.getMessage());
            }

            try {
                controlador.getVista().imprimirMensage("Lista de bosques:");
                controlador.getVista().imprimirMensage("-----------------------------");
                for (Bosque b:ControladorBosque.obtenerBosques(session)) {
                    controlador.getVista().imprimirMensage(b.toString());
                }
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al imprimir la lista de bosques: " + e.getMessage());
            }

            try {
                ControladorBosque.borrarBosque(session, 1);
                controlador.getVista().imprimirMensage("Se ha eliminado el bosque 1");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al borrar bosque: " + e.getMessage());
            }

        } catch (HibernateException e) {
            controlador.getVista().imprimirMensage("Error al abrir la sesión Hibernate: " + e.getMessage());
        }

        //ACTIVAR EL COMBATE
        controlador.ComenzarCombate();

    }
}
