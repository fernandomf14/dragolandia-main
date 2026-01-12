package com.example;

import com.example.Controlador.Controlador;
import com.example.Modelo.Bosque.Bosque;
import com.example.Modelo.Bosque.ControladorBosque;
import com.example.Modelo.Dragon.ControladorDragon;
import com.example.Modelo.Dragon.Dragon;
import com.example.Modelo.Mago.ControladorMago;
import com.example.Modelo.Mago.Mago;
import com.example.Modelo.Monstruo.ControladorMonstruo;
import com.example.Modelo.Monstruo.Monstruo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class PrincipalManager {

    private final Controlador controlador = new Controlador();
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dragolandiaServizo");

    public static void main(String[] args) {
        PrincipalManager principal = new PrincipalManager();
        Controlador controlador = principal.controlador;

        try (EntityManager em = emf.createEntityManager()) {

            // ===========================
            // PRUEBAS CON MAGOS
            // ===========================
            try {
                Mago mago = controlador.getModelo().getMago();
                ControladorMago.agregarMago(em, mago);
                controlador.getVista().imprimirMensage("Fue insertado correctamente el mago: " + mago);
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al insertar mago: " + e.getMessage());
            }

            try {
                Mago mago2 = controlador.getModelo().getMago();
                ControladorMago.agregarMago(em, mago2);
                controlador.getVista().imprimirMensage("Fue insertado correctamente el mago: " + mago2);
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al insertar mago2: " + e.getMessage());
            }

            try {
                ControladorMago.modificarMagoNombre(em, 1, "Juan el mago");
                controlador.getVista().imprimirMensage("Se ha cambiado el nombre del mago por Juan el mago");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar nombre del mago: " + e.getMessage());
            }

            try {
                ControladorMago.modificarMagoVida(em, 1, 30);
                controlador.getVista().imprimirMensage("Se ha modificado la vida del mago a 30");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar vida del mago: " + e.getMessage());
            }

            try {
                ControladorMago.modificarMagoNivelMagia(em, 1, 30);
                controlador.getVista().imprimirMensage("EL mago 1 fue modificado.");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar nivel de magia del mago: " + e.getMessage());
            }

            try {
                controlador.getVista().imprimirMensage("Lista de magos");
                controlador.getVista().imprimirMensage("----------------------------");
                for (Mago m:ControladorMago.obtenerMagos(em)) {
                    controlador.getVista().imprimirMensage(m.toString());
                }
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al imprimir la lista de magos: " + e.getMessage());
            }

            try {
                ControladorMago.borrarMago(em, 1);
                controlador.getVista().imprimirMensage("EL mago 1 fue borrado.");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al borrar el mago: " + e.getMessage());
            }

            // ===========================
            // PRUEBAS CON DRAGONES
            // ===========================
            try {
                Dragon dragon = controlador.getModelo().getDragon();
                ControladorDragon.agregarDragon(em, dragon);
                controlador.getVista().imprimirMensage("EL dragon " + dragon + " fue insertado.");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al insertar dragon: " + e.getMessage());
            }

            try {
                ControladorDragon.modificarDragonNombre(em, 1, "El dragon de los cielos");
                controlador.getVista().imprimirMensage("EL dragon cambió su nombre a El dragon de los cielos");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar nombre del dragon: " + e.getMessage());
            }

            try {
                ControladorDragon.modificarDragonIntensidadFuego(em, 1, 30);
                controlador.getVista().imprimirMensage("EL dragon tiene nueva intensidad de fuego");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar intensidad de fuego: " + e.getMessage());
            }

            try {
                ControladorDragon.modificarDragonResistencia(em, 1, 30);
                controlador.getVista().imprimirMensage("EL dragon tiene nueva resistencia");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar resistencia del dragon: " + e.getMessage());
            }

            try {
                controlador.getVista().imprimirMensage("Lista de dragones");
                controlador.getVista().imprimirMensage("----------------------------");
                for (Dragon d:ControladorDragon.obtenerDragones(em)) {
                    controlador.getVista().imprimirMensage(d.toString());
                }
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al imprimir la lista de dragones: " + e.getMessage());
            }

            try {
                ControladorDragon.borrarDragon(em, 1);
                controlador.getVista().imprimirMensage("EL dragon ha sido borrado");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al borrar el dragon: " + e.getMessage());
            }

            // ===========================
            // PRUEBAS CON MONSTRUOS
            // ===========================
            try {
                Monstruo monstruo = controlador.getModelo().getBosque().getMonstruoJefe();
                ControladorMonstruo.agregarMonstruo(em, monstruo);
                controlador.getVista().imprimirMensage("EL monstruo " + monstruo + " fue insertado.");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al insertar monstruo: " + e.getMessage());
            }

            try {
                ControladorMonstruo.modificarMonstruoNombre(em, 1, "El troll oscuro");
                controlador.getVista().imprimirMensage("EL monstruo ha cambiado su nombre");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar nombre del monstruo: " + e.getMessage());
            }

            try {
                ControladorMonstruo.modificarMonstruoTipo(em, 1, "ogro");
                controlador.getVista().imprimirMensage("El monstruo ha cambiado su tipo de monstruo");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar tipo del monstruo: " + e.getMessage());
            }

            try {
                ControladorMonstruo.modificarMonstruoVida(em, 1, 60);
                controlador.getVista().imprimirMensage("El monstruo ha cambiado su vida");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar vida del monstruo: " + e.getMessage());
            }

            try {
                controlador.getVista().imprimirMensage("Lista de dragones");
                controlador.getVista().imprimirMensage("----------------------------");
                for (Monstruo m:ControladorMonstruo.obtenerMonstruos(em)) {
                    controlador.getVista().imprimirMensage(m.toString());
                }
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al imprimir la lista de monstruos: " + e.getMessage());
            }

            try {
                ControladorMonstruo.borrarMonstruo(em, 1);
                controlador.getVista().imprimirMensage("El monstruo ha sido eliminado");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al eliminar el monstruo: " + e.getMessage());
            }

            // ===========================
            // PRUEBAS CON BOSQUES
            // ===========================
            try {
                Bosque bosque = controlador.getModelo().getBosque();
                ControladorBosque.agregarBosque(em, bosque);
                controlador.getVista().imprimirMensage("EL bosque " + bosque + " fue insertado.");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al insertar bosque: " + e.getMessage());
            }

            try {
                ControladorBosque.modificarBosqueNombre(em, 1, "El bosque de los vampiros");
                ControladorBosque.modificarBosqueMonstruoJefe(em, 1, new Monstruo("Troll gigante", 110, "troll", 10));
                ControladorBosque.modificarBosqueDragon(em, 1, new Dragon(10, "Dragon de rayos", 120));
                ControladorBosque.modificarBosqueNivelPeligro(em, 1, 2);
                ControladorBosque.modificarBosqueMonstruos(em, 1, new Monstruo("Troll gigante de dos cabezas", 110, "troll", 20));
                controlador.getVista().imprimirMensage("EL bosque 1 fue modificado.");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al modificar bosque: " + e.getMessage());
            }

            try {
                for (Bosque d : ControladorBosque.obtenerBosques(em)) {
                    controlador.getVista().imprimirMensage(d.toString());
                }
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al listar bosques: " + e.getMessage());
            }

            try {
                ControladorBosque.borrarBosque(em, 1);
                controlador.getVista().imprimirMensage("EL bosque 1 fue eliminado");
            } catch (Exception e) {
                controlador.getVista().imprimirMensage("Error al borrar bosque: " + e.getMessage());
            }

        } finally {
            emf.close();
        }

        // ACTIVAR EL COMBATE
        controlador.ComenzarCombate();
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}
