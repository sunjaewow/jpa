package com.example.springdatajpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;

    @OneToOne(mappedBy = "delivery")
    private OrderT orderT;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliverySatus status;
}
