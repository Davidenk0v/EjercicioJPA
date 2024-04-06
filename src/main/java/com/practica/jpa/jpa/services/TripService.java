package com.practica.jpa.jpa.services;

import com.practica.jpa.jpa.models.Trip;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TripService {
    List<Trip> findAll();
    Optional<Trip> findById(Long id);
    Set<Trip> findByDestination(String destination);
    Set<Trip> findByMaster(Long masterId);
    Set<Trip> findByDate(String date1, String date2) throws ParseException;
    void save(Trip trip);
    void deleteById(Long id);
}
