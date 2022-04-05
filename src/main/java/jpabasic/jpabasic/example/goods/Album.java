package jpabasic.jpabasic.example.goods;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album extends Goods {

    private String artist;
}
