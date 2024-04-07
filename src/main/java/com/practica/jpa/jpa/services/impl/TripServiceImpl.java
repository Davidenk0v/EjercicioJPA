package com.practica.jpa.jpa.services.impl;

import com.practica.jpa.jpa.Mapper;
import com.practica.jpa.jpa.models.Trip;
import com.practica.jpa.jpa.models.dto.TripDTO;
import com.practica.jpa.jpa.persistence.TripDAO;
import com.practica.jpa.jpa.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.practica.jpa.jpa.Mapper.tripToDTO;

@Component
public class TripServiceImpl implements TripService {

    @Autowired
    private TripDAO tripDAO;
    @Override
    public ResponseEntity<?> findAll() {
        List<Trip> trips = tripDAO.findAll();
        if (trips.isEmpty()) {
            return new ResponseEntity<>("Trips not found", HttpStatus.NOT_FOUND);
        }

        trips.stream()
                .map(Mapper::tripToDTO)
                .toList();

        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        Optional<Trip> optionalTrip = tripDAO.findById(id);

        if(optionalTrip.isPresent()){
            Trip trip = optionalTrip.get();

            TripDTO tripDTO = tripToDTO(trip);

            return new ResponseEntity<>(tripDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Trip does not exist.", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> findByDestination(String destination) {
        Set<Trip> trips = tripDAO.findByDestination(destination);

        if(trips.isEmpty()){
            return new ResponseEntity<>("Trips with that destination does not exist.", HttpStatus.NOT_FOUND);
        }

        trips.stream()
                .map(Mapper::tripToDTO)
                .toList();

        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findByMaster(Long masterId) {
        Set<Trip> trips = tripDAO.findByMaster(masterId);

        if(trips.isEmpty()){
            return new ResponseEntity<>("Trips with that boat master does not exist.", HttpStatus.NOT_FOUND);
        }

        trips.stream()
                .map(Mapper::tripToDTO)
                .toList();

        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findByDate(String date1, String date2) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = dateFormat.parse(date1);
            Date endDate = dateFormat.parse(date2);

            Set<Trip> trips = tripDAO.findByDate(startDate, endDate);

        if(trips.isEmpty()){
            return new ResponseEntity<>("There is no trip between these dates.", HttpStatus.NOT_FOUND);
        }
            trips.stream()
                    .map(Mapper::tripToDTO)
                    .toList();

        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    @Override
    public void save(Trip trip) {
        tripDAO.save(trip);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        Optional<Trip> optionalTrip = tripDAO.findById(id);

        if(optionalTrip.isPresent()){
            tripDAO.deleteById(id);
            return new ResponseEntity<>("Trip removed successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Trip does not exist", HttpStatus.BAD_REQUEST);
    }
}
