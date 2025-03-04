package com.developer.java.springdata.hibernate.trantorlibrary.entity;

import com.developer.java.springdata.hibernate.trantorlibrary.common.Status;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@DiscriminatorColumn(name = "resource_type", discriminatorType = DiscriminatorType.STRING)
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long resourceId;
    private Status status;
    private LocalDate requestedDate;
    private LocalDate fulfillmentDate;
}
