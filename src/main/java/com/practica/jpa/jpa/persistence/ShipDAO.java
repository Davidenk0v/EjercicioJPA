package com.practica.jpa.jpa.persistence;

import com.practica.jpa.jpa.models.Ship;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ShipDAO {
    List<Ship> findAll();
    Optional<Ship> findById(Long id);
    Optional<Ship> findByTieNum(Integer tieNum);
    Set<Ship> filterByFeedPrice(BigDecimal lower, BigDecimal higher);
    Set<Ship> findByTrip(Long idTrip);
    Set<Ship> findByOwner(Long idOwner);
    void save(Ship ship);
    void deleteById(Long id);

}
