package com.practica.jpa.jpa.repositories;

import com.practica.jpa.jpa.models.Member;
import com.practica.jpa.jpa.models.Ship;
import com.practica.jpa.jpa.models.Trip;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ShipRepositoryTest {

    @Autowired
    private ShipRepository repository;
    @Test
    @Order(1)
    void checkIfTiemNumCorrect() { // Test para comprobar que el barco recogido es el correcto
        Ship ship = repository.findByTiemNum(10).get();
        assertNotNull(ship);
        assertEquals(ship.getId().toString(), "10");
        assertEquals(ship.getName(), "OCTINOXATE, OXYBENZONE");
        assertEquals(ship.getTieNumber().toString(), "10");
        assertEquals(ship.getFeed().toString(), "49.27");
    }

    @Test
    @Order(2)
    void checkRangeOfPrice() { // Test para probar que todos los barcos que devuelve se encuentran en los precios indicados
        BigDecimal price1 = new BigDecimal("40");
        BigDecimal price2 = new BigDecimal("50");
        Set<Ship> ships = repository.filterByFeedPrice(price1, price2);
        assertNotNull(ships);
        assertTrue(checkFeed(ships, price1, price2));
    }

    @Test
    @Order(3)
    void shipWithCorrectTrip() { //Comprueba que lo que barcos que devuelve tienen el trip con id 7 en sus viajes
        Set<Ship> ships = repository.findByTrip(Long.valueOf(7));

        assertNotNull(ships);
        assertTrue(checkTrip(ships, 7));
    }

    @Test
    @Order(4)
    void ownerIsCorrect() { //Test para comprobar si el numero de dueño es el indicado con el solicitado
        Set<Ship> ships = repository.findByOwner(Long.valueOf(1));
        assertNotNull(ships);
        assertTrue(checkOwner(ships, 1));
    }



    //FUNCIONES DE APOYO PARA LOS TEST

    private boolean checkOwner(Set<Ship> ships, int value) { //Funcion para recorrer los barcos para comprobar su dueño
        for (Ship ship : ships) {
                if (ship.getOwner().getId().intValue() != value) {
                    return false;
                }
            }
        return true;
    }

    //Funcion para recorrer los barcos y devolver false si encuentra alguno con un precio no indicado
    private boolean checkFeed(Set<Ship> ships, BigDecimal price1, BigDecimal price2) {
        for (Ship ship : ships) {
            if (ship.getFeed().compareTo(price1) >= 0 || ship.getFeed().compareTo(price2) < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean checkTrip(Set<Ship> ships, int value) { //Funcion para recorrer los viajes de los barcos para comprobar su id
        for (Ship ship : ships) {
            for (Trip trip : ship.getTrips()) {
                System.out.println(trip.getDestination());
                if (trip.getId().intValue() == value) {
                    return true;
                }
            }
        }
        return false;
    }
}