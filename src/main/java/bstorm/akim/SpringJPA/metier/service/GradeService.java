package bstorm.akim.SpringJPA.metier.service;

import bstorm.akim.SpringJPA.data_access.entity.Grade;
import bstorm.akim.SpringJPA.data_access.repository.GradeRepository;
import bstorm.akim.SpringJPA.metier.dto.GradeDTO;
import bstorm.akim.SpringJPA.metier.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradeService {

//    @Autowired
    private GradeRepository repository;
//    @Autowired
    private GradeMapper mapper;

    public GradeService(GradeRepository repository, GradeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public GradeDTO getOne(String id){
        return mapper.toDTO( repository.getOne(id) );
    }

    public List<GradeDTO> getAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

}