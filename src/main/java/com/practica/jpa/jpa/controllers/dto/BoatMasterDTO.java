package com.practica.jpa.jpa.controllers.dto;

import com.practica.jpa.jpa.models.Trip;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoatMasterDTO {


    private Long id;
    private String firstName;
    private String lastName;
    private List<Trip> trips;
}
