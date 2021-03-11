package com.accolite.msproject.repo;

import com.accolite.msproject.model.Grad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
@Repository
@Transactional
public interface GradRepo extends JpaRepository<Grad,Integer> {
    Optional<Grad> findGradById(Integer id);
}
