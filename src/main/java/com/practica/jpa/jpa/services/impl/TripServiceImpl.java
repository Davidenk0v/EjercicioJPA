package com.practica.jpa.jpa.services.impl;

import com.practica.jpa.jpa.Mapper;
import com.practica.jpa.jpa.models.Trip;
import com.practica.jpa.jpa.persistence.TripDAO;
import com.practica.jpa.jpa.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public Set<Trip> findByDestination(String destination) {
        return tripDAO.findByDestination(destination);
    }

    @Override
    public Set<Trip> findByMaster(Long masterId) {
        return tripDAO.findByMaster(masterId);
    }

    @Override
    public Set<Trip> findByDate(String date1, String date2) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = dateFormat.parse(date1);
            Date endDate = dateFormat.parse(date2);
            Set<Trip> trips = tripDAO.findByDate(startDate, endDate);

            trips.stream()
                    .map(Mapper::tripToDTO)
                    .toList();

            return trips;
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
