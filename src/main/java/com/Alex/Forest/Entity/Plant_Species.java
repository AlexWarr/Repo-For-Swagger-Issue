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
@Table(name="Plant_Species")
public class Plant_Species {
  
  @Id
  private String Plant_Latin_Name;
  
  @Column(value = "Plant_Common_Name")
  private String Plant_Common_Name;
  
  @Column(value = "Plant_Phylum")
  private String Plant_Phylum;
  
  @Column(value = "Body_Trunk_Stem_Description")
  private String Body_Trunk_Stem_Description;
  
  @Column(value = "Branch_Leaf_Pattern_Description")
  private String Branch_Leaf_Pattern_Description;
  
  @Column(value = "Flower_Fruit_Description")
  private String Flower_Fruit_Description;
  
  @Column(value = "Toxic")
  private Boolean Toxic;
  
  @Column(value = "Edible")
  private Boolean Edible;
  
  @Column(value = "Medicinal")
  private Boolean Medicinal;
  
  @Column(value = "Plant_Description")
  private String Plant_Description;
  
  @OneToMany(mappedBy = "Plant_Latin_Name")
  private Set<Location_has_Plant_Species> Location_Name;
  
}
