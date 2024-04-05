package com.practica.jpa.jpa.models.dto;

import com.practica.jpa.jpa.models.Trip;
import lombok.*;

import java.util.List;

@Data
public class BoatMasterDTO {


    private Long id;
    private String firstName;
    private String lastName;
    private List<Trip> trips;

    public BoatMasterDTO() {
    }

    public BoatMasterDTO(Long id, String firstName, String lastName, List<Trip> trips) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.trips = trips;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
