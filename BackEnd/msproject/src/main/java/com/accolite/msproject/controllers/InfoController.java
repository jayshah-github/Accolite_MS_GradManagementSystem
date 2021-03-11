package com.accolite.msproject.controllers;


import com.accolite.msproject.model.Grad;
import com.accolite.msproject.model.Institute;
import com.accolite.msproject.model.Location;
import com.accolite.msproject.model.Skill;
import com.accolite.msproject.repo.InstituteRepo;
import com.accolite.msproject.repo.LocationRepo;
import com.accolite.msproject.repo.SkillRepo;
import com.accolite.msproject.service.GradService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("list")
public class InstiController {

    @Autowired
    InstituteRepo instituteRepo;

    @Autowired
    LocationRepo locationRepo;

    @Autowired
    SkillRepo skillRepo;


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


}
