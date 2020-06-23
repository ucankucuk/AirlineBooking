package com.ucankucuk.AirlineBooking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 10)
    private String routeCode;

    @Column(length = 100)
    private String departure;

    @Column(length = 100)
    private String landing;
}
