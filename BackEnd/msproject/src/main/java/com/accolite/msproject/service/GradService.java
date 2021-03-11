package com.accolite.msproject.service;

import com.accolite.msproject.model.Grad;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface GradService {

 Grad addGrad(Grad grad);
 List<Grad> findAllGrads();
 Grad updateGrad(Grad grad);
 void deleteById(Integer id);
 Grad findGradById(Integer id);
}
