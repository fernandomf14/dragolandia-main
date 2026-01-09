package com.example.Modelo.Monstruo;

import java.util.List;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ControladorMonstruo {

    public static void agregarMonstruo(EntityManager em, Monstruo monstruo) {
            em.getTransaction().begin();
            em.merge(monstruo);
            em.getTransaction().commit();
    }

    public static void modificarMonstruoNombre(EntityManager em,int id, String nombre) {
            em.getTransaction().begin();
            Monstruo monstruo = em.find(Monstruo.class, id);
            monstruo.setNombre(nombre);
            em.getTransaction().commit();
    }

    public static void modificarMonstruoTipo(EntityManager em,int id, String tipo) {
            em.getTransaction().begin();
            Monstruo monstruo = em.find(Monstruo.class, id);
            monstruo.setTipo(tipo);
            em.getTransaction().commit();
    }

    public static void modificarMonstruoVida(EntityManager em,int id, int vida) {
            em.getTransaction().begin();
            Monstruo monstruo = em.find(Monstruo.class, id);
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

    public static void agregarMonstruo(Session session, Monstruo monstruo) {
        Transaction tx = session.beginTransaction();
        session.merge(monstruo);
        tx.commit();
    }

    public static void modificarMonstruoNombre(Session session, int id, String nombre) {
        Transaction tx = session.beginTransaction();
        Monstruo monstruo = session.get(Monstruo.class, id);
        if (monstruo != null) monstruo.setNombre(nombre);
        tx.commit();
    }

    public static void modificarMonstruoTipo(Session session, int id, String tipo) {
        Transaction tx = session.beginTransaction();
        Monstruo monstruo = session.get(Monstruo.class, id);
        if (monstruo != null) monstruo.setTipo(tipo);
        tx.commit();
    }

    public static void modificarMonstruoVida(Session session, int id, int vida) {
        Transaction tx = session.beginTransaction();
        Monstruo monstruo = session.get(Monstruo.class, id);
        if (monstruo != null) monstruo.setVida(vida);
        tx.commit();
    }

    public static void borrarMonstruo(Session session, int id) {
        Transaction tx = session.beginTransaction();
        Monstruo monstruo = session.get(Monstruo.class, id);
        if (monstruo != null) session.remove(monstruo);
        tx.commit();
    }

    public static List<Monstruo> obtenerMonstruos(Session session) {
        return session.createQuery("FROM Monstruo", Monstruo.class).list();
    }

}
