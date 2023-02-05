package com.Alex.Forest.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Alex.Forest.Entity.Plant;
import com.Alex.Forest.service.PlantService;


@RestController
@RequestMapping("/4est/Plant")
public class PlantController {
  
  private PlantService plantService;
  
  private PlantController(PlantService plantService) {
    super();
    this.plantService = plantService;
  }
  
  //create a plant instance API
  @PostMapping()
  public ResponseEntity<Plant> savePlant(@RequestBody Plant plant){
    return new ResponseEntity<Plant>(plantService.savePlant(plant),HttpStatus.CREATED); 
  }
  
  //Read all plant instances API
  @GetMapping
  public List<Plant> getAllPlantss(){
    return plantService.getAllPlants();
  }
  
  //Get plant instance by Id
  @GetMapping("{Plant_ID}")
  public ResponseEntity<Plant> getPlantById(@PathVariable("Plant_ID") int id){
    return new ResponseEntity<Plant>(plantService.getPlantById(id), HttpStatus.OK);
  }
  
  //updating or putting plant instance by id
  @PutMapping("{Plant_ID}")
  public ResponseEntity<Plant> updatePlant(@PathVariable("Plant_ID") int id, @RequestBody Plant plant){
    return new ResponseEntity<Plant>(plantService.UpdatePlant(plant, id), HttpStatus.OK);
  }
  
  //Deleting plant instance by id
  @DeleteMapping("{Plant_ID}")
  public ResponseEntity<String> deletePlant(@PathVariable("Plant_ID") int id){
    plantService.deletePlant(id);
    return new ResponseEntity<String>("Plant Instance Deleted", HttpStatus.OK);
  }
}
