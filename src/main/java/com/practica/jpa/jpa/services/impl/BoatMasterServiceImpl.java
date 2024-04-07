package com.practica.jpa.jpa.services.impl;

import com.practica.jpa.jpa.Mapper;
import com.practica.jpa.jpa.models.BoatMaster;
import com.practica.jpa.jpa.models.dto.BoatMasterDTO;
import com.practica.jpa.jpa.persistence.BoatMasterDAO;
import com.practica.jpa.jpa.services.BoatMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.practica.jpa.jpa.Mapper.masterToDTO;

@Component
public class BoatMasterServiceImpl implements BoatMasterService {

    @Autowired
    private BoatMasterDAO boatMasterDAO;
    @Override
    public ResponseEntity<?> findAll() {
        List<BoatMaster> masters = boatMasterDAO.findAll();
        if(masters.isEmpty()){
            return new ResponseEntity<>("Boat masters not found", HttpStatus.NOT_FOUND);
        }

        masters.stream()
                .map(Mapper::masterToDTO)
                .toList();

        return new ResponseEntity<>(masters, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        Optional<BoatMaster> optionalBoatMaster = boatMasterDAO.findById(id);

        if(optionalBoatMaster.isPresent()){
            BoatMaster master = optionalBoatMaster.get();

            BoatMasterDTO masterDTO = masterToDTO(master);

            return new ResponseEntity<>(masterDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("BoatMaster does not exist.", HttpStatus.NOT_FOUND);
    }


    @Override
    public void save(BoatMaster boatMaster) {
        boatMasterDAO.save(boatMaster);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        Optional<BoatMaster> optionalBoatMaster = boatMasterDAO.findById(id);

        if(optionalBoatMaster.isPresent()){
            boatMasterDAO.deleteById(id);
            return new ResponseEntity<>("Boat master removed successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Boat master does not exist", HttpStatus.BAD_REQUEST);
    }
}
