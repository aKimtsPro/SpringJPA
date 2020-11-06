package bstorm.akim.SpringJPA.metier.mapper;

import bstorm.akim.SpringJPA.data_access.entity.Grade;
import bstorm.akim.SpringJPA.metier.dto.GradeDTO;
import org.springframework.stereotype.Component;

@Component
public class GradeMapper {

    public GradeDTO toDTO(Grade entity){

        return new GradeDTO(
                entity.getGrade(),
                entity.getUpperBound(),
                entity.getLowerBound(),
                entity.getLowerBound()+entity.getUpperBound()
        );
    }

    public Grade toEntity(GradeDTO dto){

        return new Grade(
                dto.getNote(),
                dto.getLowerBound(),
                dto.getUpperBound()
        );

    }

}
