package jpabasic.jpabasic;

import jpabasic.jpabasic.example.Address;
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
            Address address = new Address("city", "street", "zipcode");

            Player player1 = new Player();
            player1.setUsername("hello");
            player1.setHomeAddress(address);
            em.persist(player1);

            Address address2 = new Address("new city", address.getStreet(), address.getZipcode());
            player1.setHomeAddress(address2);

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
