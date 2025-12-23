package com.example.defi.services;
import com.example.defi.entities.Clinic;
import com.example.defi.entities.Patient;
import com.example.defi.repositories.ClinicRepository;
import com.example.defi.repositories.PatientRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private PatientRepository patientRepository;

    public Clinic signupClinic(Clinic clinic, String password) throws FirebaseAuthException {

        UserRecord user = FirebaseAuth.getInstance().createUser(
                new UserRecord.CreateRequest()
                        .setEmail(clinic.getEmail())
                        .setPassword(password)
        );

        try {return clinicRepository.save(clinic);
        } catch (Exception e) {
            FirebaseAuth.getInstance().deleteUser(user.getUid());
            throw e;
        }
    }

    public Patient signupPatient(Patient patient, String password) throws FirebaseAuthException {

        UserRecord user = FirebaseAuth.getInstance().createUser(
                new UserRecord.CreateRequest()
                        .setEmail(patient.getEmail())
                        .setPassword(password)
        );

        try {
            return patientRepository.save(patient);
        } catch (Exception e) {
            FirebaseAuth.getInstance().deleteUser(user.getUid());
            throw e;
        }
    }
    // shoofi hadi katrejje3 lik wash l user li dar login kan clinic wlla patient okay ??
    @Value("${firebase.api.key}")
    private String firebaseApiKey;
    private final RestTemplate restTemplate = new RestTemplate();
    public Map<String, Object> login(String email, String password) {
        String url = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + firebaseApiKey;
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("email", email);
        requestBody.put("password", password);
        requestBody.put("returnSecureToken", true);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> firebaseResponse =
                restTemplate.postForEntity(url, request, Map.class);

        Map<String, Object> firebaseBody = firebaseResponse.getBody();
        String idToken = (String) firebaseBody.get("idToken");

        Map<String, Object> response = new HashMap<>();
        response.put("idToken", idToken);
        response.put("expiresIn", firebaseBody.get("expiresIn"));
        response.put("refreshToken", firebaseBody.get("refreshToken"));

        clinicRepository.findByEmail(email).ifPresent(clinic -> {
            response.put("type", "CLINIC");
            response.put("userId", clinic.getId());
        });

        patientRepository.findByEmail(email).ifPresent(patient -> {
            response.put("type", "PATIENT");
            response.put("userId", patient.getId());
        });  if (!response.containsKey("type")) {
            throw new RuntimeException("User authenticated but not found in database");
        }
        return response; }
//hadi khdmi biha b lkhef bash ila kan l'email deja kayn ytle3 error qbl may3mro les champs lakhrin flutter fih had lblan
    public boolean emailExists(String email) {
        try { FirebaseAuth.getInstance().getUserByEmail(email);
            return true;
        } catch (FirebaseAuthException e) { return false;
        }
}}
