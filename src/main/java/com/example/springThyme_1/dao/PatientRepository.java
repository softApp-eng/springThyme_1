package com.example.springThyme_1.dao;

import com.example.springThyme_1.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    public Page<Patient> findByNameContains(String mc, Pageable pageable);
}
