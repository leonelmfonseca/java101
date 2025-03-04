package com.developer.java.springdata.hibernate.trantorlibrary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    @Column(name = "birth_planet")
    private String birthPlanet;
    
    @Column(name = "notable_works")
    private String notableWorks;
}
