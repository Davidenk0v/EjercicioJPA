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

    @GetMapping("/")
    public ResponseEntity<?> getAllMasters(){
        List<BoatMaster> masters = service.findAll();
        if(masters.isEmpty()){
            return new ResponseEntity<>("Boat masters not found", HttpStatus.NOT_FOUND);
        }

        masters.stream()
                .map(master -> masterToDTO(master))
                .toList();

        return new ResponseEntity<>(masters, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<BoatMaster> optionalBoatMaster = service.findById(id);

        if(optionalBoatMaster.isPresent()){
            BoatMaster master = optionalBoatMaster.get();

            BoatMasterDTO masterDTO = masterToDTO(master);

            return new ResponseEntity<>(masterDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("BoatMaster does not exist.", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<String> addBoatMaster(@RequestBody BoatMaster master){
        service.save(master);
        return new ResponseEntity<>("Boat master added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBoatMaster(@PathVariable Long id){
        Optional<BoatMaster> optionalBoatMaster = service.findById(id);

        if(optionalBoatMaster.isPresent()){
            service.deleteById(id);
            return new ResponseEntity<>("Boat master removed successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Boat master does not exist", HttpStatus.BAD_REQUEST);
    }
}
