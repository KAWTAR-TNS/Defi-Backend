package com.example.defi.services;

import com.example.defi.entities.Alert;
import com.example.defi.entities.AlertHistory;
import com.example.defi.repositories.AlertHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // <-- 1. Import needed

import java.time.ZonedDateTime;

@Service
public class AlertHistoryService {

    @Autowired
    private AlertHistoryRepository repository;


    // 2. Annotation placed here
    @Transactional
    public AlertHistory logAlert(Alert alert, String action) {
        AlertHistory history = new AlertHistory();
        history.setAction(action);
        history.setCreatedat(ZonedDateTime.now());
        history.setAlert(alert);

        // Database write operation
        return repository.save(history);
    }
}