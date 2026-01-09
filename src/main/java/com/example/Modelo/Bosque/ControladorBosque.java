package com.example.Modelo.Bosque;

import java.util.List;

import com.example.Modelo.Dragon.Dragon;
import com.example.Modelo.Monstruo.Monstruo;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ControladorBosque {

    public static void agregarBosque(EntityManager em, Bosque bosque) {
            em.getTransaction().begin();
            em.merge(bosque);
            em.getTransaction().commit();
    }

    public static void modificarBosqueNombre(EntityManager em,int id, String nombre) {
            em.getTransaction().begin();
            Bosque bosque = em.find(Bosque.class,id);
            bosque.setNombre(nombre);
            em.getTransaction().commit();
    }

    public static void modificarBosqueNivelPeligro(EntityManager em,int id, int nivelPeligro) {
            em.getTransaction().begin();
            Bosque bosque = em.find(Bosque.class,id);
            bosque.setNivelPeligro(nivelPeligro);
            em.getTransaction().commit();
    }

    public static void modificarBosqueMonstruoJefe(EntityManager em,int id, Monstruo monstruo) {
            em.getTransaction().begin();
            Bosque bosque = em.find(Bosque.class,id);
            bosque.setMonstruoJefe(monstruo);
            em.getTransaction().commit();
    }

    public static void modificarBosqueDragon(EntityManager em,int id, Dragon dragon) {
            em.getTransaction().begin();
            Bosque bosque = em.find(Bosque.class,id);
            bosque.setDragon(dragon);
            em.getTransaction().commit();
    }

    public static void modificarBosqueMonstruos(EntityManager em,int id, Monstruo monstruo) {
            em.getTransaction().begin();
            Bosque bosque = em.find(Bosque.class,id);
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

    public static void agregarBosque(Session session, Bosque bosque) {
        Transaction tx = session.beginTransaction();
        session.merge(bosque);
        tx.commit();
    }

    public static void modificarBosqueNombre(Session session, int id, String nombre) {
        Transaction tx = session.beginTransaction();
        Bosque bosque = session.get(Bosque.class, id);
        if (bosque != null) bosque.setNombre(nombre);
        tx.commit();
    }

    public static void modificarBosqueNivelPeligro(Session session, int id, int nivelPeligro) {
        Transaction tx = session.beginTransaction();
        Bosque bosque = session.get(Bosque.class, id);
        if (bosque != null) bosque.setNivelPeligro(nivelPeligro);
        tx.commit();
    }

    public static void modificarBosqueMonstruoJefe(Session session, int id, Monstruo monstruo) {
        Transaction tx = session.beginTransaction();
        Bosque bosque = session.get(Bosque.class, id);
        if (bosque != null) bosque.setMonstruoJefe(monstruo);
        tx.commit();
    }

    public static void modificarBosqueDragon(Session session, int id, Dragon dragon) {
        Transaction tx = session.beginTransaction();
        Bosque bosque = session.get(Bosque.class, id);
        if (bosque != null) bosque.setDragon(dragon);
        tx.commit();
    }

    public static void modificarBosqueMonstruos(Session session, int id, Monstruo monstruo) {
        Transaction tx = session.beginTransaction();
        Bosque bosque = session.get(Bosque.class, id);
        if (bosque != null) bosque.addMonstruos(monstruo);
        tx.commit();
    }

    public static void borrarBosque(Session session, int id) {
        Transaction tx = session.beginTransaction();
        Bosque bosque = session.get(Bosque.class, id);
        if (bosque != null) session.remove(bosque);
        tx.commit();
    }

    public static List<Bosque> obtenerBosques(Session session) {
        return session.createQuery("FROM Bosque", Bosque.class).list();
    }
}
