package com.practica.jpa.jpa.persistence.impl;

import com.practica.jpa.jpa.models.BoatMaster;
import com.practica.jpa.jpa.persistence.BoatMasterDAO;
import com.practica.jpa.jpa.repositories.BoatMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class BoatMasterDAOImpl implements BoatMasterDAO {

    @Autowired
    private BoatMasterRepository boatMasterRepository;
    @Override
    public List<BoatMaster> findAll() {
        return boatMasterRepository.findAll();
    }

    @Override
    public Optional<BoatMaster> findById(Long id) {
       return boatMasterRepository.findById(id);
    }


    @Override
    public void save(BoatMaster boatMaster) {
        boatMasterRepository.save(boatMaster);
    }

    @Override
    public void deleteById(Long id) {
        boatMasterRepository.deleteById(id);
    }
}
