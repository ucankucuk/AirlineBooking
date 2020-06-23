package com.ucankucuk.AirlineBooking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100)
    private String customerNameSurname;

    @Column(length = 11)
    private String customerTckn;

    @Column(length = 16)
    private String creditCardNumber;

    @JoinColumn
    @OneToOne
    private Flight flight;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date buyDate;

    @Column
    private String status;

}
