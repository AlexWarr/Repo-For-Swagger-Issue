package com.Alex.Forest.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Alex.Forest.Entity.Location_has_Plant_Species;
import com.Alex.Forest.service.LocationSpeciesService;


@RestController
@RequestMapping("/4est/Location_has_Plant_Species")
public class LocationSpeciesController {
  
  @Autowired
  private LocationSpeciesService locationSpeciesService;
  
  private LocationSpeciesController(LocationSpeciesService locationSpeciesService) {
    super();
    this.locationSpeciesService = locationSpeciesService;
  }
  
  //create a species API
  @PostMapping()
  public ResponseEntity<Location_has_Plant_Species> saveLocationSpecies(@RequestBody Location_has_Plant_Species locationSpecies){
    return new ResponseEntity<Location_has_Plant_Species>(locationSpeciesService.saveLocationSpecies(locationSpecies),HttpStatus.CREATED); 
  }
  
  //Read all species API
  @GetMapping
  public List<Location_has_Plant_Species> getAllLocationSpecies(){
    return locationSpeciesService.getAllLocationSpecies();
  }
  
  //Get all species in location
  @GetMapping("{Location_has_Plant_Species}")
  public ResponseEntity<List<Location_has_Plant_Species>> getLocationSpeciesByLocation(@PathVariable("Location_has_Plant_Species") String location){
    return new ResponseEntity<List<Location_has_Plant_Species>>(locationSpeciesService.getLocationSpeciesByLocation(location), HttpStatus.OK);
  }
  
  //Get location species pair
  @GetMapping("{Location_has_Plant_Species}")
  public ResponseEntity<Location_has_Plant_Species> getLocationSpeciesByKey(@PathVariable("Location_has_Plant_Species") String location, String species){
    return new ResponseEntity<Location_has_Plant_Species>(locationSpeciesService.getLocationSpeciesByKey(location, species), HttpStatus.OK);
  }
  
  //Deleting plant instance by id
  @DeleteMapping("Location_has_Plant_Species")
  public ResponseEntity<String> deletePlant(@PathVariable("Location_has_Plant_Species") String location, String species){
    locationSpeciesService.deleteLocationSpecies(location, species);
    return new ResponseEntity<String>("Species Location Pair Deleted", HttpStatus.OK);
  }
}
