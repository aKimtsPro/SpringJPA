package bstorm.akim.SpringJPA;


import bstorm.akim.SpringJPA.data_access.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@SpringBootApplication
public class TestEntityManager {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringJpaApplication.class, args);
        TestDAO dao = ctx.getBean(TestDAO.class);
        dao.test();
    }
}
