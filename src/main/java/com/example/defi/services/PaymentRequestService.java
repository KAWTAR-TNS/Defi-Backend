package com.example.defi.services;
import com.example.defi.entities.PaymentRequest;
import com.example.defi.repositories.PaymentRequestRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentRequestService {
private final PaymentRequestRepository paymentRequestRepository;

public PaymentRequestService(PaymentRequestRepository paymentRequestRepository) {
this.paymentRequestRepository = paymentRequestRepository;
}

public List<PaymentRequest> findAll() {
return paymentRequestRepository.findAll();
}

public PaymentRequest save(PaymentRequest request) {
return paymentRequestRepository.save(request);
}

public PaymentRequest findById(String id) {
return paymentRequestRepository.findById(id).orElse(null);
}

public void delete(String id) {
paymentRequestRepository.deleteById(id);
}
}
