package com.accolite.msproject.repo;

import com.accolite.msproject.model.Institute;
import com.accolite.msproject.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

import static com.accolite.msproject.util.Queries.SKILL_LABEL;

@Repository
@Transactional
public interface SkillRepo extends JpaRepository<Skill,Integer> {
    @Query(SKILL_LABEL)
    List<String> getLabels();


}
