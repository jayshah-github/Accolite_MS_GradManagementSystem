package com.accolite.msproject.repo;

import com.accolite.msproject.model.Grad;
import com.accolite.msproject.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

import static com.accolite.msproject.util.Queries.LOC_LABEL;

@Repository
@Transactional
public interface LocationRepo extends JpaRepository<Location,Integer> {
    @Query(LOC_LABEL)
    List<String> getLabels();
}
