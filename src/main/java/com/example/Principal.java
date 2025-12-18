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

            //AVISOS 
            controlador.getVista().imprimirMensage("Se ha insertado correctamente: ");
            System.out.println(controlador.getModelo().getBosque());
            System.out.println(controlador.getModelo().getMago());
            System.out.println(controlador.getModelo().getBosque().getMonstruoJefe());
            System.out.println(controlador.getModelo().getDragon());

            //Agregar nuevos
            Mago mago2 = new Mago("Harry Potter", 200,50);
            session.merge(mago2);

            Dragon dragon2 = new Dragon(20, "Xebec", 30);
            session.merge(dragon2);

            Monstruo monstruo1 = new Monstruo("Espectro sombrío", 200, "espectro", 60);
            session.merge(monstruo1);

            Bosque bosque2 = new Bosque( "El bosque de la penumbra", 2, monstruo1, dragon2);
            session.merge(bosque2);

            tx.commit();

            //Modificar algún objeto de la tabla

            //Eliminar un objeto de la tabla

        } catch(HibernateException e) {
            controlador.getVista().imprimirMensage("Se ha lanzado una excepcion en Hibernate" + e.getMessage());
        }

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {

            Session session = factory.getCurrentSession();
            
            Transaction tx = session.beginTransaction();

            //Agregar nuevos
            Mago mago2 = new Mago("Harry Potter", 200,50);
            session.merge(mago2);

            Dragon dragon2 = new Dragon(20, "Xebec", 30);
            session.merge(dragon2);

            Monstruo monstruo1 = new Monstruo("Espectro sombrío", 200, "espectro", 60);
            session.merge(monstruo1);

            Bosque bosque2 = new Bosque( "El bosque de la penumbra", 2, monstruo1, dragon2);
            session.merge(bosque2);

            //AVISOS 
            controlador.getVista().imprimirMensage("Se ha insertado correctamente: ");
            controlador.getVista().imprimirMensage(bosque2.toString());
            controlador.getVista().imprimirMensage(mago2.toString());
            controlador.getVista().imprimirMensage(dragon2.toString());
            controlador.getVista().imprimirMensage(monstruo1.toString());

            tx.commit();

        
        } catch(HibernateException e) {
            controlador.getVista().imprimirMensage("Se ha lanzado una excepcion en Hibernate" + e.getMessage());
        }

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {

            Session session = factory.getCurrentSession();
            
            Transaction tx = session.beginTransaction();

            //Modificar algún objeto de la tabla
            Mago m = session.find(Mago.class, 2L);
            m.setNombre("Jose el mago");

            //AVISOS 
            controlador.getVista().imprimirMensage("Se ha modificado el mago ");
            
            tx.commit();

        } catch(HibernateException e) {
            controlador.getVista().imprimirMensage("Se ha lanzado una excepcion en Hibernate" + e.getMessage());
        }

        //Eliminar un objeto de la tabla

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();) {

            Session session = factory.getCurrentSession();
            
            Transaction tx = session.beginTransaction();

            //Modificar algún objeto de la tabla
            Mago m = session.find(Mago.class, 2L);
            session.remove(m);

            //AVISOS 
            controlador.getVista().imprimirMensage("Se ha modificado el mago ");
            
            tx.commit();

        } catch(HibernateException e) {
            controlador.getVista().imprimirMensage("Se ha lanzado una excepcion en Hibernate" + e.getMessage());
        }

        //ACTIVAR EL COMBATE
        controlador.ComenzarCombate();

    }
}
