package com.practica.jpa.jpa.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ShipRepositoryTest {

    @Autowired
    private ShipRepository shipRepository;

    @Test
    void findByTiemNum() {
        System.out.println(shipRepository.findAll());
    }

    @Test
    void filterByTiePrice() {
    }

    @Test
    void findByTrip() {
    }

    @Test
    void findByOwner() {
    }
}