package com.accolite.msproject.repo;

import com.accolite.msproject.model.Grad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GradRepo extends JpaRepository<Grad,Long> {
    Optional<Grad> findGradById(Long id);
}
