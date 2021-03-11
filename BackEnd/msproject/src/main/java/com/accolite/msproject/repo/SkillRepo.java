package com.accolite.msproject.repo;

import com.accolite.msproject.model.Institute;
import com.accolite.msproject.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SkillRepo extends JpaRepository<Skill,Integer> {
    @Query("select s.name from Skill s")
    List<String> getLabels();

//    @Query("select count(*) from grad_skills group by skills_id")
//    Integer[] getSkillData();

}
