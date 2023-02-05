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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Entry_Number;
  
  @Column(value= "Notes")
  private String Notes;

  //Foreign Keys
  @Column(value= "Location_Name")
  private String Location_Name;
  @Column(value= "Plant_ID")
  private int Plant_ID;
  @Column(value= "Plant_Latin_Name")
  private String Plant_Latin_Name;
  @Column(value= "DTG")
  private LocalDateTime DTG;
}