package com.practica.jpa.jpa.models.dto;

import com.practica.jpa.jpa.models.BoatMaster;
import com.practica.jpa.jpa.models.Ship;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
public class TripDTO {

    private Long id;
    private Date date;
    private String destination;
    private Ship ship;
    private BoatMaster boatMaster;

    public TripDTO() {
    }

    public TripDTO(Long id, Date date, String destination, Ship ship, BoatMaster boatMaster) {
        this.id = id;
        this.date = date;
        this.destination = destination;
        this.ship = ship;
        this.boatMaster = boatMaster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public BoatMaster getBoatMaster() {
        return boatMaster;
    }

    public void setBoatMaster(BoatMaster boatMaster) {
        this.boatMaster = boatMaster;
    }
}
