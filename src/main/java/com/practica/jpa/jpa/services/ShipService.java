package com.practica.jpa.jpa.services;

import com.practica.jpa.jpa.models.Ship;
import com.practica.jpa.jpa.models.dto.ShipDTO;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ShipService {
    ResponseEntity<?> findAll();
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?> findByTieNum(Integer tieNum);
    ResponseEntity<?> filterByFeedPrice(BigDecimal lower, BigDecimal higher);
    ResponseEntity<?> findByTrip(Long idTrip);
    ResponseEntity<?> findByOwner(Long idOwner);
    ResponseEntity<String> update(Long id, ShipDTO ship);
    void save(Ship ship);
    ResponseEntity<String> deleteById(Long id);
}
