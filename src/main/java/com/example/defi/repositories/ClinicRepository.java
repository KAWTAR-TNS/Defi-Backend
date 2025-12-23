package com.example.defi.repositories;

import com.example.defi.entities.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
    Optional<Clinic> findByEmail(String email);
}
