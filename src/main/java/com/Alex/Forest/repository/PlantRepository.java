package com.Alex.Forest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Alex.Forest.Entity.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {

}
