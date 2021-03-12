package com.accolite.msproject.repo;

import com.accolite.msproject.model.Grad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.accolite.msproject.util.Queries.YEAR_LABEL;

@Repository
@Transactional
public interface GradRepo extends JpaRepository<Grad,Integer> {
    Optional<Grad> findGradById(Integer id);

    @Query(YEAR_LABEL)
    List<String> getYearLabels();
}
