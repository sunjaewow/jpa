package com.example.springdatajpa.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item1 {
    private String director;
    private String actor;
}
