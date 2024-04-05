package com.practica.jpa.jpa.controllers;

import com.practica.jpa.jpa.Mapper;
import com.practica.jpa.jpa.models.dto.ShipDTO;
import com.practica.jpa.jpa.models.Ship;
import com.practica.jpa.jpa.services.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.practica.jpa.jpa.Mapper.shipToDTO;

@RestController
@RequestMapping("/api/v1/ships")
public class ShipController {

    @Autowired
    private ShipService service;

    @GetMapping("/")
    public ResponseEntity<?> getAllShips(){
        List<Ship> ships = service.findAll();
        if(ships.isEmpty()){
            return new ResponseEntity<>("Ships not found", HttpStatus.NOT_FOUND);
        }

        ships.stream()
                .map(Mapper::shipToDTO)
                .toList();

        return new ResponseEntity<>(ships, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Ship> optionalShip = service.findById(id);

        if(optionalShip.isPresent()){
            Ship ship = optionalShip.get();

            ShipDTO shipDTO = shipToDTO(ship);

            return new ResponseEntity<>(shipDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Ship does not exist.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/tie-number/{tieNum}")
    public ResponseEntity<?> getByShip(@PathVariable Integer tieNum){
        Optional<Ship> optionalShip = service.findByTieNum(tieNum);

        if(optionalShip.isPresent()){
            Ship ship = optionalShip.get();

            ShipDTO shipDTO = shipToDTO(ship);

            return new ResponseEntity<>(shipDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Ship with that tien number does not exist.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/feed-prices/{price1}/{price2}")
    public ResponseEntity<?> filterByFeedPrices(@PathVariable BigDecimal price1, @PathVariable BigDecimal price2){
        Set<Ship> ships = service.filterByTiePrice(price1, price2);
        if(ships.isEmpty()){
            return new ResponseEntity<>("There are no feeds in this range", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ships, HttpStatus.OK);
    }


    @PostMapping("/")
    public ResponseEntity<String> addShip(@RequestBody Ship ship){
        service.save(ship);
        return new ResponseEntity<>("Ship added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShip(@PathVariable Long id){
        Optional<Ship> optionalShip = service.findById(id);

        if(optionalShip.isPresent()){
            service.deleteById(id);
            return new ResponseEntity<>("Ship removed successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Ship does not exist", HttpStatus.BAD_REQUEST);
    }
}
