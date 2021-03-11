package com.accolite.msproject.repo;

import com.accolite.msproject.model.Grad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public interface GradRepo extends JpaRepository<Grad,Integer> {
    Optional<Grad> findGradById(Integer id);
    @Query("select year(ten_join_date) as year from Grad group by year")
    List<String> getYearLabels();
}
