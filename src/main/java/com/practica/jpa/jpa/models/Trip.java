package com.practica.jpa.jpa.models;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String destination;
    @ManyToOne
    @JoinColumn(name = "id_ship", nullable = false)
    private Ship ship;
    @ManyToOne
    @JoinColumn(name = "id_boat_master", nullable = false)
    private BoatMaster boatMaster;

    public Trip() {
    }

    public Trip(Long id, Date date, String destination, Ship ship, BoatMaster boatMaster) {
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
