package com.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

import com.example.Controlador.Controlador;
import com.example.Modelo.Mago;
import com.example.Modelo.Monstruo;
import com.example.Modelo.Bosque;

public final class Principal {
    private final Controlador controlador = new Controlador();
    
    public static void main(String[] args) {
        Principal principal = new Principal();
        Controlador controlador = principal.controlador;

        

        //Creamos los datos en la base de datos.
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {

            Session session = factory.getCurrentSession();
            
            Transaction tx = session.beginTransaction();

            //Guardamos los objetos
            Mago mago = controlador.getModelo().getMago();
            session.merge(mago);

            Bosque bosque = controlador.getModelo().getBosque();
            session.merge(bosque);

            Monstruo monstruo = controlador.getModelo().getBosque().getMonstruoJefe();
            session.merge(monstruo);

            tx.commit();

            //AVISOS 
            System.out.println("Se ha insertado correctamente: ");
            System.out.println(controlador.getModelo().getBosque());
            System.out.println(controlador.getModelo().getMago());
            System.out.println(controlador.getModelo().getBosque().getMonstruoJefe());
            
            controlador.ComenzarCombate();

        } catch(HibernateException e) {
            System.out.println("Se ha lanzado una excepcion en Hibernate" + e.getMessage());
        }



    }
}
