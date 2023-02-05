package com.Alex.Forest.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.data.relational.core.mapping.Column;
import javax.persistence.Table;
import java.util.Set;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
@Table(name="Location")
public class Location {
  
  @Id
  private String Location_Name;
  
  @Column(value = "Geography")
  private String Geography;
  
  @Column(value = "Vegetative_Zone")
  private String Vegetative_Zone;
  
  @Column(value = "Growing_Zone")
  private String Growing_Zone;
  
  @Column(value = "Elevation")
  private int Elevation;
  
  @Column(value = "Location_Notes")
  private String Location_Notes;
  
  @OneToMany(mappedBy = "Location")
  private Set<Location_has_Plant_Species> Plant_Latin_Name;
  


  

}
