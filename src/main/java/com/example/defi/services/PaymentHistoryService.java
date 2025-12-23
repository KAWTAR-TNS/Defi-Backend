package com.example.defi.services;

import com.example.defi.entities.Clinic;
import com.example.defi.entities.Patient;
import com.example.defi.entities.PaymentHistory;
import com.example.defi.entities.PaymentRequest;
import com.example.defi.repositories.PaymentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class PaymentHistoryService {

    @Autowired
    private PaymentHistoryRepository repository;

    public PaymentHistory logPayment(PaymentRequest request, Clinic clinic, Patient patient) {
        PaymentHistory history = new PaymentHistory();
        history.setPaymentRequest(request);
        history.setClinic(clinic);
        history.setPatient(patient);

        // Record transaction on blockchain

        return repository.save(history);
    }
}
