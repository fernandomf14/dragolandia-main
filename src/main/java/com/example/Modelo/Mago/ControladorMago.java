package com.example.Modelo.Mago;

import java.util.List;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ControladorMago {

    //METODOS PARA EL EntityManagerFactory

    public static void agregarMago(EntityManager em, Mago mago) {
            em.getTransaction().begin();
            em.merge(mago);
            em.getTransaction().commit();
    }

    public static void modificarMagoNombre(EntityManager em, int id, String nombre) {
            em.getTransaction().begin();
            Mago mago = em.find(Mago.class,id);
            mago.setNombre(nombre);
            em.getTransaction().commit();
    }

    public static void modificarMagoVida(EntityManager em,int id, int vida) {
            em.getTransaction().begin();
            Mago mago = em.find(Mago.class,id);
            mago.setVida(vida);
            em.getTransaction().commit();
    }

    public static void modificarMagoNivelMagia(EntityManager em,int id, int nivelMagia) {
            em.getTransaction().begin();
            Mago mago = em.find(Mago.class,id);
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

    //METODOS PARA EL SESSION:

    public static void agregarMago(Session session, Mago mago) {
        Transaction tx = session.beginTransaction();
        session.merge(mago);
        tx.commit();
    }

    public static void modificarMagoNombre(Session session, int id, String nombre) {
        Transaction tx = session.beginTransaction();
        Mago mago = session.get(Mago.class, id);
        if (mago != null) {
            mago.setNombre(nombre);
        }
        tx.commit();
    }

    public static void modificarMagoVida(Session session, int id, int vida) {
        Transaction tx = session.beginTransaction();
        Mago mago = session.get(Mago.class, id);
        if (mago != null) {
            mago.setVida(vida);
        }
        tx.commit();
    }

    public static void modificarMagoNivelMagia(Session session, int id, int nivelMagia) {
        Transaction tx = session.beginTransaction();
        Mago mago = session.get(Mago.class, id);
        if (mago != null) {
            mago.setNivelMagia(nivelMagia);
        }
        tx.commit();
    }

    public static void borrarMago(Session session, int id) {
        Transaction tx = session.beginTransaction();
        Mago mago = session.get(Mago.class, id);
        if (mago != null) {
            session.remove(mago);
        }
        tx.commit();
    }

    public static List<Mago> obtenerMagos(Session session) {
        return session.createQuery("FROM Mago", Mago.class).list();
    }

}
