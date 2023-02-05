package com.Alex.Forest.service;

//import java.time.LocalDateTime;
import java.util.List;
import com.Alex.Forest.Entity.Plant;
import com.Alex.Forest.exception.ResourceNotFoundException;
import com.Alex.Forest.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantServiceImp implements PlantService{

  private PlantRepository plantRepository;
  
  @Autowired
  public PlantServiceImp(PlantRepository plantRepository) {
    super();
    this.plantRepository = plantRepository;
  }
  //This CREATES
  @Override
  public Plant savePlant(Plant plant) {
    return plantRepository.save(plant);
  }
  //this READS All
  @Override
  public List<Plant> getAllPlants() {
    return plantRepository.findAll();
  }
  
  //this READS individually
  @Override
  public Plant getPlantById(int id) {
    return plantRepository.findById(id).orElseThrow(() -> 
    new ResourceNotFoundException("Plant", "Id:", id));
  }
  //this UPDATES
  @Override
  public Plant UpdatePlant(Plant plant, int id) {
    Plant existingPlant = plantRepository.findById(id).orElseThrow(() -> 
    new ResourceNotFoundException("Plant", "Id:", id));
    existingPlant.setPlant_Latin_Name(
        plant.getPlant_Latin_Name());
    existingPlant.setBody_Trunk_Stem_Description(
        plant.getBody_Trunk_Stem_Description());
    existingPlant.setBranch_Leaf_Pattern_Description(
        plant.getBranch_Leaf_Pattern_Description());
    existingPlant.setFlower_Fruit_Description(
        plant.getFlower_Fruit_Description());
    existingPlant.setLocation_Name(plant.getLocation_Name());
    existingPlant.setPlant_Notes(plant.getPlant_Notes());
    //The following needs a prepared statement that includes date, eventually user, and entry number
    /*
    existingPlant.setPlant_Notes( ""
        + existingPlant.getPlant_Notes() + "\n\n" 
        + LocalDateTime.now().toString() + " | "
        + plant.getPlant_Notes());
    */
    plantRepository.save(existingPlant);
    return existingPlant;
  }
  //this DELETES
  @Override
  public void deletePlant(int id) {
    Plant existingPlant = plantRepository.findById(id).orElseThrow(() -> 
    new ResourceNotFoundException("Plant", "Id:", id));
    plantRepository.deleteById(id);

  }
}
