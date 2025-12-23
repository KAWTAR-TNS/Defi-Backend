package com.example.defi.controllers;
import com.example.defi.entities.PaymentRequest;
import com.example.defi.services.PaymentRequestService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentRequestController {

private final PaymentRequestService paymentRequestService;

public PaymentRequestController(PaymentRequestService paymentRequestService) {
this.paymentRequestService = paymentRequestService;
}

@GetMapping("/all")
public List<PaymentRequest> getAllRequests() {
return paymentRequestService.findAll();
}

@PostMapping("/add")
public PaymentRequest addRequest(@RequestBody PaymentRequest request) {
return paymentRequestService.save(request);
}

@GetMapping("/{id}")
public PaymentRequest getRequest(@PathVariable String id) {
return paymentRequestService.findById(id);
}

@DeleteMapping("/{id}")
public void deleteRequest(@PathVariable String id) {
paymentRequestService.delete(id);
}
// makynch lach yddaro controllers wlla services l hid=story classes bjooj

}
