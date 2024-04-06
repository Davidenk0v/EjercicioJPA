package com.practica.jpa.jpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "ship")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registration;
    private String name;
    private Integer tieNumber;
    private BigDecimal feed;
    @OneToMany(mappedBy = "ship", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Trip> trips;
    @ManyToOne
    @JoinColumn(name = "id_owner", nullable = false)
    private Member owner;

    public Ship() {
    }

    public Ship(Long id, String registration, String name, Integer tieNumber, BigDecimal feed, List<Trip> trips, Member owner) {
        this.id = id;
        this.registration = registration;
        this.name = name;
        this.tieNumber = tieNumber;
        this.feed = feed;
        this.trips = trips;
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

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public Member getOwner() {
        return owner;
    }

    public void setOwner(Member owner) {
        this.owner = owner;
    }
}
