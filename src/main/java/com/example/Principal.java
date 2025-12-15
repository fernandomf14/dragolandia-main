package com.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Controlador.Controlador;
import com.example.Modelo.Bosque;
import com.example.Modelo.Dragon;
import com.example.Modelo.Mago;
import com.example.Modelo.Monstruo;

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

            for (Monstruo m:controlador.getModelo().getBosque().getlistaMonstruos()) {
                session.merge(m);
            }

            Dragon dragon = controlador.getModelo().getBosque().getDragon();
            session.merge(dragon);

            tx.commit();

            //AVISOS 
            controlador.getVista().imprimirMensage("Se ha insertado correctamente: ");
            System.out.println(controlador.getModelo().getBosque());
            System.out.println(controlador.getModelo().getMago());
            System.out.println(controlador.getModelo().getBosque().getMonstruoJefe());
            System.out.println(controlador.getModelo().getDragon());
            
            controlador.ComenzarCombate();

        } catch(HibernateException e) {
            controlador.getVista().imprimirMensage("Se ha lanzado una excepcion en Hibernate" + e.getMessage());
        }



    }
}
