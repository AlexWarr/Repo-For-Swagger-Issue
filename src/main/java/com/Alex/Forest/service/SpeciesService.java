package com.Alex.Forest.service;

import java.util.List;
import com.Alex.Forest.Entity.Plant_Species;

public interface SpeciesService {

  //post a species
  public Plant_Species saveSpecies(Plant_Species species);
  
  //get a species
  public List<Plant_Species> getAllSpecies();
}
