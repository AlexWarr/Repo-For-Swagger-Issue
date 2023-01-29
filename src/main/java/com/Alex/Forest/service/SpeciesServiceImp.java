package com.Alex.Forest.service;

import java.util.List;
import com.Alex.Forest.Entity.Plant_Species;
import com.Alex.Forest.repository.PlantSpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeciesServiceImp implements SpeciesService{

  private PlantSpeciesRepository speciesRepository;
  
  @Autowired
  public SpeciesServiceImp(PlantSpeciesRepository speciesRepository) {
    super();
    this.speciesRepository = speciesRepository;
  }
  //This CREATES
  @Override
  public Plant_Species saveSpecies(Plant_Species species) {
    return speciesRepository.save(species);
  }
  //this READS
  @Override
  public List<Plant_Species> getAllSpecies() {
    return speciesRepository.findAll();
  }
}
