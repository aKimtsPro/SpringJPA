package bstorm.akim.SpringJPA.data_access.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Grade {

    @Id
    @Column(columnDefinition = "char(2)")
    private String grade;

    @Column(name = "lower_bound")
    private int lowerBound;

    @Column(name = "upper_bound")
    private int upperBound;

}
