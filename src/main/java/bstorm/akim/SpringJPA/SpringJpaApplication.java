package bstorm.akim.SpringJPA;

import bstorm.akim.SpringJPA.data_access.entity.Grade;
import bstorm.akim.SpringJPA.data_access.repository.GradeRepository;
import bstorm.akim.SpringJPA.metier.service.GradeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringJpaApplication.class, args);

		GradeService service = ctx.getBean(GradeService.class);
		service.getAll().forEach(System.out::println);

	}

}
