package com.accolite.msproject.controllers;


import com.accolite.msproject.model.*;
import com.accolite.msproject.repo.GradRepo;
import com.accolite.msproject.repo.InstituteRepo;
import com.accolite.msproject.repo.LocationRepo;
import com.accolite.msproject.repo.SkillRepo;
import com.accolite.msproject.service.GradService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("list")
public class InfoController {

    @Autowired
    InstituteRepo instituteRepo;

    @Autowired
    LocationRepo locationRepo;

    @Autowired
    SkillRepo skillRepo;
    @Autowired
    GradRepo gradRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/allInsti")
    public ResponseEntity<List<Institute>> getAllInstitute(){
        List<Institute> institutes=instituteRepo.findAll();
        return new ResponseEntity<>(institutes, HttpStatus.OK);
    }

    @GetMapping("/allLoc")
    public ResponseEntity<List<Location>> getAllLocations(){
        List<Location> locations=locationRepo.findAll();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/allSkill")
    public ResponseEntity<List<Skill>> getAllSkills(){
        List<Skill> skills=skillRepo.findAll();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }
    @GetMapping("/chart/bar/{label}")
    public ResponseEntity<Chart> getChartBarData(@PathVariable("label") String label){
        Chart chart=new Chart();

        List<String> labels ;
        ChartData chartData=new ChartData();
        List<BigDecimal> data ;
        Query nativeQuery ;

        if(label.equals("skill"))
        {
            labels=skillRepo.getLabels();
            nativeQuery=entityManager.createNativeQuery("select count(*) from grad_skills group by skills_id");
        }
        else if(label.equals("institute"))
        {
            labels=instituteRepo.getLabels();
            nativeQuery=entityManager.createNativeQuery("select count(*) from Grad group by institute_id");

        }  else if(label.equals("join year")){
            labels= gradRepo.getYearLabels();
            nativeQuery=entityManager.createNativeQuery("select count(*) from Grad  group by (select year(ten_join_date) as year)");

        }
        else{
            labels=locationRepo.getLabels();
            nativeQuery=entityManager.createNativeQuery("select count(*) from grad group by join_loc_id");

        }


        data= nativeQuery.getResultList();
        chartData.setLabel("Graduates");
        chartData.setData(data);

        //setting value
        chart.setLabels(labels);
        chart.setChartData(chartData);
        return new ResponseEntity<>(chart, HttpStatus.OK);

        //return new ResponseEntity<>(chart, HttpStatus.OK);
    }
    @GetMapping("/chart/pie/{label}")
    public ResponseEntity<Chart> getChartPieData(@PathVariable("label") String label){
        Chart chart=new Chart();

        List<String> labels;
        ChartData chartData=new ChartData();
        List<BigDecimal> data ;
        Query nativeQuery ;

        if(label.equals("skill"))
        {
            labels=skillRepo.getLabels();
            nativeQuery=entityManager.createNativeQuery("select (count(*)*100/(Select Count(*) From grad_skills)) from grad_skills group by skills_id;");
        }
        else if(label.equals("institute"))
        {
            labels=instituteRepo.getLabels();
            nativeQuery=entityManager.createNativeQuery("select (count(*)*100/(Select Count(*) From grad)) from grad group by institute_id");

        }
        else if(label.equals("join year")){
            labels= gradRepo.getYearLabels();
            nativeQuery=entityManager.createNativeQuery("select (count(id)*100/(Select Count(*) From grad)) from grad group by (select year(ten_join_date) as year)");

        }
        else{
            labels=locationRepo.getLabels();
            nativeQuery=entityManager.createNativeQuery("select (count(*)*100/(Select Count(*) From grad)) from grad group by join_loc_id");

        }


        data= nativeQuery.getResultList();
        chartData.setLabel("Graduates");
        chartData.setData(data);

        //setting value
        chart.setLabels(labels);
        chart.setChartData(chartData);
        return new ResponseEntity<>(chart, HttpStatus.OK);

        //return new ResponseEntity<>(chart, HttpStatus.OK);
    }

}
