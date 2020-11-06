package bstorm.akim.SpringJPA.metier.service;

import bstorm.akim.SpringJPA.exception.NoElementFoundException;
import javassist.NotFoundException;

import java.util.List;

public interface GetterService<DTO, ID> {

    DTO getOne(ID id) throws NoElementFoundException;
    List<DTO> getAll();

}
