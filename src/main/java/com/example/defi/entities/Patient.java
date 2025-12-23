package com.example.defi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String CIN;
    private String address;
    private String wallet;
    private String email;
    @OneToMany(mappedBy = "patient")
    private List<PaymentRequest> paymentRequests;

    @OneToMany(mappedBy = "patient")
    private List<Alert> alerts;



}
