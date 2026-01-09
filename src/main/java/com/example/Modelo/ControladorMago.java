package com.example.Modelo;

import java.util.List;

import com.example.PrincipalManager;

import jakarta.persistence.EntityManager;

public class ControladorMago {

    public static void agregarMago(EntityManager em, Mago mago) {
            em.getTransaction().begin();
            em.merge(mago);
            em.getTransaction().commit();
    }

    public static void modificarMagoNombre(EntityManager em, Mago mago, String nombre) {
            em.getTransaction().begin();
            mago.setNombre(nombre);
            em.getTransaction().commit();
    }

    public static void modificarMagoVida(EntityManager em,Mago mago, int vida) {
            em.getTransaction().begin();
            mago.setVida(vida);
            em.getTransaction().commit();
    }

    public static void modificarMagoNivelMagia(EntityManager em,Mago mago, int nivelMagia) {
            em.getTransaction().begin();
            mago.setNivelMagia(nivelMagia);
            em.getTransaction().commit();
    }

    public static void borrarMago(EntityManager em,int id) {
            em.getTransaction().begin();
            Mago mago = em.find(Mago.class, id);
            em.remove(mago);
            em.getTransaction().commit();
    }

    public static List<Mago> obtenerMagos(EntityManager em) {
            return em.createQuery(
                "FROM Mago", Mago.class
            ).getResultList();
    }
}
