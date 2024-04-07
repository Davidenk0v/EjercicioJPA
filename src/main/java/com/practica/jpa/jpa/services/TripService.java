package com.practica.jpa.jpa.services;

import com.practica.jpa.jpa.models.Trip;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TripService {
    ResponseEntity<?> findAll();
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?> findByDestination(String destination);
    ResponseEntity<?> findByMaster(Long masterId);
    ResponseEntity<?> findByDate(String date1, String date2) throws ParseException;
    void save(Trip trip);
    ResponseEntity<String> deleteById(Long id);
}
