package com.practica.jpa.jpa.controllers;

import com.practica.jpa.jpa.models.dto.BoatMasterDTO;
import com.practica.jpa.jpa.models.BoatMaster;
import com.practica.jpa.jpa.services.BoatMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.practica.jpa.jpa.Mapper.masterToDTO;

@RestController
@RequestMapping("/api/v1/boat-masters")
public class BoatMasterController {

    @Autowired
    private BoatMasterService service;

    //GETTERS
    @GetMapping("/")
    public ResponseEntity<?> getAllMasters(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return service.findById(id);
    }

    //POSTS
    @PostMapping("/")
    public ResponseEntity<String> addBoatMaster(@RequestBody BoatMaster master){
        service.save(master);
        return new ResponseEntity<>("Boat master added successfully", HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBoatMaster(@PathVariable Long id){
        return service.deleteById(id);
    }
}
