package com.practica.jpa.jpa.controllers.dto;

import com.practica.jpa.jpa.models.Ship;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripDTO {

    private Long id;
    private Date date;
    private String destination;
    private Ship ship;
    private BoatMasterDTO boatMasterDTO;
}
