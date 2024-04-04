package com.practica.jpa.jpa.services;

import com.practica.jpa.jpa.models.Trip;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TripService {
    List<Trip> findAll();
    Optional<Trip> findById(Long id);
    Set<Trip> findByDestination(Long idDestination);
    Set<Trip> findByMaster(Long masterId);
    Set<Trip> findByDate(Date date1, Date date2);
    void save(Trip trip);
    void deleteById(Long id);
}
