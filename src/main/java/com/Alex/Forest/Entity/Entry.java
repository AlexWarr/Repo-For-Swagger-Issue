package com.Alex.Forest.Entity;

import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.relational.core.mapping.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
@Table(name="Entry")
public class Entry {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int Entry_ID;
  
  @Column(value= "Notes")
  private String Notes;

  //Foreign Keys
  @Column(value= "Location_Location_Name")
  private String Location;
  @Column(value= "Plant_Plant_ID")
  private int Plant;
  @Column(value= "Plant_Plant_Species_Plant_Latin_Name")
  private String Latin_Name;
  @Column(value= "Moment_Date")
  private LocalDateTime Date;
}