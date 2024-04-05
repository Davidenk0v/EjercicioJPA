package com.practica.jpa.jpa.models.dto;

import com.practica.jpa.jpa.models.Ship;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
public class MemberDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Set<Ship> ships = new HashSet<>();

    public MemberDTO() {
    }

    public MemberDTO(Long id, String firstName, String lastName, Set<Ship> ships) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ships = ships;
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

    public Set<Ship> getShips() {
        return ships;
    }

    public void setShips(Set<Ship> ships) {
        this.ships = ships;
    }

}
