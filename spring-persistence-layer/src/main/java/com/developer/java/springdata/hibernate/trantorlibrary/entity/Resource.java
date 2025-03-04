package com.developer.java.springdata.hibernate.trantorlibrary.entity;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
// QUESTION: prevent inserting just "Resource" solo?
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "resource_type", discriminatorType = DiscriminatorType.STRING)
public class Resource {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String title;
    private String availability;
    
    @CreatedDate
    private LocalDateTime uploadDate;
    
    private LocalDateTime lastAccessedDate;
}
