package com.Alex.Forest.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
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
  @Autowired
  private LocationSpeciesRepository locationSpeciesRepository;

  public LocationSpeciesServiceImp(LocationSpeciesRepository locationSpeciesRepository) {
    super();
    this.locationSpeciesRepository = locationSpeciesRepository;
  }
  @Autowired
  private SpeciesRepository speciesRepository;
  
  public void SpeciesServiceImp(SpeciesRepository speciesRepository) {
    this.speciesRepository = speciesRepository;
  }
  
  @Override
  public Location_has_Plant_Species saveLocationSpecies(Location_has_Plant_Species locationSpecies) {
    return locationSpeciesRepository.save(locationSpecies);
  }
  
  @Override
  public List<Location_has_Plant_Species> getAllLocationSpecies() {
    return locationSpeciesRepository.findAll();
  }
  
  
  //get species by location
  @Override
  public List<Location_has_Plant_Species> getLocationSpeciesByLocation(String location){
    List<Location_has_Plant_Species> workingList = locationSpeciesRepository.findAll();
    for(Location_has_Plant_Species pair : workingList) {
      if (!pair.getLocation_Name().equals(location)) {
        workingList.remove(pair);
      }
    }
    return workingList;
  }

  //get location species pair
  @SuppressWarnings("unlikely-arg-type")
  @Override
  public Location_has_Plant_Species getLocationSpeciesByKey(String location, String species) {
    List<Location_has_Plant_Species> workingList = locationSpeciesRepository.findAll();
    Location_has_Plant_Species rtrn = null;
    for(Location_has_Plant_Species pair : workingList) {
      if (pair.getLocation_Name().equals(location)) {
        if (pair.getLocation_Name().equals(species)) {
          rtrn = pair;
        }
        else {
          throw new ResourceNotFoundException("Location", "Species", species);
        }
      }
      else {
        throw new ResourceNotFoundException("Species", "Location", location);  
      }
    }
    return rtrn;
  }

  @Override
  public void deleteLocationSpecies(String location, String species) {
    Location_has_Plant_Species toDelete = getLocationSpeciesByKey(location, species);
    locationSpeciesRepository.delete(toDelete);
  }

}
