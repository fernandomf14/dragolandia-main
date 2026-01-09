package com.example.Modelo;

import java.util.List;

import jakarta.persistence.EntityManager;

public class ControladorBosque {

    public static void agregarBosque(EntityManager em,Bosque bosque) {
            em.getTransaction().begin();
            em.merge(bosque);
            em.getTransaction().commit();
    }

    public static void modificarBosqueNombre(EntityManager em,Bosque bosque, String nombre) {
            em.getTransaction().begin();
            bosque.setNombre(nombre);
            em.getTransaction().commit();
    }

    public static void modificarBosqueNivelPeligro(EntityManager em,Bosque bosque, int nivelPeligro) {
            em.getTransaction().begin();
            bosque.setNivelPeligro(nivelPeligro);
            em.getTransaction().commit();
    }

    public static void modificarBosqueMonstruoJefe(EntityManager em,Bosque bosque, Monstruo monstruo) {
            em.getTransaction().begin();
            bosque.setMonstruoJefe(monstruo);
            em.getTransaction().commit();
    }

    public static void modificarBosqueDragon(EntityManager em,Bosque bosque, Dragon dragon) {
            em.getTransaction().begin();
            bosque.setDragon(dragon);
            em.getTransaction().commit();
    }

    public static void modificarBosqueMonstruos(EntityManager em,Bosque bosque, Monstruo monstruo) {
            em.getTransaction().begin();
            bosque.addMonstruos(monstruo);
            em.getTransaction().commit();
    }

    public static void borrarBosque(EntityManager em,int id) {
            em.getTransaction().begin();
            Bosque bosque = em.find(Bosque.class, id);
            em.remove(bosque);
            em.getTransaction().commit();
    }

    public static List<Bosque> obtenerBosques(EntityManager em) {
            return em.createQuery(
                "FROM Bosque", Bosque.class
            ).getResultList();
    }
}
