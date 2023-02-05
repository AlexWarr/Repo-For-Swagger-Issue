package com.Alex.Forest.service;

import java.util.List;
import com.Alex.Forest.Entity.Plant;

public interface PlantService {

  //post a species
  public Plant savePlant(Plant plant);
  
  //get all species
  public List<Plant> getAllPlants();
  
  //get species by Latin Name
  public Plant getPlantById(int id);
  
  //update
  public Plant UpdatePlant(Plant plant, int id);
  
  //Delete (Just here for troubleshooting, species will not have a delete option readily available to user. They can delete only entries and plant instances
  public void deletePlant(int id);
  
}
