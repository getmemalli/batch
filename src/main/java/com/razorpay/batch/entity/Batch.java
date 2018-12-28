package com.razorpay.batch.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Batch {
    @Id
    @GeneratedValue
    public long id;

    private String lastName;

    private String firstName;
}
