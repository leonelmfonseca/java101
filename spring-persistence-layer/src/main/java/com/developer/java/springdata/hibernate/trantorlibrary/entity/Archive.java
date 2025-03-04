package com.developer.java.springdata.hibernate.trantorlibrary.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DiscriminatorValue("Archive")
public class Archive extends Resource {
    private CosmicTimeSpan timePeriodCovered;
    private Long sizeInStarbytes;
    
}
