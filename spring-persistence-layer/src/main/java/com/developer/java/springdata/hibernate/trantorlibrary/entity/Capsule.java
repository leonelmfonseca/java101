package com.developer.java.springdata.hibernate.trantorlibrary.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@DiscriminatorValue("Capsule")
public class Capsule extends Resource {
    private String fieldsCovered;
    private String holographicRepresentation;
}
