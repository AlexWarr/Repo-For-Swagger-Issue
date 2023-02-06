package com.Alex.Forest.Entity;

import org.springframework.data.relational.core.mapping.Column;
import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Location_has_Plant_Species_Key implements Serializable {
  

  @Column(value = "Location_Name")
  private String Location_Name;
  

  @Column(value = "Plant_Latin_Name")
  private String Plant_Latin_Name;  
}
