package com.Alex.Forest.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import com.Alex.Forest.Entity.Location_has_Plant_Species;
import com.Alex.Forest.Entity.Plant_Species;
import com.Alex.Forest.exception.ResourceNotFoundException;
import com.Alex.Forest.repository.LocationSpeciesRepository;
import com.Alex.Forest.repository.SpeciesRepository;

@Service
public class LocationSpeciesServiceImp implements LocationSpeciesService {

  private LocationSpeciesRepository locationSpeciesRepository;
  @Autowired
  public LocationSpeciesServiceImp(LocationSpeciesRepository locationSpeciesRepository) {
    super();
    this.locationSpeciesRepository = locationSpeciesRepository;
  }
  
  @Override
  public Location_has_Plant_Species saveLocationSpecies(Location_has_Plant_Species locationSpecies) {
    return locationSpeciesRepository.save(locationSpecies);
  }

  @Override
  public List<Location_has_Plant_Species> getAllLocationSpecies() {
    return locationSpeciesRepository.findAll();
  }

  @Override
  public Location_has_Plant_Species getLocationSpeciesByKey(String key) {
    return locationSpeciesRepository.findById(key).orElseThrow(() -> 
    new ResourceNotFoundException("Location", "Species", key));
  }

  @Override
  public void deleteLocationSpecies(String key) {
    Location_has_Plant_Species toDelete = locationSpeciesRepository.findById(key).orElseThrow(() -> 
    new ResourceNotFoundException("Location", "Species", key));
    locationSpeciesRepository.deleteById(key);
  }

}
