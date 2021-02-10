package bstorm.akim.SpringJPA;

import bstorm.akim.SpringJPA.data_access.entity.Grade;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class TestDAO {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public void test(){
        manager.persist(new Grade());
    }

}
