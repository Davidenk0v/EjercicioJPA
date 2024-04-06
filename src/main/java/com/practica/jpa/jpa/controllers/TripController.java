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

    @GetMapping("/")
    public ResponseEntity<?> getAllTrips() {
        List<Trip> trips = service.findAll();
        if (trips.isEmpty()) {
            return new ResponseEntity<>("Trips not found", HttpStatus.NOT_FOUND);
        }

        trips.stream()
                .map(Mapper::tripToDTO)
                .toList();

        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Trip> optionalTrip = service.findById(id);

        if(optionalTrip.isPresent()){
            Trip trip = optionalTrip.get();

            TripDTO tripDTO = tripToDTO(trip);

            return new ResponseEntity<>(tripDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Trip does not exist.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/destination/{destination}")
    public ResponseEntity<?> getByDestination(@PathVariable String destination){
        Set<Trip> trips = service.findByDestination(destination);

        if(trips.isEmpty()){
            return new ResponseEntity<>("Trips with that destination number does not exist.", HttpStatus.NOT_FOUND);
        }

            trips.stream()
                    .map(Mapper::tripToDTO)
                    .toList();

        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    @GetMapping("/boat-master/{masterId}")
    public ResponseEntity<?> getByBoatMaster(@PathVariable Long masterId){
        Set<Trip> trips = service.findByMaster(masterId);

        if(trips.isEmpty()){
            return new ResponseEntity<>("Trips with that boat master does not exist.", HttpStatus.NOT_FOUND);
        }

        trips.stream()
                .map(Mapper::tripToDTO)
                .toList();

        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    @GetMapping("/date/{date1}/{date2}")
    public ResponseEntity<?> getByDate(@PathVariable String date1, @PathVariable String date2) throws ParseException {
        Set<Trip> trips = service.findByDate(date1, date2);

        if(trips.isEmpty()){
            return new ResponseEntity<>("There is no trip between these dates.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> addTrip(@RequestBody Trip trip){
        service.save(trip);
        return new ResponseEntity<>("Trip added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrip(@PathVariable Long id){
        Optional<Trip> optionalTrip = service.findById(id);

        if(optionalTrip.isPresent()){
            service.deleteById(id);
            return new ResponseEntity<>("Trip removed successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Trip does not exist", HttpStatus.BAD_REQUEST);
    }
}
