package com.practica.jpa.jpa.controllers;

import com.practica.jpa.jpa.Mapper;
import com.practica.jpa.jpa.models.dto.TripDTO;
import com.practica.jpa.jpa.models.Trip;
import com.practica.jpa.jpa.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.practica.jpa.jpa.Mapper.tripToDTO;

@RestController
@RequestMapping("/api/v1/trips")
public class TripController {

    @Autowired
    private TripService service;

    //GETTERS
    @GetMapping("/")
    public ResponseEntity<?> getAllTrips() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/destination/{destination}")
    public ResponseEntity<?> getByDestination(@PathVariable String destination){
        return service.findByDestination(destination);
    }

    @GetMapping("/boat-master/{masterId}")
    public ResponseEntity<?> getByBoatMaster(@PathVariable Long masterId){
        return service.findByMaster(masterId);
    }

    @GetMapping("/date/{date1}/{date2}")
    public ResponseEntity<?> getByDate(@PathVariable String date1, @PathVariable String date2) throws ParseException {
        return service.findByDate(date1, date2);
    }

    //POSTS
    @PostMapping("/")
    public ResponseEntity<String> addTrip(@RequestBody Trip trip){
        service.save(trip);
        return new ResponseEntity<>("Trip added successfully", HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrip(@PathVariable Long id){
        return service.deleteById(id);
    }
}
