package com.practica.jpa.jpa.services.impl;

import com.practica.jpa.jpa.models.BoatMaster;
import com.practica.jpa.jpa.persistence.BoatMasterDAO;
import com.practica.jpa.jpa.services.BoatMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class BoatMasterServiceImpl implements BoatMasterService {

    @Autowired
    private BoatMasterDAO boatMasterDAO;
    @Override
    public List<BoatMaster> findAll() {
        return boatMasterDAO.findAll();
    }

    @Override
    public Optional<BoatMaster> findById(Long id) {
       return boatMasterDAO.findById(id);
    }


    @Override
    public void save(BoatMaster boatMaster) {
        boatMasterDAO.save(boatMaster);
    }

    @Override
    public void deleteById(Long id) {
        boatMasterDAO.deleteById(id);
    }
}
