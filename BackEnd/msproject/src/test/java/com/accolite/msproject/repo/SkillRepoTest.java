package com.accolite.msproject.repo;

import com.accolite.msproject.EntityData;
import com.accolite.msproject.model.Institute;
import com.accolite.msproject.model.Location;
import com.accolite.msproject.model.Skill;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
class SkillRepoTest {
    @Autowired
    SkillRepo skillRepo;

    @Test
    void existsById() {
        boolean exists = skillRepo.existsById(1);
        assertThat(exists).isTrue();
    }
    @Test
    void save() {
        Skill skill = new Skill();
        skill.setName("new skill");

        Skill skill1 = skillRepo.save(skill);

        Optional<Skill> getSkill = skillRepo.findById(skill1.getId());
        assertThat(skill1).isEqualTo(getSkill.get());

    }
    @Test
    void findAll() {


        List<Skill> skills= (List<Skill>) skillRepo.findAll();
        assertThat(skills).isNotNull();



    }
    @Test
    void getLabels() {

    List<String> skillLabel=skillRepo.getLabels();
        assertThat(skillLabel).containsExactlyInAnyOrder(EntityData.getSkillsData());

    }
}