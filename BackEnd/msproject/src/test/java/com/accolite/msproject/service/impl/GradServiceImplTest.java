package com.accolite.msproject.service.impl;

import com.accolite.msproject.EntityData;
import com.accolite.msproject.exception.GradNotFoundException;
import com.accolite.msproject.model.Grad;
import com.accolite.msproject.repo.GradRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = GradServiceImpl.class)
@RunWith(SpringRunner.class)
class GradServiceImplTest {
    @MockBean
    GradRepo gradRepo;

    @Autowired
    GradServiceImpl gradService;

    @Test
    void addGrad() {

        Grad grad = EntityData.getGrad();
        grad.setId(1);
        when(gradRepo.save(grad)).thenReturn(grad);

        assertThat(gradService.addGrad(grad)).isEqualTo(grad);
    }

    @Test
    void findAllGrads() {
        Grad grad = EntityData.getGrad();
        grad.setId(1);
        List<Grad> grads = new ArrayList<>();
        grads.add(grad);

        when(gradRepo.findAll()).thenReturn(grads);

        assertThat(gradService.findAllGrads()).isEqualTo(grads);
    }


    @Test
    void findGradById() {
        Grad grad = EntityData.getGrad();
        grad.setId(1);

        when(gradRepo.findGradById(grad.getId())).thenReturn(java.util.Optional.of(grad));

        assertThat(gradService.findGradById(grad.getId()).equals(grad)).isTrue();


    }
    @Test
    void findGradByIdFail() {
        Grad grad = EntityData.getGrad();
        grad.setId(1);
        int id=2;


        Throwable exception = assertThrows(GradNotFoundException.class, () -> gradService.findGradById(id));
        assertEquals("Grad by id "+id+" was not found", exception.getMessage());


    }
}