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
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.accolite.msproject.util.Queries.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
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
    Query query;
    @MockBean
    EntityManagerFactory entityManagerFactory;
    @Mock
    EntityManager entityManager;


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
    void getChartPieDataSkill() throws Exception {
        List<BigDecimal> dataList=new ArrayList<>();
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        List<String> list=Arrays.asList(EntityData.getSkillsData());
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        when(skillRepo.getLabels()).thenReturn(list);
        when(entityManager.createNativeQuery(SKILL_PIE_DATA)).thenReturn(query);
        when(query.getResultList()).thenReturn(dataList);
        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/list/chart/pie/"+SKILL_L))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.chartData.label").value(GRAD_L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.labels").value(list))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void getChartPieDataLoc() throws Exception {
        List<BigDecimal> dataList=new ArrayList<>();
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        List<String> list=Arrays.asList(EntityData.getLocData());
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        when(locationRepo.getLabels()).thenReturn(list);
        when(entityManager.createNativeQuery(LOC_PIE_DATA)).thenReturn(query);
        when(query.getResultList()).thenReturn(dataList);
        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/list/chart/pie/loc"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.chartData.label").value(GRAD_L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.labels").value(list))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void getChartPieDataYear() throws Exception {
        List<BigDecimal> dataList=new ArrayList<>();
        dataList.add(BigDecimal.valueOf(100));

        List<String> list=Arrays.asList(new String[]{"2021"});
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        when(gradRepo.getYearLabels()).thenReturn(list);
        when(entityManager.createNativeQuery(YEAR_PIE_DATA)).thenReturn(query);
        when(query.getResultList()).thenReturn(dataList);
        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/list/chart/pie/"+YEAR_L))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.chartData.label").value(GRAD_L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.labels").value(list))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void getChartPieDataInsti() throws Exception {
        List<BigDecimal> dataList=new ArrayList<>();
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        List<String> list=Arrays.asList(EntityData.getSkillsData());
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        when(instituteRepo.getLabels()).thenReturn(list);
        when(entityManager.createNativeQuery(INSTI_PIE_DATA)).thenReturn(query);
        when(query.getResultList()).thenReturn(dataList);
        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/list/chart/pie/"+INSTI_L))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.chartData.label").value(GRAD_L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.labels").value(list))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    ///bar

    @Test
    void getChartBarDataSkill() throws Exception {
        List<BigDecimal> dataList=new ArrayList<>();
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        List<String> list=Arrays.asList(EntityData.getSkillsData());
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        when(skillRepo.getLabels()).thenReturn(list);
        when(entityManager.createNativeQuery(SKILL_BAR_DATA)).thenReturn(query);
        when(query.getResultList()).thenReturn(dataList);
        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/list/chart/bar/"+SKILL_L))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.chartData.label").value(GRAD_L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.labels").value(list))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void getChartBarDataLoc() throws Exception {
        List<BigDecimal> dataList=new ArrayList<>();
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        List<String> list=Arrays.asList(EntityData.getLocData());
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        when(locationRepo.getLabels()).thenReturn(list);
        when(entityManager.createNativeQuery(LOC_BAR_DATA)).thenReturn(query);
        when(query.getResultList()).thenReturn(dataList);
        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/list/chart/bar/loc"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.chartData.label").value(GRAD_L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.labels").value(list))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void getChartBarDataYear() throws Exception {
        List<BigDecimal> dataList=new ArrayList<>();
        dataList.add(BigDecimal.valueOf(100));

        List<String> list=Arrays.asList(new String[]{"2021"});
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        when(gradRepo.getYearLabels()).thenReturn(list);
        when(entityManager.createNativeQuery(YEAR_BAR_DATA)).thenReturn(query);
        when(query.getResultList()).thenReturn(dataList);
        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/list/chart/bar/"+YEAR_L))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.chartData.label").value(GRAD_L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.labels").value(list))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void getChartBarDataInsti() throws Exception {
        List<BigDecimal> dataList=new ArrayList<>();
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        dataList.add(BigDecimal.valueOf(20));
        List<String> list=Arrays.asList(EntityData.getSkillsData());
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        when(instituteRepo.getLabels()).thenReturn(list);
        when(entityManager.createNativeQuery(INSTI_BAR_DATA)).thenReturn(query);
        when(query.getResultList()).thenReturn(dataList);
        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/list/chart/bar/"+INSTI_L))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.chartData.label").value(GRAD_L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.labels").value(list))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }


}