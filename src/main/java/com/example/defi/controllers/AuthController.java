package com.example.defi.controllers;

import com.example.defi.entities.Clinic;
import com.example.defi.entities.Patient;
import com.example.defi.services.AuthService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup/clinic")
    public Clinic signupClinic(@RequestBody Map<String, Object> body)
            throws FirebaseAuthException {

        Clinic clinic = new Clinic();
        clinic.setEmail((String) body.get("email"));
        clinic.setName((String) body.get("name"));
        clinic.setAddress((String) body.get("address"));
        clinic.setLicenseNumber((String) body.get("license_number"));

        String password = (String) body.get("password");

        return authService.signupClinic(clinic, password);
    }

    @PostMapping("/signup/patient")
    public Patient signupPatient(@RequestBody Map<String, Object> body)
            throws FirebaseAuthException {

        Patient patient = new Patient();
        patient.setEmail((String) body.get("email"));
        patient.setFirstName((String) body.get("firstName"));
        patient.setLastName((String) body.get("lastName"));
        patient.setAddress((String) body.get("address"));
        patient.setCIN((String) body.get("cin"));
        patient.setWallet((String) body.get("wallet"));

        String password = (String) body.get("password");

        return authService.signupPatient(patient, password);
    }
// shoofi hadi katrejje3 lik wash l user li dar login kan clinic wlla patient okay ??
  // 7it ma3ndnash entity smitha USer ydar mnha heritae w  enu l Role
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");
        return ResponseEntity.ok(authService.login(email, password));
    }

}
