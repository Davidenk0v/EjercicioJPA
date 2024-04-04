package com.practica.jpa.jpa.persistence;

import com.practica.jpa.jpa.models.BoatMaster;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BoatMasterDAO {
    List<BoatMaster> findAll();
    Optional<BoatMaster> findById(Long id);
    void save(BoatMaster boatMaster);
    void deleteById(Long id);
}
