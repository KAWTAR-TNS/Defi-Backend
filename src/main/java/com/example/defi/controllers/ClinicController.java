    package com.example.defi.controllers;

    import com.example.defi.entities.Clinic;
    import com.example.defi.services.ClinicService;
    import org.springframework.web.bind.annotation.*;
    import java.util.List;

    @RestController
    @RequestMapping("/clinics")
    public class ClinicController {

    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
    this.clinicService = clinicService;
    }

    @GetMapping("/all")
    public List<Clinic> getAllClinics() {
    return clinicService.findAll();
    }

    @PostMapping("/add")
    public Clinic addClinic(@RequestBody Clinic clinic) {
    return clinicService.save(clinic);
    }

    @GetMapping("/{id}")
    public Clinic getClinicById(@PathVariable Long id) {
    return clinicService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClinic(@PathVariable Long id) {
    clinicService.delete(id);
    }
    }
