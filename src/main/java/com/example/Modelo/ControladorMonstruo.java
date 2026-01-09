package com.example.Modelo;

import java.util.List;

import jakarta.persistence.EntityManager;

public class ControladorMonstruo {

    public static void agregarMonstruo(EntityManager em,Monstruo monstruo) {
            em.getTransaction().begin();
            em.merge(monstruo);
            em.getTransaction().commit();
    }

    public static void modificarMonstruoNombre(EntityManager em,Monstruo monstruo, String nombre) {
            em.getTransaction().begin();
            monstruo.setNombre(nombre);
            em.getTransaction().commit();
    }

    public static void modificarMonstruoTipo(EntityManager em,Monstruo monstruo, String tipo) {
            em.getTransaction().begin();
            monstruo.setTipo(tipo);
            em.getTransaction().commit();
    }

    public static void modificarMonstruoVida(EntityManager em,Monstruo monstruo, int vida) {
            em.getTransaction().begin();
            monstruo.setVida(vida);
            em.getTransaction().commit();
    }

    public static void borrarMonstruo(EntityManager em,int id) {
            em.getTransaction().begin();
            Monstruo monstruo = em.find(Monstruo.class, id);
            em.remove(monstruo);
            em.getTransaction().commit();
    }

    public static List<Monstruo> obtenerMonstruos(EntityManager em) {
            return em.createQuery(
                "FROM Monstruo", Monstruo.class
            ).getResultList();
    }

}
