package bstorm.akim.SpringJPA.metier.service;

import java.util.List;

public interface GetterService<DTO, ID> {

    DTO getOne(ID id);
    List<DTO> getAll();

}
