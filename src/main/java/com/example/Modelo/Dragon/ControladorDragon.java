package com.example.Modelo.Dragon;

import java.util.List;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ControladorDragon {
    public static void agregarDragon(EntityManager em, Dragon dragon) {
            em.getTransaction().begin();
            em.merge(dragon);
            em.getTransaction().commit();
    }

    public static void modificarDragonNombre(EntityManager em,int id, String nombre) {
            em.getTransaction().begin();
            Dragon dragon = em.find(Dragon.class,id);
            dragon.setNombre(nombre);
            em.getTransaction().commit();
    }

    public static void modificarDragonIntensidadFuego(EntityManager em,int id, int intensidad) {
            em.getTransaction().begin();
            Dragon dragon = em.find(Dragon.class,id);
            dragon.setIntensidadFuego(intensidad);
            em.getTransaction().commit();
    }

    public static void modificarDragonResistencia(EntityManager em,int id, int resistencia) {
            em.getTransaction().begin();
            Dragon dragon = em.find(Dragon.class,id);
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

    public static void agregarDragon(Session session, Dragon dragon) {
        Transaction tx = session.beginTransaction();
        session.merge(dragon);
        tx.commit();
    }

    public static void modificarDragonNombre(Session session, int id, String nombre) {
        Transaction tx = session.beginTransaction();
        Dragon dragon = session.get(Dragon.class, id);
        if (dragon != null) dragon.setNombre(nombre);
        tx.commit();
    }

    public static void modificarDragonIntensidadFuego(Session session, int id, int intensidad) {
        Transaction tx = session.beginTransaction();
        Dragon dragon = session.get(Dragon.class, id);
        if (dragon != null) dragon.setIntensidadFuego(intensidad);
        tx.commit();
    }

    public static void modificarDragonResistencia(Session session, int id, int resistencia) {
        Transaction tx = session.beginTransaction();
        Dragon dragon = session.get(Dragon.class, id);
        if (dragon != null) dragon.setResistencia(resistencia);
        tx.commit();
    }

    public static void borrarDragon(Session session, int id) {
        Transaction tx = session.beginTransaction();
        Dragon dragon = session.get(Dragon.class, id);
        if (dragon != null) session.remove(dragon);
        tx.commit();
    }

    public static List<Dragon> obtenerDragones(Session session) {
        return session.createQuery("FROM Dragon", Dragon.class).list();
    }
}
