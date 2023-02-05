package com.Alex.Forest.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.relational.core.mapping.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
@Table(name="Plant")
public class Plant {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Plant_ID;
  
  @Column(value= "Body_Trunk_Stem_Description")
  private String Body_Trunk_Stem_Description;
  @Column(value= "Branch_Leaf_Pattern_Description")
  private String Branch_Leaf_Pattern_Description;
  @Column(value= "Flower_Fruit_Description")
  private String Flower_Fruit_Description;
  @Column(value= "Plant_Notes")
  private String Plant_Notes;

  //Foreign Keys
  @Column(value= "Plant_Latin_Name")
  private String Plant_Latin_Name;
  
  @Column(value= "Location_Name")
  private String Location_Name;
  
}
