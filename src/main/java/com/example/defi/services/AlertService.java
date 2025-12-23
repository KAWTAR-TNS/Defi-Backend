package com.example.defi.services;
import com.example.defi.entities.Alert;
import com.example.defi.repositories.AlertRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AlertService {
    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public List<Alert> findAll() {
        return alertRepository.findAll();
    }

    public Alert save(Alert alert) {
        return alertRepository.save(alert);
    }

    public Alert findById(String id) {
        return alertRepository.findById(id).orElse(null);
    }

    public void delete(String id) {
        alertRepository.deleteById(id);
    }

    public Alert toggleAlertReadStatus(String Id) {
        Alert alert = alertRepository.findById(Id).orElseThrow(() -> new NoSuchElementException("Alert not found with ID: " + Id));
  boolean newStatus = !alert.isRead();
        alert.setRead(newStatus);
return alertRepository.save(alert);
    }
}
