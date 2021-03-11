package com.accolite.msproject.controllers;

import com.accolite.msproject.model.Grad;
import com.accolite.msproject.service.GradService;
import com.accolite.msproject.service.impl.GradServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("grad")
public class GradController {

    @Autowired
    private GradService gradService;

    @GetMapping("/all")
    public ResponseEntity<List<Grad>> getAllGrads(){
        List<Grad> grads=gradService.findAllGrads();

        return new ResponseEntity<>(grads, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Grad> getGradById(@PathVariable("id") Integer id){
        Grad grad=gradService.findGradById(id);
        return new ResponseEntity<>(grad, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Grad> addGrad(@RequestBody Grad grad)
    {
        Grad newGrad=gradService.addGrad(grad);
        return new ResponseEntity<>(newGrad,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Grad> updateGrad(@RequestBody Grad grad)
    {
        Grad updatedGrad=gradService.updateGrad(grad);
        return new ResponseEntity<>(updatedGrad,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGrad(@PathVariable("id") Integer id){
        gradService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
