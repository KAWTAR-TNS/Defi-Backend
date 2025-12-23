package com.example.defi.repositories;
import com.example.defi.entities.PaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRequestRepository extends JpaRepository<PaymentRequest, String> {
}
