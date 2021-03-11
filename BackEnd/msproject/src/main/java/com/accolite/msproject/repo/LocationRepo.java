package com.accolite.msproject.repo;

import com.accolite.msproject.model.Grad;
import com.accolite.msproject.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface LocationRepo extends JpaRepository<Location,Integer> {
    @Query("select s.name from Location s")
    List<String> getLabels();
}
