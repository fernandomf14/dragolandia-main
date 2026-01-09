package com.example.Modelo;

import java.util.List;

import jakarta.persistence.EntityManager;

public class ControladorDragon {
    public static void agregarDragon(EntityManager em,Dragon dragon) {
            em.getTransaction().begin();
            em.merge(dragon);
            em.getTransaction().commit();
    }

    public static void modificarDragonNombre(EntityManager em,Dragon dragon, String nombre) {
            em.getTransaction().begin();
            dragon.setNombre(nombre);
            em.getTransaction().commit();
    }

    public static void modificarDragonINtensidadFuego(EntityManager em,Dragon dragon, int intensidad) {
            em.getTransaction().begin();
            dragon.setIntensidadFuego(intensidad);
            em.getTransaction().commit();
    }

    public static void modificarDragonResistencia(EntityManager em,Dragon dragon, int resistencia) {
            em.getTransaction().begin();
            dragon.setResistencia(resistencia);
            em.getTransaction().commit();
    }

    public static void borrarDragon(EntityManager em,int id) {
            em.getTransaction().begin();
            Dragon dragon = em.find(Dragon.class, id);
            em.remove(dragon);
            em.getTransaction().commit();
    }

    public static List<Dragon> obtenerDragones(EntityManager em) {
            return em.createQuery(
                "FROM Dragon", Dragon.class
            ).getResultList();
    }
}
