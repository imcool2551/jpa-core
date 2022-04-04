package jpabasic.jpabasic.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Player {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    //==연관 관계 편의 메서드==//
    public void changeTeam(Team team) {
        this.team = team;
        team.getPlayers().add(this);
    }

}

