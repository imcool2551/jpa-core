package jpabasic.jpabasic.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // 양방향 관계는 주의하자. 멤버가 주문들을 가지는 것은 좋은 설계가 아니다.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
