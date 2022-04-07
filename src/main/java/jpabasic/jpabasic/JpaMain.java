package jpabasic.jpabasic;

import jpabasic.jpabasic.example.Address;
import jpabasic.jpabasic.example.Period;
import jpabasic.jpabasic.example.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Player player = new Player();
            player.setUsername("hello");
            player.setHomeAddress(new Address("city", "street", "zipcode"));
            player.setWorkPeriod(new Period());

            em.persist(player);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

}
