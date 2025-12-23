package com.example.defi.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
@Data
@Entity
public class PaymentRequest {

    @Id
    private String requestId;

    private String serviceDescription;
    private String serviceCode;
    private BigDecimal amountDue;
    private String token;

    @Enumerated(EnumType.STRING)
    private Status status;

    private ZonedDateTime createdAt;
    private ZonedDateTime paidAt;
    private String transactionHash;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
