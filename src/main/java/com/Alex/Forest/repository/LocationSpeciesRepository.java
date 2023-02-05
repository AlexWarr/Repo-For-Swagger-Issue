package com.Alex.Forest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Alex.Forest.Entity.Location_has_Plant_Species;

@Repository
public interface LocationSpeciesRepository extends JpaRepository<Location_has_Plant_Species, String> {

}
