package com.practica.jpa.jpa.services.impl;

import com.practica.jpa.jpa.Mapper;
import com.practica.jpa.jpa.models.Ship;
import com.practica.jpa.jpa.models.dto.ShipDTO;
import com.practica.jpa.jpa.persistence.ShipDAO;
import com.practica.jpa.jpa.services.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.practica.jpa.jpa.Mapper.shipToDTO;

@Component
public class ShipServiceImpl implements ShipService {

    @Autowired
    private ShipDAO shipDAO;
    @Override
    public ResponseEntity<?> findAll() {
        List<Ship> ships = shipDAO.findAll();
        if(ships.isEmpty()){
            return new ResponseEntity<>("Ships not found", HttpStatus.NOT_FOUND);
        }

        ships.stream()
                .map(Mapper::shipToDTO)
                .toList();

        return new ResponseEntity<>(ships, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        Optional<Ship> optionalShip = shipDAO.findById(id);

        if(optionalShip.isPresent()){
            Ship ship = optionalShip.get();

            ShipDTO shipDTO = shipToDTO(ship);

            return new ResponseEntity<>(shipDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Ship does not exist.", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> findByTieNum(Integer tieNum) {

        Optional<Ship> optionalShip = shipDAO.findByTieNum(tieNum);

        if(optionalShip.isPresent()){
            Ship ship = optionalShip.get();

            ShipDTO shipDTO = shipToDTO(ship);

            return new ResponseEntity<>(shipDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Ship with that tien number does not exist.", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> filterByFeedPrice(BigDecimal lower, BigDecimal higher) {
        Set<Ship> ships = shipDAO.filterByFeedPrice(lower, higher);
        if(ships.isEmpty()){
            return new ResponseEntity<>("There are no feeds in this range", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ships, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findByTrip(Long idTrip) {
        Set<Ship> ships = shipDAO.findByOwner(idTrip);
        if(ships.isEmpty()){
            return new ResponseEntity<>("No ships were found for this destination", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ships, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findByOwner(Long idOwner) {
        Set<Ship> ships = shipDAO.findByOwner(idOwner);
        if(ships.isEmpty()){
            return new ResponseEntity<>("No ships were found for this member", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ships, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> update(Long id, ShipDTO shipDto) {
        Optional<Ship> shipOptional = shipDAO.findById(id);

        if(shipOptional.isPresent()){
            Ship ship = shipOptional.get();
            ship.setName(shipDto.getName());
            ship.setRegistration(shipDto.getRegistration());
            ship.setTieNumber(shipDto.getTieNumber());
            ship.setFeed(shipDto.getFeed());
            ship.setTrips(shipDto.getTrip());
            ship.setOwner(shipDto.getOwner());

            shipDAO.save(ship);
            return new ResponseEntity<>("ship successfully updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Ship does not exists!", HttpStatus.BAD_REQUEST);
    }

    @Override
    public void save(Ship ship) {
        shipDAO.save(ship);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        Optional<Ship> optionalShip = shipDAO.findById(id);

        if(optionalShip.isPresent()){
            shipDAO.deleteById(id);
            return new ResponseEntity<>("Ship removed successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Ship does not exist", HttpStatus.BAD_REQUEST);
    }
}
