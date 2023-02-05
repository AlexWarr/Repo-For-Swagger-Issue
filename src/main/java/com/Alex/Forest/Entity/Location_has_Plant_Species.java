package com.Alex.Forest.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.Data;

//This Entity is meant to Display the Many To Many Relationship between location and Species as set by the Entry
@Data
@Entity
@Table(name="Location_has_Plant_Species")
public class Location_has_Plant_Species implements Serializable {
  
  @EmbeddedId
  Location_has_Plant_Species_Key id;
  
  @ManyToOne
  @MapsId("Location_Name")
  @JoinColumn(name = "Location_Name")
  private Location location;
  
  @ManyToOne
  @MapsId("Plant_Latin_Name")
  @JoinColumn(name = "Plant_Latin_Name")
  private Plant_Species species;  
}
