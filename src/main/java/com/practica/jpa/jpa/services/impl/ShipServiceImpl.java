package com.practica.jpa.jpa.services.impl;

import com.practica.jpa.jpa.models.Ship;
import com.practica.jpa.jpa.persistence.ShipDAO;
import com.practica.jpa.jpa.services.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class ShipServiceImpl implements ShipService {

    @Autowired
    private ShipDAO shipDAO;
    @Override
    public List<Ship> findAll() {
        return shipDAO.findAll();
    }

    @Override
    public Optional<Ship> findById(Long id) {
        return shipDAO.findById(id);
    }

    @Override
    public Optional<Ship> findByTieNum(Integer tieNum) {
        return shipDAO.findByTieNum(tieNum);
    }

    @Override
    public Set<Ship> filterByTiePrice(BigDecimal lower, BigDecimal higher) {
        return shipDAO.filterByFeedPrice(lower, higher);
    }

    @Override
    public Set<Ship> findByTrip(Long idTrip) {
        return shipDAO.findByTrip(idTrip);
    }

    @Override
    public Set<Ship> findByOwner(Long idOwner) {
        return shipDAO.findByOwner(idOwner);
    }

    @Override
    public void save(Ship ship) {
        shipDAO.save(ship);
    }

    @Override
    public void deleteById(Long id) {
        shipDAO.deleteById(id);
    }
}
