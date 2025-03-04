package com.developer.java.springdata.hibernate.trantorlibrary.entity;

import com.developer.java.springdata.hibernate.trantorlibrary.common.AccessLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patron extends User{
    private AccessLevel accessLevel;
    private String outstandingRequests;
}
