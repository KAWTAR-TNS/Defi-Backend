package com.example.defi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String licenseNumber;
    private String email;
    @OneToMany(mappedBy = "clinic")
    private List<PaymentRequest> paymentRequests;

    @OneToMany(mappedBy = "clinic")
    private List<Alert> alerts;



}
