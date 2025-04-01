package com.example.springdatajpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String username;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<OrderT> orders = new ArrayList<OrderT>();
}
