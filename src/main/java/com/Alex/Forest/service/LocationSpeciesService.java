package com.Alex.Forest.service;

import java.util.List;
import com.Alex.Forest.Entity.Location_has_Plant_Species;

public interface LocationSpeciesService {

  //post a LocationSpecies pair
  public Location_has_Plant_Species saveLocationSpecies(Location_has_Plant_Species locationSpecies);
  
  //get all LocationSpecies pairs
  public List<Location_has_Plant_Species> getAllLocationSpecies();
  
  //get species by Latin Name
  public Location_has_Plant_Species getLocationSpeciesByKey(String key);
  
  //Delete (Just here for troubleshooting, species will not have a delete option readily available to user. They can delete only entries and plant instances
  public void deleteLocationSpecies(String key);
  
}
