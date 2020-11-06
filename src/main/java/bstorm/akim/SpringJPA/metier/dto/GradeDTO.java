package bstorm.akim.SpringJPA.metier.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class GradeDTO {

    private String note;
    private int upperBound;
    private int lowerBound;
    private int sommeDesBounds;

}
