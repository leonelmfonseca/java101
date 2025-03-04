package com.developer.java.springdata.hibernate.trantorlibrary.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curator extends User{
    private String specialization;
    private String assignedSections;
}
