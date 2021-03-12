package com.accolite.msproject.repo;

import com.accolite.msproject.model.Grad;
import com.accolite.msproject.model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

import static com.accolite.msproject.util.Queries.INSTI_LABEL;

@Repository
@Transactional
public interface InstituteRepo extends JpaRepository<Institute,Integer> {
    @Query(INSTI_LABEL)
    List<String> getLabels();
}
