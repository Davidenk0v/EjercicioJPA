package com.practica.jpa.jpa.repositories;

import com.practica.jpa.jpa.models.Trip;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TripRepositoryTest {
    @Autowired
   private TripRepository repository;
    @Test
    void destinationIsCorrect() {  //Comprueba que la destinacion de los viajes es la deseada
        ArrayList<String> test = new ArrayList<>();
        test.add("Indonesia");
        test.add("Indonesia");
        ArrayList<String> destinatios = new ArrayList<>();
        Set<Trip> trips = repository.findByDestination("Indonesia");
        for(Trip trip : trips){
            destinatios.add(trip.getDestination());
        }
        assertEquals(destinatios, test);
    }

    @Test
    void masterIsCorrect() { // Comprueba que el capitan de los barcos es el solicitado
        ArrayList<String> test = new ArrayList<>();
        test.add("Sallyanne");
        ArrayList<String> masters = new ArrayList<>();
        Set<Trip> trips = repository.findByMaster(Long.valueOf(1));
        for(Trip trip : trips){
            masters.add(trip.getBoatMaster().getFirstName());
        }
        assertEquals(masters, test);
    }

    @Test
    void checkDateOfTrips() throws ParseException { // Comprueba que las fechas de los viajes estan en el rango deseado
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse("2023-05-01");
        Date date2 = dateFormat.parse("2023-06-30");
        Set<Trip> trips = repository.findByDate(date1, date2);
        assertTrue(checkDate(trips, date1, date2));
    }

    private boolean checkDate(Set<Trip> trips, Date date1, Date date2){
        for(Trip trip : trips){
            if(trip.getDate().before(date1) || trip.getDate().after(date2)){
                return false;
            }
        }
        return true;
    }

}