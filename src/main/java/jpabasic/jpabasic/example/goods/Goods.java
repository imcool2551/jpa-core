package jpabasic.jpabasic.example.goods;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn
public abstract class Goods {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int price;
}
