package bstorm.akim.SpringJPA.metier.service;

import bstorm.akim.SpringJPA.data_access.entity.Grade;
import bstorm.akim.SpringJPA.data_access.repository.GradeRepository;
import bstorm.akim.SpringJPA.exception.NoElementFoundException;
import bstorm.akim.SpringJPA.metier.dto.GradeDTO;
import bstorm.akim.SpringJPA.metier.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class GradeService implements GetterService<GradeDTO, String> {

//    @Autowired
    private GradeRepository repository;
//    @Autowired
    private GradeMapper mapper;

    public GradeService(GradeRepository repository, GradeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public GradeDTO getOne(String id) throws NoElementFoundException {
        // findById fourni un optional pouvant être vide(pas d'enregistrement associé à l'id en DB)
        // si l'optional est vide, l'utilisation du get produit une NoSuchElementException de type unchecked
        // Je choisi ici de laisser l'exception se propager jusqu'à la couche de présentation où je la gèrer.


        // return mapper.toDTO( repository.findById(id).get() );


        // Une autre option serait de renvoyer une exception de type checked dans ce cas ce figure
        // afin de s'assurer que l'exception sera bien gérée par la couche de présentation

        try{
            return mapper.toDTO( repository.findById(id).get() );
        }
        catch (NoSuchElementException e){
            throw new NoElementFoundException();
        }

        // version courte

        // return mapper.toDTO( repository.findById(id).orElseThrow( NoElementFoundException::new ) );

    }
    public List<GradeDTO> getAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

}