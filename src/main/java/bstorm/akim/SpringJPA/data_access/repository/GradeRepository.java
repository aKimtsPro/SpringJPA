package bstorm.akim.SpringJPA.data_access.repository;

import bstorm.akim.SpringJPA.data_access.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, String> {

    // ... WHERE lower_bound >= value
    List<Grade> findByLowerBoundGreaterThanEqual(int value);

    // ... WHERE lower_bound >= greater AND upper_bound <= lesser
    List<Grade> findByLowerBoundGreaterThanEqualAndUpperBoundLessThanEqual(int greater, int lesser);

    @Query("SELECT g FROM Grade g WHERE (upper_bound+lower_bound) >= ?1")
    List<Grade> custom(double value);

    @Transactional
    @Modifying
    @Query("DELETE from Grade g WHERE (g.upperBound+g.lowerBound) >= :addition AND g.upperBound <= :lesser")
    void deleteByAddition(
            @Param("addition") int value,
            @Param("lesser") int deuxieme
    );

}
