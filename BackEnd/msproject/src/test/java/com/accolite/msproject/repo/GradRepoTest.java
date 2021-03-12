package com.accolite.msproject.repo;

import com.accolite.msproject.EntityData;
import com.accolite.msproject.model.Grad;
import com.accolite.msproject.model.Institute;
import com.accolite.msproject.model.Location;
import com.accolite.msproject.model.Skill;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class GradRepoTest {
    @Autowired
    GradRepo gradRepo;

    @Test
    void existsById() {
        boolean exists = gradRepo.existsById(1);
        assertThat(exists).isTrue();
    }
    @Test
    void save() {


        Grad grad = EntityData.getGrad();
        Grad grad1=gradRepo.save(grad);

        Optional<Grad> getGrad = gradRepo.findById(grad1.getId());
        assertThat(grad1).isEqualTo(getGrad.get());

    }
    @Test
    void findAll() {

        Grad grad = EntityData.getGrad();
        Grad grad1 = gradRepo.save(grad);

        List<Grad> grads= (List<Grad>) gradRepo.findAll();
        assertThat(grads).isNotNull();



    }
    @Test
    void findGradById() {


        Grad grad= EntityData.getGrad();
        grad.setId(1);

        Optional<Grad> grad1=gradRepo.findGradById(grad.getId());
        assertThat(grad1).isNotNull();
        assertThat(grad.getId()).isEqualTo(grad1.get().getId());
    }

    @Test
    void getYearLabels() {
        List<String> yearLabels=gradRepo.getYearLabels();
        assertThat(yearLabels).containsExactlyInAnyOrder(new String[]{"2021"});

    }
}