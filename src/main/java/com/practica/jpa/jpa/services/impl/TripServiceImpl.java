package com.practica.jpa.jpa.services.impl;

import com.practica.jpa.jpa.models.Trip;
import com.practica.jpa.jpa.persistence.TripDAO;
import com.practica.jpa.jpa.repositories.TripRepository;
import com.practica.jpa.jpa.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class TripServiceImpl implements TripService {

    @Autowired
    private TripDAO tripDAO;
    @Override
    public List<Trip> findAll() {
        return tripDAO.findAll();
    }

    @Override
    public Optional<Trip> findById(Long id) {
        return tripDAO.findById(id);
    }

    @Override
    public Set<Trip> findByDestination(Long idDestination) {
        return tripDAO.findByDestination(idDestination);
    }

    @Override
    public Set<Trip> findByMaster(Long masterId) {
        return tripDAO.findByMaster(masterId);
    }

    @Override
    public Set<Trip> findByDate(Date date1, Date date2) {
        return tripDAO.findByDate(date1, date2);
    }

    @Override
    public void save(Trip trip) {
        tripDAO.save(trip);
    }

    @Override
    public void deleteById(Long id) {
        tripDAO.deleteById(id);
    }
}
