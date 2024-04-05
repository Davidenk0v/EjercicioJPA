package com.practica.jpa.jpa;

import com.practica.jpa.jpa.models.dto.BoatMasterDTO;
import com.practica.jpa.jpa.models.dto.MemberDTO;
import com.practica.jpa.jpa.models.dto.ShipDTO;
import com.practica.jpa.jpa.models.dto.TripDTO;
import com.practica.jpa.jpa.models.BoatMaster;
import com.practica.jpa.jpa.models.Member;
import com.practica.jpa.jpa.models.Ship;
import com.practica.jpa.jpa.models.Trip;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static com.practica.jpa.jpa.Mapper.*;
import static org.junit.jupiter.api.Assertions.*;

public class MapperTest {

    @Test
    public void tryMemberToDTO() {
        Member member = new Member(null, "John", "Doe", null);
        MemberDTO memberDTO = memberToDTO(member);
        assertEquals(member.getFirstName(), memberDTO.getFirstName());
        assertEquals(member.getLastName(), memberDTO.getLastName());
    }



    @Test
    public void tryShipToDTO() {
       Ship ship = new Ship(null, "4100ggx", "Barco1", 4, new BigDecimal("32"), null, null);
        ShipDTO shipDTO = shipToDTO(ship);
        assertEquals(ship.getRegistration(), shipDTO.getRegistration());
        assertEquals(ship.getName(), shipDTO.getName());
        assertEquals(ship.getTieNumber(), shipDTO.getTieNumber());
        assertEquals(ship.getFeed(), shipDTO.getFeed());
        assertEquals(ship.getOwner(), shipDTO.getOwner());
    }



    @Test
    public void tryMasterToDTO(){
        BoatMaster master = new BoatMaster(null, "Paco", "Paquito", null);
        BoatMasterDTO masterDTO = masterToDTO(master);
        assertEquals(master.getFirstName(), masterDTO.getFirstName());
        assertEquals(master.getLastName(), masterDTO.getLastName());
    }


    @Test
    public void tryTripToDTO() {
        Trip trip = new Trip(null, new Date(), "Tenerife", null, null);
        TripDTO tripDTO = tripToDTO(trip);
        assertEquals(trip.getDate(), tripDTO.getDate());
        assertEquals(trip.getDestination(), tripDTO.getDestination());
        assertEquals(trip.getShip(), tripDTO.getShip());
        assertEquals(trip.getBoatMaster(), tripDTO.getBoatMaster());
    }
}