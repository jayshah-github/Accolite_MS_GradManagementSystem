package com.accolite.msproject.repo;

import com.accolite.msproject.EntityData;
import com.accolite.msproject.model.Grad;
import com.accolite.msproject.model.Institute;
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
class InstituteRepoTest {
    @Autowired
    InstituteRepo instituteRepo;

    @Test
    void existsById() {
        boolean exists = instituteRepo.existsById(1);
        assertThat(exists).isTrue();
    }
    @Test
    void findAll() {


        List<Institute> institutes= (List<Institute>) instituteRepo.findAll();
        assertThat(institutes).isNotNull();



    }
    @Test
    void save() {
        Institute institute = new Institute();
        institute.setName("new insti");

        Institute institute1 = instituteRepo.save(institute);

        Optional<Institute> getInstitue = instituteRepo.findById(institute1.getId());
        assertThat(institute1).isEqualTo(getInstitue.get());

    }
    @Test
    void getLabels() {
        List<String> instiLabels=instituteRepo.getLabels();
        assertThat(instiLabels).containsExactlyInAnyOrder(EntityData.getInstrData());

    }
}