package com.practica.jpa.jpa.services;

import com.practica.jpa.jpa.models.Ship;
import com.practica.jpa.jpa.models.dto.ShipDTO;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ShipService {
    List<Ship> findAll();
    Optional<Ship> findById(Long id);
    Optional<Ship> findByTieNum(Integer tieNum);
    Set<Ship> filterByTiePrice(BigDecimal lower, BigDecimal higher);
    Set<Ship> findByTrip(Long idTrip);
    Set<Ship> findByOwner(Long idOwner);
    ResponseEntity<String> update(Long id, ShipDTO ship);
    void save(Ship ship);
    void deleteById(Long id);
}
