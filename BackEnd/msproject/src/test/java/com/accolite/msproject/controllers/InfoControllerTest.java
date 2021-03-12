package com.accolite.msproject.controllers;

import com.accolite.msproject.EntityData;
import com.accolite.msproject.TestConfig;
import com.accolite.msproject.model.Grad;
import com.accolite.msproject.model.Institute;
import com.accolite.msproject.model.Location;
import com.accolite.msproject.model.Skill;
import com.accolite.msproject.repo.GradRepo;
import com.accolite.msproject.repo.InstituteRepo;
import com.accolite.msproject.repo.LocationRepo;
import com.accolite.msproject.repo.SkillRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(TestConfig.class)
@WebMvcTest(InfoController.class)
class InfoControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    InstituteRepo instituteRepo;

    @MockBean
    EntityManagerFactory entityManager;
    @MockBean
    LocationRepo locationRepo;

    @MockBean
    SkillRepo skillRepo;
    @MockBean
    GradRepo gradRepo;
    @Test
    void getAllInstitute() throws Exception {
        Institute institute= new Institute(1,EntityData.getInstrData()[0]);

        List<Institute> institutes=new ArrayList<>();
        institutes.add(institute);

        when(instituteRepo.findAll()).thenReturn(institutes);

        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/list/allInsti"))
                .andExpect(status().isOk())
                .andReturn();
        assertThat(result).isNotNull();


        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    void getAllLocations() throws Exception {
        Location location= new Location(1,EntityData.getLocData()[0]);

        List<Location> locations=new ArrayList<>();
        locations.add(location);

        when(locationRepo.findAll()).thenReturn(locations);

        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/list/allLoc"))
                .andExpect(status().isOk())
                .andReturn();
        assertThat(result).isNotNull();


        System.out.println(result.getResponse().getContentAsString());
    }
    @Test
    void getAllSkills() throws Exception {
        Skill skill= new Skill(1,EntityData.getSkillsData()[0]);

        List<Skill> skills=new ArrayList<>();
        skills.add(skill);

        when(skillRepo.findAll()).thenReturn(skills);

        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/list/allSkill"))
                .andExpect(status().isOk())
                .andReturn();
        assertThat(result).isNotNull();


        System.out.println(result.getResponse().getContentAsString());
    }
    @Test
    void getChartBarData() {
    }

    @Test
    void getChartPieData() {
    }


}