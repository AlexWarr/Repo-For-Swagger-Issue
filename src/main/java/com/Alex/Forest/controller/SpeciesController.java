package com.Alex.Forest.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Alex.Forest.Entity.Plant_Species;
import com.Alex.Forest.service.SpeciesService;


@RestController
@RequestMapping("/4est/Plant_Species")
public class SpeciesController {
  
  private SpeciesService speciesService;
  
  private SpeciesController(SpeciesService speciesService) {
    super();
    this.speciesService = speciesService;
  }
  
  //create a species API
  @PostMapping()
  public ResponseEntity<Plant_Species> saveSpecies(@RequestBody Plant_Species species){
    return new ResponseEntity<Plant_Species>(speciesService.saveSpecies(species),HttpStatus.CREATED); 
  }
  
  //Read all species API
  @GetMapping
  public List<Plant_Species> getAllSpecies(){
    return speciesService.getAllSpecies();
  }
}
