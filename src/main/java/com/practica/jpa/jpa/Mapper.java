package com.practica.jpa.jpa;

import com.practica.jpa.jpa.models.dto.BoatMasterDTO;
import com.practica.jpa.jpa.models.dto.MemberDTO;
import com.practica.jpa.jpa.models.dto.ShipDTO;
import com.practica.jpa.jpa.models.dto.TripDTO;
import com.practica.jpa.jpa.models.BoatMaster;
import com.practica.jpa.jpa.models.Member;
import com.practica.jpa.jpa.models.Ship;
import com.practica.jpa.jpa.models.Trip;
import org.springframework.context.annotation.Bean;

public class Mapper {

    @Bean
    public static MemberDTO memberToDTO(Member member) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(member.getId());
        memberDTO.setFirstName(member.getFirstName());
        memberDTO.setLastName(member.getLastName());
        memberDTO.setShips(member.getShips());
        return memberDTO;
    }
    @Bean
    public static ShipDTO shipToDTO(Ship ship){
        ShipDTO shipDTO = new ShipDTO();
        shipDTO.setId(ship.getId());
        shipDTO.setRegistration(ship.getRegistration());
        shipDTO.setName(ship.getName());
        shipDTO.setTieNumber(ship.getTieNumber());
        shipDTO.setFeed(ship.getFeed());
        shipDTO.setTrip(ship.getTrips());
        shipDTO.setOwner(ship.getOwner());
        return shipDTO;
    }

    @Bean
    public static BoatMasterDTO masterToDTO(BoatMaster master){
        BoatMasterDTO masterDTO = new BoatMasterDTO();
        masterDTO.setId(master.getId());
        masterDTO.setFirstName(master.getFirstName());
        masterDTO.setLastName(master.getLastName());
        masterDTO.setTrips(master.getTrips());
        return masterDTO;
    }

    @Bean
    public static TripDTO tripToDTO(Trip trip){
        TripDTO tripDTO = new TripDTO();
        tripDTO.setId(trip.getId());
        tripDTO.setDate(trip.getDate());
        tripDTO.setDestination(trip.getDestination());
        tripDTO.setShip(trip.getShip());
        tripDTO.setBoatMaster(trip.getBoatMaster());
        return tripDTO;
    }


}
