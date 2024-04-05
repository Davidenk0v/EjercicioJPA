package com.practica.jpa.jpa.models.dto;

import com.practica.jpa.jpa.models.Member;
import com.practica.jpa.jpa.models.Trip;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ShipDTO {

    private Long id;
    private String registration;
    private String name;
    private Integer tieNumber;
    private BigDecimal feed;
    private List<Trip> trip;
    private Member owner;

    public ShipDTO() {
    }

    public ShipDTO(Long id, String registration, String name, Integer tieNumber, BigDecimal feed, List<Trip> trip, Member owner) {
        this.id = id;
        this.registration = registration;
        this.name = name;
        this.tieNumber = tieNumber;
        this.feed = feed;
        this.trip = trip;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTieNumber() {
        return tieNumber;
    }

    public void setTieNumber(Integer tieNumber) {
        this.tieNumber = tieNumber;
    }

    public BigDecimal getFeed() {
        return feed;
    }

    public void setFeed(BigDecimal feed) {
        this.feed = feed;
    }

    public List<Trip> getTrip() {
        return trip;
    }

    public void setTrip(List<Trip> trip) {
        this.trip = trip;
    }

    public Member getOwner() {
        return owner;
    }

    public void setOwner(Member owner) {
        this.owner = owner;
    }
}
