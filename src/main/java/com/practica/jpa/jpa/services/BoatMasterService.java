package com.practica.jpa.jpa.services;

import com.practica.jpa.jpa.models.BoatMaster;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BoatMasterService {
    ResponseEntity<?> findAll();
    ResponseEntity<?> findById(Long id);
    void save(BoatMaster boatMaster);
    ResponseEntity<String> deleteById(Long id);
}
