package com.example.defi.services;

import com.example.defi.entities.Clinic;
import com.example.defi.repositories.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClinicService {
    @Autowired
private final ClinicRepository clinicRepository;

public ClinicService(ClinicRepository clinicRepository) {
this.clinicRepository = clinicRepository;
}

public List<Clinic> findAll() {
return clinicRepository.findAll();
}

public Clinic save(Clinic clinic) {
return clinicRepository.save(clinic);
}

public Clinic findById(Long id) {
return clinicRepository.findById(id).orElse(null);}

public void delete(Long id) {
clinicRepository.deleteById(id);
}
}
