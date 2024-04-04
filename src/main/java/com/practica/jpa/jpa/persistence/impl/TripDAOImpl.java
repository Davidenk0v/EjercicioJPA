package com.practica.jpa.jpa.persistence.impl;

import com.practica.jpa.jpa.models.Trip;
import com.practica.jpa.jpa.persistence.TripDAO;
import com.practica.jpa.jpa.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class TripDAOImpl implements TripDAO {

    @Autowired
    private TripRepository repository;
    @Override
    public List<Trip> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Trip> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Set<Trip> findByDestination(Long idDestination) {
        return repository.findByDestination(idDestination);
    }

    @Override
    public Set<Trip> findByMaster(Long masterId) {
        return repository.findByMaster(masterId);
    }

    @Override
    public Set<Trip> findByDate(Date date1, Date date2) {
        return repository.findByDate(date1, date2);
    }

    @Override
    public void save(Trip trip) {
        repository.save(trip);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
