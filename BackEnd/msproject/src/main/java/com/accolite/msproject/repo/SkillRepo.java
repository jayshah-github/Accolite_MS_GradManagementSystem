package com.accolite.msproject.repo;

import com.accolite.msproject.model.Institute;
import com.accolite.msproject.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SkillRepo extends JpaRepository<Skill,Integer> {
}
