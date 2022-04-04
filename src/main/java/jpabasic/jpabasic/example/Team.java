package jpabasic.jpabasic.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Team {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Player> players = new ArrayList<>();

//    public void addPlayer(Player player) {
//        player.setTeam(this);
//        players.add(player);
//    }

}
