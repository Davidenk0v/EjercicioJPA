package com.practica.jpa.jpa.persistence.impl;

import com.practica.jpa.jpa.models.Ship;
import com.practica.jpa.jpa.persistence.ShipDAO;
import com.practica.jpa.jpa.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class ShipDAOImpl implements ShipDAO {

    @Autowired
    private ShipRepository shipRepository;
    @Override
    public List<Ship> findAll() {
        return shipRepository.findAll();
    }

    @Override
    public Optional<Ship> findById(Long id) {
        return shipRepository.findById(id);
    }

    @Override
    public Optional<Ship> findByTieNum(Long tieNum) {
        return shipRepository.findByTiemNum(tieNum);
    }

    @Override
    public Set<Ship> filterByTiePrice(BigDecimal lower, BigDecimal higher) {
        return shipRepository.filterByTiePrice(lower, higher);
    }

    @Override
    public Set<Ship> findByTrip(Long idTrip) {
        return shipRepository.findByTrip(idTrip);
    }

    @Override
    public Set<Ship> findByOwner(Long idOwner) {
        return shipRepository.findByOwner(idOwner);
    }

    @Override
    public void save(Ship ship) {
        shipRepository.save(ship);
    }

    @Override
    public void deleteById(Long id) {
        shipRepository.deleteById(id);
    }
}
