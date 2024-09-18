package Crud;

import org.example.Direccion;
import org.example.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

public class Insert {
    public static void main(String[] args) {
        EntityManager em = null;
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("Persistencia-jpa");
            em = emf.createEntityManager();

            em.getTransaction().begin();

            // Crear las entidades
            //Direccion direccion1 = new Direccion("9 de julio", "Tandil");
           /// Direccion direccion2 = new Direccion("Alberdi", "Tandil");
            //Direccion direccion3 = new Direccion("Alberdi", "Tandil");
            //Persona persona3 = new Persona(5, "Agustina la cucu", 21, direccion3);


            // Persistir las entidades
            //em.persist(direccion3);
            //em.persist(direccion2);
           // em.persist(persona3);
            //em.persist(persona2);

            //Entidad a la que hago referencia y su id
            //Persona p = em.find(Persona.class, 1);
            //System.out.println(p);


            List<Persona> personas = em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
            //personas.forEach(i -> System.out.println(i));
            personas.forEach(System.out::println);

            // Confirmar la transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ocurrió un error al realizar la operación: " + e.getMessage());
            e.printStackTrace();
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Rollback en caso de error
            }
            throw new RuntimeException(e);
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }

        }
    }
}
