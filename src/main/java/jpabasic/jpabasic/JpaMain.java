package jpabasic.jpabasic;

import jpabasic.jpabasic.example.Address;
import jpabasic.jpabasic.example.AddressEntity;
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
            player.setUsername("member 1");
            player.setHomeAddress(new Address("homeCity", "street", "10000"));

            player.getFavoriteFoods().add("치킨");
            player.getFavoriteFoods().add("족발");
            player.getFavoriteFoods().add("피자");

            player.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
            player.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));

            em.persist(player);

            em.flush();
            em.clear();

            System.out.println("=============== START ==============");
            Player findPlayer = em.find(Player.class, player.getId());

            findPlayer.getFavoriteFoods().remove("치킨");
            findPlayer.getFavoriteFoods().add("한식");

            findPlayer.getAddressHistory().remove(new AddressEntity("old1", "street", "10000"));
            findPlayer.getAddressHistory().add(new AddressEntity("newCity1", "street", "10000"));

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
