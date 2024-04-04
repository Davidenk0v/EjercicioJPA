package com.practica.jpa.jpa.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
}
