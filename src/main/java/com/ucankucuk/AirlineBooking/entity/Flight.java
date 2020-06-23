package com.ucankucuk.AirlineBooking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String flightCode;

    @Column
    private Integer quota;

    @Column
    private BigDecimal price;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date flightDate;

    @JoinColumn
    @OneToOne
    private Route route;

    @JoinColumn
    @OneToOne
    private AirlineCompany airlineCompany;

    @JoinColumn
    @OneToOne
    private Airport airport;

}
