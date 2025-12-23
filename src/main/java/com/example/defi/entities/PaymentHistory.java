package com.example.defi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPHistory;
//blockchain stuff mashi dyali
private String transactionHash;
    private String blockHash;
    private Long blockNumber;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @ManyToOne
    @JoinColumn(name = "payment_request_id")
    private PaymentRequest paymentRequest;

}
