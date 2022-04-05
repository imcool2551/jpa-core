package jpabasic.jpabasic.example.goods;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class Book extends Goods {

    private String author;
    private String isbn;
}
