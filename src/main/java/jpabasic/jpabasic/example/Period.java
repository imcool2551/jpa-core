package jpabasic.jpabasic.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Getter
@EqualsAndHashCode
public class Period {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
