package jpabasic.jpabasic;

import jpabasic.jpabasic.example.Player;
import jpabasic.jpabasic.example.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team teamA = new Team();
            teamA.setName("teamA");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Player player1 = new Player();
            player1.setUsername("회원1");
            player1.setAge(10);
            player1.changeTeam(teamA);
            em.persist(player1);

            Player player2 = new Player();
            player2.setUsername("회원2");
            player2.setAge(10);
            player2.changeTeam(teamA);
            em.persist(player2);

            Player player3 = new Player();
            player3.setUsername("회원3");
            player3.setAge(10);
            player3.changeTeam(teamB);
            em.persist(player3);

            em.flush();
            em.clear();

            List<Player> result = em.createNamedQuery("Player.findByUsername", Player.class)
                    .setParameter("username", "회원1")
                    .getResultList();


            for (Player player : result) {
                System.out.println("player = " + player);
            }

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
