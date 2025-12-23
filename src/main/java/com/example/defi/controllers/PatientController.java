package com.example.defi.controllers;
import com.example.defi.entities.Patient;
import com.example.defi.services.PatientService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }

    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.delete(id);
    }
}
