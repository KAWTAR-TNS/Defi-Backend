package com.example.defi.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Data
@Entity
public class Alert {

    @Id
    private Long Id;
    private String message;
    private boolean isRead;
    private ZonedDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
