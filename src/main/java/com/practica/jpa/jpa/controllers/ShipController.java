package com.practica.jpa.jpa.controllers;

import com.practica.jpa.jpa.Mapper;
import com.practica.jpa.jpa.models.dto.ShipDTO;
import com.practica.jpa.jpa.models.Ship;
import com.practica.jpa.jpa.persistence.ShipDAO;
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


    //GETS
    @GetMapping("/")
    public ResponseEntity<?> getAllShips(){
        return service.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/tie-number/{tieNum}")
    public ResponseEntity<?> getByShip(@PathVariable Integer tieNum){
        return service.findByTieNum(tieNum);
    }

    @GetMapping("/feed-prices/{price1}/{price2}")
    public ResponseEntity<?> filterByFeedPrices(@PathVariable BigDecimal price1, @PathVariable BigDecimal price2){
        return service.filterByFeedPrice(price1, price2);
    }

    @GetMapping("/owner/{idOwner}")
    public ResponseEntity<?> findByOwner(@PathVariable Long idOwner){
        return service.findByOwner(idOwner);
    }

    @GetMapping("/trip/{idTrip}")
    public ResponseEntity<?> findByTrip(@PathVariable Long idTrip){
        return service.findByTrip(idTrip);
    }


    //POSTS

    @PostMapping("/")
    public ResponseEntity<String> addShip(@RequestBody Ship ship){
        service.save(ship);
        return new ResponseEntity<>("Ship added successfully", HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody ShipDTO shipDTO){
        return service.update(id, shipDTO);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShip(@PathVariable Long id){
        return service.deleteById(id);
    }
}
